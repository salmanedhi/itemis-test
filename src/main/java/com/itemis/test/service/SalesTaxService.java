package com.itemis.test.service;

import java.util.List;

import com.itemis.test.dto.ItemDto;
import com.itemis.test.dto.ReceiptOutputDto;

public interface SalesTaxService {

	ReceiptOutputDto generateReceipt(ItemDto item);
	
}
