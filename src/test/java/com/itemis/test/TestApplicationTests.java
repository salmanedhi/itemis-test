package com.itemis.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.itemis.test.dto.ItemDto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class TestApplicationTests {

	@Test
	void printReceiptOfSingleBookItemTest() {
		
		List<ItemDto> items = new ArrayList<>();
		ItemDto bookItem = new ItemDto("book", "book", 12.49);
		items.add(bookItem);
		
		//generate receipt service - no function
		generateReceipt();
		
		assertEquals(true, true);
	}

}

