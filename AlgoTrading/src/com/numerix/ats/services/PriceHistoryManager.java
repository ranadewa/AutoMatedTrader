package com.numerix.ats.services;

import com.numerix.ats.entity.Price;
import com.numerix.ats.entity.Trade;

public interface PriceHistoryManager {
	
	Trade processTrade(Price price);

}
