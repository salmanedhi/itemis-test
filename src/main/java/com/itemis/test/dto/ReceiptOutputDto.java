package com.itemis.test.dto;

public class ReceiptOutputDto {
	
	private ItemDto item;
	private double salesTax;
	private double total;
	
	public ItemDto getItem() {
		return item;
	}
	public void setItem(ItemDto item) {
		this.item = item;
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
