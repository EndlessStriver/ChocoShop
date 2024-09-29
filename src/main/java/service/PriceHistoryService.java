package service;

import java.util.List;

import entity.PriceHistory;

public interface PriceHistoryService {
	
	List<PriceHistory> getPriceHistories();

	PriceHistory getPriceHistory(long id);

	void savePriceHistory(PriceHistory priceHistory);

	void deletePriceHistory(long id);

	void updatePriceHistory(PriceHistory priceHistory);
	
}
