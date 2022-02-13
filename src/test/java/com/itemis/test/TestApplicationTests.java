package com.itemis.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

import java.util.List;


@SpringBootTest
class TestApplicationTests {

	@Test
	void checkItemListToNotBeEmpty(List<ItemDto> itemsList) {
		
		assertNotNull(itemsList);
		assertFalse(itemsList.isEmpty());
	}

}

