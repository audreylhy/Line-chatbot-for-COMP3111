package skeleton;

import java.util.Arrays;
import java.util.Collections;
import org.apache.commons.lang.ArrayUtils;

import java.util.HashMap;

public class Adapter {
	public static final String[] BEVERAGES = new String[] {
			"Caff� Americano", "Caff� Mocha", "Caff� Latte", 
			"Cappuccino", "Caramel Macchiato", "Espresso" }; // You can change these

	/**
	* This function compute the edit distance between a string and every 
	* strings in your selected beverage set. The beverage with the minimum 
	* edit distance <= 3 is returned. The use of Wagner_Fischer algorithm
	* is shown in the main function in WagnerFischer.java
	**/
	public String getBeverage(String s){
		// TODO: find the word with minimum edit distance
		WagnerFischer WF = new WagnerFischer(" "," ");
		int size = BEVERAGES.length;
		int distance[size];

		for (int i = 0; i < size; i++)
		{
			WF = new WagnerFischer(s, BEVERAGES[i]);
			distance[i] = WF.getDistance();
		}

		List b = Arrays.asList(ArrayUtils.toObject(distance));
		int index = Collections.min(b);
		return BEVERAGES[index];

	}
}
