package com.grocery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.google.gson.Gson;
import com.grocery.Calculate;
import com.grocery.DataHelper;
import com.grocery.ItemDetails;

public class CalculateTest2 {

	int k = 2;	
    Gson gson = new Gson();				
	ItemDetails[] item = new ItemDetails[1];
	
	@Before
	public void prepareData() {
		
		item[0] = DataHelper.getData(k);
		System.out.println("INPUT DATA");
	    for (int i = 0; i < item.length; i++) {
	    	System.out.println("\n"+gson.toJson(item[i]));
	    }
	    
	}
	
	@Test
	public void testRunDrools() {
					    
	    Calculate.runDrools(item);
	    
		System.out.println("OUTPUT DATA");
	    for (int i = 0; i < item.length; i++) {
	    	System.out.println("\n"+gson.toJson(item[i]));
	    	System.out.println(">>>>>>>>>>>>>>> item # "+i+
	    			" nutrient density points are "+item[i].getRatings().getPointsBreakup().get(0).getPoints()+" <<<<<<<<<<<<<");
	    	System.out.println(">>>>>>>>>>>>>>> item # "+i+
	    			" added sugars points are "+item[i].getRatings().getPointsBreakup().get(1).getPoints()+" <<<<<<<<<<<<<");
	    	System.out.println(">>>>>>>>>>>>>>> item # "+i+
	    			"  points are "+item[i].getRatings().getRating()+" <<<<<<<<<<<<<");
	    }
	    
	    assertTrue(item[0].getRatings().getPointsBreakup().get(0).getPoints() == 5.);
	    
	    assertTrue(item[0].getRatings().getPointsBreakup().get(1).getPoints() == 0.);
	    
	    assertTrue(item[0].getRatings().getRating() == 2);
	    
	}

}
