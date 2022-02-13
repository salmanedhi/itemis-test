package com.itemis.test.dto;

import com.itemis.test.dto.types.ItemName;
import com.itemis.test.dto.types.ItemType;

public class ItemDto {
	
	private ItemName name;
	
	private ItemType type;
	
	private double amount;
	
	
	public ItemDto(ItemName name, ItemType type, double amount) {
		this.name = name;
		this.type = type;
		this.amount = amount;
	}
	
	public void setName(ItemName name) {
		this.name = name;
	}
	
	public ItemName getName() {
		return this.name;
	}
	
	public void setType(ItemType type) {
		this.type = type;
	}
	
	public ItemType getType() {
		return this.type;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	

}
