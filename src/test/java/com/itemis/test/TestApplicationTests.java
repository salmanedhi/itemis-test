package com.itemis.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itemis.test.dto.ItemDto;
import com.itemis.test.dto.ReceiptOutputDto;
import com.itemis.test.dto.types.ItemName;
import com.itemis.test.dto.types.ItemType;
import com.itemis.test.service.SalesTaxService;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class TestApplicationTests {

	@Autowired
	private SalesTaxService salesTaxService;
	
	@Test
	void printReceiptOfSingleBookItemTest() {
		
		List<ItemDto> items = new ArrayList<>();
		
		ItemDto bookItem = new ItemDto(ItemName.BOOK, ItemType.BOOK, 12.49, false);
		
		items.add(bookItem);
		
		ReceiptOutputDto finalReceiptDto = salesTaxService.generateReceipt(items);
		
		assertEquals(finalReceiptDto.getSalesTax(), 0, 0);
		assertEquals(finalReceiptDto.getTotal(), 12.49, 0);
	}
	
	@Test
	void printReceiptOfMultipleItemsInput1() {
		
		List<ItemDto> items = new ArrayList<>();
		
		ItemDto bookItem = new ItemDto(ItemName.BOOK, ItemType.BOOK, 12.49, false);
		ItemDto musicItem = new ItemDto(ItemName.MUSIC_CD, ItemType.OTHER, 14.99, false);
		ItemDto barItem = new ItemDto(ItemName.CHOCOLATE_BAR, ItemType.FOOD, 0.85, false);
		
		items.add(bookItem);
		items.add(musicItem);
		items.add(barItem);
		
		ReceiptOutputDto finalReceiptDto = salesTaxService.generateReceipt(items);
		
		assertEquals(finalReceiptDto.getSalesTax(), 1.50, 0);
		assertEquals(finalReceiptDto.getTotal(), 29.83, 0);
	}
	
	@Test
	void printReceiptOfMultipleItemsInput2() {
		
		List<ItemDto> items = new ArrayList<>();
		
		items.add(new ItemDto(ItemName.CHOCOLATE_BOX, ItemType.FOOD, 10.00, true));
		items.add(new ItemDto(ItemName.PERFUME, ItemType.OTHER, 47.50, true));
		
		ReceiptOutputDto finalReceiptDto = salesTaxService.generateReceipt(items);
		
		assertEquals(finalReceiptDto.getSalesTax(), 7.63, 0);
		assertEquals(finalReceiptDto.getTotal(), 65.13, 0);
	}
	
	@Test
	void printReceiptOfMultipleItemsInput3() {
		
		List<ItemDto> items = new ArrayList<>();
		
		items.add(new ItemDto(ItemName.PERFUME, ItemType.OTHER, 27.99, true));
		items.add(new ItemDto(ItemName.PERFUME, ItemType.OTHER, 18.99, false));
		items.add(new ItemDto(ItemName.HEADACHE_PILLS, ItemType.MEDICAL_PRODUCT, 9.75, false));
		items.add(new ItemDto(ItemName.CHOCOLATE_BOX, ItemType.FOOD, 11.25, true));
		
		ReceiptOutputDto finalReceiptDto = salesTaxService.generateReceipt(items);
		
		assertEquals(finalReceiptDto.getSalesTax(), 6.66, 0);
		assertEquals(finalReceiptDto.getTotal(), 74.64, 0);
	}

}

