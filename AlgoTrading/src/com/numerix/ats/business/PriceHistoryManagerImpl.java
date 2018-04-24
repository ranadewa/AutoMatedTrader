package com.numerix.ats.business;

import java.util.ArrayList;

import com.numerix.ats.entity.Price;
import com.numerix.ats.entity.Trade;
import com.numerix.ats.services.PriceHistoryManager;
import com.numerix.ats.utility.Util;

public class PriceHistoryManagerImpl implements PriceHistoryManager {

	private ArrayList<Double> lastTradedPrices = null;
	private double total  = 0.0;
	
	public PriceHistoryManagerImpl() {
		lastTradedPrices = new ArrayList<>();
	}

	@Override
	synchronized public Trade processTrade(Price price) {
		
		addToPriceHistory(price);
		
		Trade trade = processPriceHistory(price);	
		
		return trade;
	}
	
	private void addToPriceHistory(Price price) {
		lastTradedPrices.add(price.getNumericValue());
		total += price.getNumericValue();
	}
	
	private Trade processPriceHistory(Price price) {
		
		Trade trade = null;
		
		if(lastTradedPrices.size() >= Util.LAST_TRADED_PRICE_COUNT ){
			
			if(lastTradedPrices.size() > Util.LAST_TRADED_PRICE_COUNT ){
			
				total -= lastTradedPrices.get(0);
				lastTradedPrices.remove(0);
			}
			
			if(lastTradedPrices.get(0) < getAveragePrice()){
				
				trade = new Trade(price, Util.DEFAULT_TRADE_SIZE);
			}
		}
		
		return trade;
	}
	
	private double getAveragePrice() {
		
		return (total/Util.LAST_TRADED_PRICE_COUNT);
	}
}
