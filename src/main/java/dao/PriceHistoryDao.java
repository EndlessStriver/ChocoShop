package dao;

import java.util.List;

import entity.PriceHistory;

public interface PriceHistoryDao {
	
	List<PriceHistory> getPriceHistories();

	PriceHistory getPriceHistory(long id);

	void createPriceHistory(PriceHistory priceHistory);

	void deletePriceHistory(long id);

	void updatePriceHistory(PriceHistory priceHistory);
	
}
