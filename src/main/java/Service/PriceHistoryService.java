package Service;

import java.util.List;

import Entity.PriceHistory;

public interface PriceHistoryService {
	
	List<PriceHistory> getPriceHistories();

	PriceHistory getPriceHistory(long id);

	void savePriceHistory(PriceHistory priceHistory);

	void deletePriceHistory(long id);

	void updatePriceHistory(PriceHistory priceHistory);
	
}
