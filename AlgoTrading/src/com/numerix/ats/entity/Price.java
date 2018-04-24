package com.numerix.ats.entity;

public class Price {

	private String productName;;
	private double numericValue = 0.0; // Use BigDecimal if needed 
	
	public Price(String productName, double price) {
		setNumericValue(price);
		setProductName(productName);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getNumericValue() {
		return numericValue;
	}

	public void setNumericValue(double price) {
		this.numericValue = price;
	}

}
