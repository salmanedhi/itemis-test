package com.itemis.test.dto;


public class ItemDto {
	
	private String name;
	
	private String type;
	
	private double amount;
	
	
	public ItemDto(String name, String type, double amount) {
		this.name = name;
		this.type = type;
		this.amount = amount;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setName(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	

}
