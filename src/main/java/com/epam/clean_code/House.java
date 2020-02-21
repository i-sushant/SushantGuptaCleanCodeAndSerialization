package com.epam.clean_code;
import java.util.HashMap;

public class House {
	
	private float totalArea;
	private String materialType;
	private float housePrice;
	
	HashMap<String, Integer> costPerSquareFoot = new HashMap<String, Integer>();
	
	public House() {
		costPerSquareFoot.put("standard", 1200);
		costPerSquareFoot.put("aboveStandard", 1500);
		costPerSquareFoot.put("highStandard", 1800);
		costPerSquareFoot.put("highStandardFullyAutomated", 2500);
	}
	
	public House(float totalArea, String materialType) {
		this();
		this.totalArea = totalArea;
		this.materialType = materialType;
	}
	
	public float getHousePrice() {
		this.housePrice = this.totalArea * this.costPerSquareFoot.get(materialType);
		return this.housePrice;
	}
	
}
