package com.grocery;

import java.util.ArrayList;

import com.grocery.Element;
import com.grocery.ItemDetails;
import com.grocery.NutrientDetail;
import com.grocery.Ratings;

public class DataHelper {

	public DataHelper() {
	}
	
	public static ItemDetails getData(int k) {
		
		ItemDetails item = new ItemDetails();
		NutrientDetail detail[] = new NutrientDetail[4];
		ArrayList<NutrientDetail> nutrientDetails = new ArrayList<NutrientDetail>();
		Ratings ratings = new Ratings();
		Element nutrientDensity = new Element();
		Element addedSugars = new Element();
		ArrayList<Element> pointsBreakup = new ArrayList<Element>();
		
		
		switch(k) {
			
			case 1:
				//Use Case #1 - Point Rule 2 with > 10%
				//Use Case #1 - Star Rule 2 stars with points >= 5
			
				item = new ItemDetails();
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
			    addedSugars = new Element();
			    addedSugars.setElementId(2);
			    addedSugars.setElementName("Added Sugars");
			    addedSugars.setPoints(0.);
			    pointsBreakup.add(0,nutrientDensity);	    
			    pointsBreakup.add(1,addedSugars);	    
			    ratings.setPointsBreakup(pointsBreakup);
			    item.setRatings(ratings);
		    break;
		    
			case 2:
				//Use Case #1 - Point Rule 3 with > 10%	
		    
				item = new ItemDetails();
			    item.setUpc("000212312331212");
			    item.setName("Lime juice V1");
			    item.setAlgorithmId("G");
			    item.setIngredientTxt("Sugar, Salt, Water, Lime Juice");	    
			    nutrientDetails = new ArrayList<NutrientDetail>();
			    detail[0] = new NutrientDetail();
			    detail[0].setId(2);
			    detail[0].setDescription("Biotin"); //<-------------
			    detail[0].setQty(10.2);
			    detail[0].setUom("grams");
			    detail[0].setPctDVValue(13); //<-------------
			    nutrientDetails.add(detail[0]);
			    detail[1] = new NutrientDetail();
			    detail[1].setId(3);
			    detail[1].setDescription("Calcium"); //<-------------
			    detail[1].setQty(10.2);
			    detail[1].setUom("grams");
			    detail[1].setPctDVValue(12); //<-------------
			    nutrientDetails.add(detail[1]);
			    detail[2] = new NutrientDetail();
			    detail[2].setId(4);
			    detail[2].setDescription("Chromium"); //<-------------
			    detail[2].setQty(10.2);
			    detail[2].setUom("grams");
			    detail[2].setPctDVValue(11); //<-------------
			    nutrientDetails.add(detail[2]);
			    detail[3] = new NutrientDetail();
			    detail[3].setId(1);
			    detail[3].setDescription("Calories");
			    detail[3].setQty(100.0);
			    detail[3].setUom("grams");
			    nutrientDetails.add(detail[3]);
			    item.setNutrientDetails(nutrientDetails);	    
			    ratings = new Ratings();
			    ratings.setRating(0);
			    ratings.setPoints(0);
			    nutrientDensity= new Element();
			    nutrientDensity.setElementId(1);
			    nutrientDensity.setElementName("Nutrient Density");
			    nutrientDensity.setPoints(0.);
			    addedSugars = new Element();
			    addedSugars.setElementId(2);
			    addedSugars.setElementName("Added Sugars");
			    addedSugars.setPoints(0.);
			    pointsBreakup = new ArrayList<Element>();
			    pointsBreakup.add(0,nutrientDensity);	    
			    pointsBreakup.add(1,addedSugars);	    
			    ratings.setPointsBreakup(pointsBreakup);
			    item.setRatings(ratings);
		    break;
		    
			case 3:
				//Use Case #1 - Point Rule 3 with > 5%	
		    
				item = new ItemDetails();
			    item.setUpc("000212312331212");
			    item.setName("Lime juice V2");
			    item.setAlgorithmId("G");
			    item.setIngredientTxt("Sugar, Salt, Water, Lime Juice");	    
			    nutrientDetails = new ArrayList<NutrientDetail>();
			    detail[0] = new NutrientDetail();
			    detail[0].setId(3);
			    detail[0].setDescription("Biotin"); //<-------------
			    detail[0].setQty(10.2);
			    detail[0].setUom("grams");
			    detail[0].setPctDVValue(8); //<-------------
			    nutrientDetails.add(detail[0]);
			    detail[1] = new NutrientDetail();
			    detail[1].setId(3);
			    detail[1].setDescription("Calcium"); //<-------------
			    detail[1].setQty(10.2);
			    detail[1].setUom("grams");
			    detail[1].setPctDVValue(7); //<-------------
			    nutrientDetails.add(detail[1]);
			    detail[2] = new NutrientDetail();
			    detail[2].setId(3);
			    detail[2].setDescription("Chromium"); //<-------------
			    detail[2].setQty(10.2);
			    detail[2].setUom("grams");
			    detail[2].setPctDVValue(6); //<-------------
			    nutrientDetails.add(detail[2]);
			    detail[3] = new NutrientDetail();
			    detail[3].setId(1);
			    detail[3].setDescription("Calories");
			    detail[3].setQty(100.0);
			    detail[3].setUom("grams");
			    nutrientDetails.add(detail[3]);
			    item.setNutrientDetails(nutrientDetails);	    
			    ratings = new Ratings();
			    ratings.setRating(0);
			    ratings.setPoints(0);
			    nutrientDensity = new Element();
			    nutrientDensity.setElementId(1);
			    nutrientDensity.setElementName("Nutrient Density");
			    nutrientDensity.setPoints(0.);
			    addedSugars = new Element();
			    addedSugars.setElementId(2);
			    addedSugars.setElementName("Added Sugars");
			    addedSugars.setPoints(0.);
			    pointsBreakup = new ArrayList<Element>();
			    pointsBreakup.add(0,nutrientDensity);	    
			    pointsBreakup.add(1,addedSugars);	    
			    ratings.setPointsBreakup(pointsBreakup);
			    item.setRatings(ratings);
		    break;
		    
			case 4:
		    	//Use Case #2
		    
				item = new ItemDetails();
			    item.setUpc("000212312331212");
			    item.setName("Lime juice V3");
			    item.setAlgorithmId("G");
			    item.setIngredientTxt("Sugar, Salt, Water, Lime Juice, Wheat, Wheat berries");  //<-------------	    
			    nutrientDetails = new ArrayList<NutrientDetail>();
			    detail[0] = new NutrientDetail();
			    detail[0].setId(1);
			    detail[0].setDescription("EPA"); //<-------------
			    detail[0].setQty(6.2);  //<-------------
			    detail[0].setUom("mg");
			    nutrientDetails.add(detail[0]);
			    detail[1] = new NutrientDetail();
			    detail[1].setId(2);
			    detail[1].setDescription("DHA"); //<-------------
			    detail[1].setQty(7.3);  //<-------------
			    detail[1].setUom("mg");
			    nutrientDetails.add(detail[1]);
			    detail[2] = new NutrientDetail();
			    detail[2].setId(1);
			    detail[2].setDescription("Calories");
			    detail[2].setQty(100.0);
			    detail[2].setUom("grams");
			    nutrientDetails.add(detail[2]);
			    item.setNutrientDetails(nutrientDetails);	    
			    ratings = new Ratings();
			    ratings.setRating(0);
			    ratings.setPoints(0);
			    nutrientDensity = new Element();
			    nutrientDensity.setElementId(1);
			    nutrientDensity.setElementName("Nutrient Density");
			    nutrientDensity.setPoints(0.);
			    addedSugars = new Element();
			    addedSugars.setElementId(2);
			    addedSugars.setElementName("Added Sugars");
			    addedSugars.setPoints(0.);
			    pointsBreakup = new ArrayList<Element>();
			    pointsBreakup.add(0,nutrientDensity);	    
			    pointsBreakup.add(1,addedSugars);	    
			    ratings.setPointsBreakup(pointsBreakup);
			    item.setRatings(ratings);
		    break;
		    
			case 5:		    
				//Use Case #3
		    
				item = new ItemDetails();
			    item.setUpc("000212312331212");
			    item.setName("Lime juice V4");
			    item.setAlgorithmId("G");
			    item.setIngredientTxt("Sugar, Salt, Water, Lime Juice, Sweetener");  //<-------------	    
			    nutrientDetails = new ArrayList<NutrientDetail>();
			    detail[0] = new NutrientDetail();
			    detail[0].setId(1);
			    detail[0].setDescription("Calories");
			    detail[0].setQty(100.0);
			    detail[0].setUom("grams");
			    nutrientDetails.add(detail[0]);
			    item.setNutrientDetails(nutrientDetails);	    
			    ratings = new Ratings();
			    ratings.setRating(0);
			    ratings.setPoints(0);
			    nutrientDensity = new Element();
			    nutrientDensity.setElementId(1);
			    nutrientDensity.setElementName("Nutrient Density");
			    nutrientDensity.setPoints(0.);
			    addedSugars = new Element();
			    addedSugars.setElementId(1);
			    addedSugars.setElementName("Added Sugars");
			    addedSugars.setQty(3.0);
			    addedSugars.setPoints(0.);
			    pointsBreakup = new ArrayList<Element>();
			    pointsBreakup.add(0,nutrientDensity);	    
			    pointsBreakup.add(1,addedSugars);	    
			    ratings.setPointsBreakup(pointsBreakup);
			    item.setRatings(ratings);
		    break;
		    
		}
	    
	    return item;
		
	}

}
