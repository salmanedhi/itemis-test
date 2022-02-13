package com.itemis.test.service;


import org.springframework.stereotype.Component;

import com.itemis.test.dto.ItemDto;
import com.itemis.test.dto.ReceiptOutputDto;

@Component
public class SalesTaxServiceImpl implements SalesTaxService {

	@Override
	public ReceiptOutputDto generateReceipt(ItemDto item) {
		
//		System.out.println("1 " + item.getName() + " at " + item.getAmount());
		
		ReceiptOutputDto finalReceiptDto = new ReceiptOutputDto();
		finalReceiptDto.setItem(item);
		finalReceiptDto.setSalesTax(0);
		finalReceiptDto.setTotal(item.getAmount());
		
		return finalReceiptDto;
	}

}
