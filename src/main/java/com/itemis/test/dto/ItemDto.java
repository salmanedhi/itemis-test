package com.itemis.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemDto {
	
	private String name;
	
	private String type;
	
	private double amount;
	
	public ItemDto(String name, String type, double amount) {
		this.name = name;
		this.type = type;
		this.amount = amount;
	}

}
