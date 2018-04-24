package com.numerix.ats.entity;
import com.numerix.ats.utility.Direction;

public class Trade {

	private String productName;
	private Direction direction = Direction.NONE;
	private int quantity = 0;
	private double tradePrice = 0.0;
	
	
	public Trade(Price price, int quantity) {
		
			setProductName(price.getProductName());
			setDirection(Direction.BUY);
			setQuantity(quantity);
			setPrice(price.getNumericValue());
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return tradePrice;
	}

	public void setPrice(double price) {
		this.tradePrice = price;
	}

}
