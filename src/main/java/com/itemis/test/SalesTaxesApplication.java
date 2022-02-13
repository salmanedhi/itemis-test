package com.itemis.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itemis.test.dto.ItemDto;
import com.itemis.test.dto.ReceiptOutputDto;
import com.itemis.test.dto.types.ItemName;
import com.itemis.test.dto.types.ItemType;
import com.itemis.test.service.SalesTaxService;
import com.itemis.test.service.SalesTaxServiceImpl;

@SpringBootApplication
public class SalesTaxesApplication {

	
	public static void main(String[] args) {

		SalesTaxService salesTaxService = new SalesTaxServiceImpl();
		
		
		List<ItemDto> items = new ArrayList<>();
		
		
		//INPUT 1:
//		ItemDto bookItem = new ItemDto(ItemName.BOOK, ItemType.BOOK, 12.49, false);
//		ItemDto musicItem = new ItemDto(ItemName.MUSIC_CD, ItemType.OTHER, 14.99, false);
//		ItemDto barItem = new ItemDto(ItemName.CHOCOLATE_BAR, ItemType.FOOD, 0.85, false);
//		
//		items.add(bookItem);
//		items.add(musicItem);
//		items.add(barItem);

		//INPUT 2:
//		items.add(new ItemDto(ItemName.CHOCOLATE_BOX, ItemType.FOOD, 10.00, true));
//		items.add(new ItemDto(ItemName.PERFUME, ItemType.OTHER, 47.50, true));
//		
		//INPUT 3:
		items.add(new ItemDto(ItemName.PERFUME, ItemType.OTHER, 27.99, true));
		items.add(new ItemDto(ItemName.PERFUME, ItemType.OTHER, 18.99, false));
		items.add(new ItemDto(ItemName.HEADACHE_PILLS, ItemType.MEDICAL_PRODUCT, 9.75, false));
		items.add(new ItemDto(ItemName.CHOCOLATE_BOX, ItemType.FOOD, 11.25, true));
		
		
		ReceiptOutputDto finalReceiptDto = salesTaxService.generateReceipt(items);
		
		for(int i=0; i<finalReceiptDto.getItems().size(); i++) {
			ItemDto item = finalReceiptDto.getItems().get(i);
			if(item.getIsImported()) {
				System.out.println("1 imported " + item.getName().getName() + ": " + item.getAmount());
			} else {
				System.out.println("1 " + item.getName().getName() + ": " + item.getAmount());
			}
		}
		System.out.println("Sales Taxes: " + finalReceiptDto.getSalesTax());
		System.out.println("Total: " + finalReceiptDto.getTotal());
	}

}
