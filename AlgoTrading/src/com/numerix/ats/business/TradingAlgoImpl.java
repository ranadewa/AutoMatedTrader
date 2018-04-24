package com.numerix.ats.business;
import java.util.concurrent.ConcurrentHashMap;

import com.numerix.ats.entity.Price;
import com.numerix.ats.entity.Product;
import com.numerix.ats.entity.Trade;
import com.numerix.ats.services.PriceHistoryManager;
import com.numerix.ats.services.TradingAlgorithm;

public class TradingAlgoImpl implements TradingAlgorithm {

	private ConcurrentHashMap <String, Product> productHolder; 
	
	
	public TradingAlgoImpl(String[] productNames) {
		 
		productHolder = new ConcurrentHashMap <String, Product>();
		
		for (int index = 0; index < productNames.length; index++) {
					
			String productName = productNames[index];
			
			PriceHistoryManager priceHistoryMan = new PriceHistoryManagerImpl();
			
			Product product = new Product(productName, priceHistoryMan);
			
			productHolder.put(productName, product);
		}	
	}

	@Override
	public Trade buildTrades(Price price) {
		
		Product product = productHolder.get(price.getProductName());
		
		Trade trade = product.getPriceHistoryManager().processTrade(price);
		
		return trade;
	}
}
