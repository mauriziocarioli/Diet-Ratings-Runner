package com.grocery;

import java.util.ArrayList;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.google.gson.Gson;
import com.grocery.Element;
import com.grocery.ItemDetails;
import com.grocery.NutrientDetail;
import com.grocery.Ratings;

import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;

public class Calculate {
	
	  private static final String groupId = "com.grocery";
	  private static final String artifactId = "Diet-Ratings-Runner";
	  private static final String version = "1.0.0-SNAPSHOT";

	public static void main(String[] args) {

		Gson gson = new Gson();
	    ItemDetails item = new ItemDetails();
	    ItemDetails input[] = new ItemDetails[1];
	    @SuppressWarnings("unused")
		ItemDetails output[];
		NutrientDetail detail[] = new NutrientDetail[4];
		ArrayList<NutrientDetail> nutrientDetails = new ArrayList<NutrientDetail>();
		Ratings ratings = new Ratings();
		ArrayList<Element> pointsBreakup = new ArrayList<Element>();
		Element nutrientDensity = new Element();
		Element addedSugars = new Element();
	    
	    item.setUpc("000212312331212");
	    item.setName("Lime juice");
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
	    
	    runDrools(input);
	    System.out.println("input after Drools execution: \n"+gson.toJson(input[0]));
	    
	}
	
	static public void runDrools(ItemDetails[] input) {
		
		try {
				
			KieServices kServices = KieServices.Factory.get();
		    ReleaseId releaseId = kServices.newReleaseId( groupId, artifactId, version );
		    KieContainer kContainer = kServices.newKieContainer(releaseId);
		    KieSession kSession = kContainer.newKieSession( "default-stateful-kie-session" );
	        kSession.addEventListener( new DebugAgendaEventListener() );
	        kSession.addEventListener( new DebugRuleRuntimeEventListener() );
			kServices.getLoggers().newConsoleLogger(kSession);
	        kServices.getLoggers().newFileLogger( kSession, "./target/drools" );
			
			
		    
	        for (int i = 0; i < input.length; i++) {
	        	kSession.insert(input[i]);
	        }
		    kSession.fireAllRules();
		    kSession.dispose();
		    //kContainer.dispose();
		
		} catch (Throwable t) {
			t.printStackTrace();
		}
	 
	}
	
}
