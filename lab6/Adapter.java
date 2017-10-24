import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.HashMap;

public class Adapter {
	public static final String[] BEVERAGES = new String[] {
			"Caffè Americano", "Caffè Mocha", "Caffè Latte", 
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
		int distance[] = new int [size];

		for (int i = 0; i < size; i++)
		{
			WF = new WagnerFischer(s, BEVERAGES[i]);
			distance[i] = WF.getDistance();
		}

		int minINDEX = 0;
		int minDistance = distance[0];
		for(int j = 0; j < size-1; j++)
		{
			if(distance[j+1] < minDistance){
				minDistance = distance[j+1];
				minINDEX = j+1;
			}
		}
			
		return BEVERAGES[minINDEX];
	}
}
