package Service.Implement;

import java.util.List;

import Entity.PriceHistory;
import Service.PriceHistoryService;

public class PriceHistoryServiceImp implements PriceHistoryService{
	
	private PriceHistoryService priceHistoryService;
	
	public PriceHistoryServiceImp(PriceHistoryService priceHistoryService) {
		this.priceHistoryService = priceHistoryService;
	}

	@Override
	public List<PriceHistory> getPriceHistories() {
		try {
			return priceHistoryService.getPriceHistories();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public PriceHistory getPriceHistory(long id) {
		try {
			return priceHistoryService.getPriceHistory(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void savePriceHistory(PriceHistory priceHistory) {
		try {
			priceHistoryService.savePriceHistory(priceHistory);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deletePriceHistory(long id) {
		try {
			priceHistoryService.deletePriceHistory(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updatePriceHistory(PriceHistory priceHistory) {
		try {
			priceHistoryService.updatePriceHistory(priceHistory);
		} catch (Exception e) {
			throw e;
		}
	}

}
