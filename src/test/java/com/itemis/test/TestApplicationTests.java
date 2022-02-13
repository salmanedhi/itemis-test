package com.itemis.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itemis.test.dto.ItemDto;
import com.itemis.test.dto.ReceiptOutputDto;
import com.itemis.test.service.SalesTaxService;

import static org.junit.Assert.*;


@SpringBootTest
class TestApplicationTests {

	@Autowired
	private SalesTaxService salesTaxService;
	
	@Test
	void printReceiptOfSingleBookItemTest() {
		
		ItemDto bookItem = new ItemDto("book", "book", 12.49);
		
		ReceiptOutputDto finalReceiptDto = salesTaxService.generateReceipt(bookItem);
		
		assertEquals(finalReceiptDto.getSalesTax(), 0, 0);
		assertEquals(finalReceiptDto.getTotal(), 12.49, 0);
	}

}

