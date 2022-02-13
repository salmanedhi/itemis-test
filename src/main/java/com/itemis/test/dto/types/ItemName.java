package com.itemis.test.dto.types;

public enum ItemName {
	BOOK("book"),
	MUSIC_CD("music cd"),
	CHOCOLATE_BAR("chocolate bar"),
	PERFUME("perfume"),
	CHOCOLATE_BOX("chocolate box"),
	HEADACHE_PILLS("headhache pills");
	
	private String name;

	ItemName(String name) {
	    this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
