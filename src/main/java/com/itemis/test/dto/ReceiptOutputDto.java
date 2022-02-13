package com.itemis.test.dto;

import java.util.List;

public class ReceiptOutputDto {
	
	private List<ItemDto> items;
	private double salesTax;
	private double total;
	
	public List<ItemDto> getItems() {
		return this.items;
	}
	
	public void setItems(List<ItemDto> items) {
		this.items = items;
	}
	
	public double getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
