package com.grocery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import com.google.gson.Gson;
import com.grocery.Element;
import com.grocery.ItemDetails;
import com.grocery.NutrientDetail;
import com.grocery.Ratings;

public class Client {
	
	  private static final String containerName = "Diet-Ratings_1.0.0-SNAPSHOT";
	  private static final String sessionName = "grocery-stateless-ksession";
	  private static final String protocol = "http";
	  private static final String hostname = "autoaws";
	  private static final String port = "8080";

	public static void main(String[] args) {

	    Gson gson = new Gson();
		
		ItemDetails item = new ItemDetails();
	    ItemDetails input[] = new ItemDetails[1];
		ItemDetails output[];
		NutrientDetail detail[] = new NutrientDetail[4];
		ArrayList<NutrientDetail> nutrientDetails = new ArrayList<NutrientDetail>();
		Ratings ratings = new Ratings();
		ArrayList<Element> pointsBreakup = new ArrayList<Element>();
		Element nutrientDensity = new Element();
		Element addedSugars = new Element();
	    
	    item.setUpc("000212312331212");
	    item.setName("Lime juice V0");
	    item.setAlgorithmId("G");
	    item.setIngredientTxt("Sugar, Salt, Water, Lime Juice");	    
	    nutrientDetails = new ArrayList<NutrientDetail>();
	    detail[0] = new NutrientDetail();
	    detail[0].setId(1);
	    detail[0].setDescription("Calories");
	    detail[0].setQty(100.0);
	    detail[0].setUom("grams");
	    nutrientDetails.add(detail[0]);
	    detail[1] = new NutrientDetail();
	    detail[1].setId(2);
	    detail[1].setDescription("Calcium"); //<-------------
	    detail[1].setQty(10.2);
	    detail[1].setUom("grams");
	    detail[1].setPctDVValue(12); //<-------------
	    nutrientDetails.add(detail[1]);
	    detail[2] = new NutrientDetail();
	    detail[2].setId(3);
	    detail[2].setDescription("Chromium"); //<-------------
	    detail[2].setQty(10.2);
	    detail[2].setUom("grams");
	    detail[2].setPctDVValue(11); //<-------------
	    nutrientDetails.add(detail[2]);
	    item.setNutrientDetails(nutrientDetails);	    
	    ratings = new Ratings();
	    ratings.setRating(0);
	    ratings.setPoints(0);
	    pointsBreakup = new ArrayList<Element>();
	    nutrientDensity = new Element();
	    nutrientDensity.setElementId(1);
	    nutrientDensity.setElementName("Nutrient Density");
	    nutrientDensity.setPoints(0.);
	    pointsBreakup.add(nutrientDensity);	    
	    addedSugars = new Element();
	    addedSugars.setElementId(1);
	    addedSugars.setElementName("Added Sugars");
	    addedSugars.setPoints(0.);
	    pointsBreakup.add(addedSugars);	    
	    ratings.setPointsBreakup(pointsBreakup);
	    item.setRatings(ratings);
	    
	    input[0] = item;
	    System.out.println("input: \n"+gson.toJson(input[0]));
	    
	    output = runKieServer(input);	    
	    System.out.println("output: \n"+gson.toJson(output[0]));
	    
	}
	
	static public ItemDetails[] runKieServer(ItemDetails input[]) {
		
		ItemDetails[] output = new ItemDetails[input.length];
		
		try {
			
		      Set<Class<?>> allClasses = new HashSet<Class<?>>();
		      allClasses.add(ItemDetails.class);
		      
		      String serverUrl = protocol+"://"+hostname+":"+port+"/kie-server/services/rest/server";
		      String username = "kieserver";
		      String password = "kieserver1!";
		      KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(serverUrl,username,password);		      
		      config.setMarshallingFormat(MarshallingFormat.JAXB);
		      config.addExtraClasses(allClasses);		      
		      KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(config);
		      
		      KieCommands kieCommands = KieServices.Factory.get().getCommands();
		      @SuppressWarnings("rawtypes")
			  List<Command> commandList = new ArrayList<Command>();
		      for (int i = 0; i < input.length; i++) {
		    	  System.out.println("Inserting fact # "+i);;
		    	  commandList.add(kieCommands.newInsert(input[i], input[i].getName()));
		      }
		      commandList.add(kieCommands.newFireAllRules("numberOfFiredRules"));
		      BatchExecutionCommand batch = kieCommands.newBatchExecution(commandList, sessionName);
		      
		      RuleServicesClient ruleClient = kieServicesClient.getServicesClient(RuleServicesClient.class);		      
		      ServiceResponse<ExecutionResults> executeResponse = ruleClient.executeCommandsWithResults(containerName, batch);
		      
		      System.out.println("Response Type: " + executeResponse.getType());
		      System.out.println("Response Message: " + executeResponse.getMsg());
		      if (executeResponse.getResult() == null) {
		    	  System.out.println("Response Result is null");;
		      } else {
			      Collection<String> identifiers = executeResponse.getResult().getIdentifiers();
			      System.out.println("number of results: "+identifiers.size());
			      Iterator<String> i = identifiers.iterator();
			      while(i.hasNext()) {
			    	  String identifier = i.next();
			    	  System.out.println("   result identifier: "+identifier);
			    	  if (!identifier.equals("numberOfFiredRules")) {
				    	  ItemDetails iD = (ItemDetails)executeResponse.getResult().getValue(identifier);
				    	  //int k = Character.getNumericValue(iD.getName().charAt(12));
				    	  output[0] = iD;
			    	  }
			      }
			      System.out.println("number of fired rules: " + executeResponse.getResult().getValue("numberOfFiredRules"));
		      }
		      
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
	    return output;

	}

}
