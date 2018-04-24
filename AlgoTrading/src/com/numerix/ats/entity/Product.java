package com.numerix.ats.entity;

import com.numerix.ats.services.PriceHistoryManager;

public class Product {

	private String name;
	private PriceHistoryManager priceHistoryManager; 
	
	
	public Product(String productName, PriceHistoryManager priceHistoryManager) {
		setName(name);
		setPriceHistoryManager(priceHistoryManager);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public PriceHistoryManager getPriceHistoryManager() {
		return priceHistoryManager;
	}

	public void setPriceHistoryManager(PriceHistoryManager priceHistoryManager) {
		this.priceHistoryManager = priceHistoryManager;
	}


}
