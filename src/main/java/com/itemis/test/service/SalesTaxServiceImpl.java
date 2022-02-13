package com.itemis.test.service;


import java.util.List;

import org.springframework.stereotype.Component;

import com.itemis.test.dto.ItemDto;
import com.itemis.test.dto.ReceiptOutputDto;
import com.itemis.test.dto.types.ItemType;

@Component
public class SalesTaxServiceImpl implements SalesTaxService {

	private double SALES_TAX = 10;
	private double IMPORTED_SALES_TAX = 5;
	
	
	@Override
	public ReceiptOutputDto generateReceipt(List<ItemDto> items) {
		
		double totalAmount = 0;
		double salesTax = 0;
		
		if(items.size() > 0) {
			for(int i=0; i<items.size(); i++) {
				ItemDto item = items.get(i);
				
				if(item.getType() == ItemType.OTHER) {
					// apply sales tax
					double salesTaxAmount = 0;
					if(item.getIsImported()) {
						salesTaxAmount = (item.getAmount() * (SALES_TAX + IMPORTED_SALES_TAX)) / 100;
					} else {
						salesTaxAmount = (item.getAmount() * SALES_TAX) / 100;
					}
					// round to 2 decimal places
					salesTaxAmount = Math.round(salesTaxAmount * 100.0) / 100.0;
					
					item.setAmount(item.getAmount() + salesTaxAmount);
					salesTax += salesTaxAmount;
				} else {
					if(item.getIsImported()) {
						double salesTaxAmount = (item.getAmount() * IMPORTED_SALES_TAX) / 100;
						salesTaxAmount = Math.round(salesTaxAmount * 100.0) / 100.0;
						
						item.setAmount(item.getAmount() + salesTaxAmount);
						salesTax += salesTaxAmount;
					}
				}
				
				totalAmount += item.getAmount();
			}
		}
		
		// round to 2 decimal places
		totalAmount = Math.round(totalAmount * 100.0) / 100.0;
		
		ReceiptOutputDto finalReceiptDto = new ReceiptOutputDto();
		finalReceiptDto.setItems(items);
		finalReceiptDto.setSalesTax(salesTax);
		finalReceiptDto.setTotal(totalAmount);
		
		return finalReceiptDto;
	}

}
