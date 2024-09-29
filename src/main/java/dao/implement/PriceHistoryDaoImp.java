package dao.implement;

import java.util.List;

import dao.PriceHistoryDao;
import entity.PriceHistory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JPAUtil;

public class PriceHistoryDaoImp implements PriceHistoryDao {

	@Override
	public List<PriceHistory> getPriceHistories() {
		EntityManager em = JPAUtil.getEntityManager();
		List<PriceHistory> priceHistories = null;
		try {
			String jpql = "SELECT p FROM PriceHistory p";
			priceHistories = em.createQuery(jpql, PriceHistory.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error in getting price histories");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return priceHistories;
	}

	@Override
	public PriceHistory getPriceHistory(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		PriceHistory priceHistory = null;
		try {
			priceHistory = em.find(PriceHistory.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Error in getting price history");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return priceHistory;
	}

	@Override
	public void createPriceHistory(PriceHistory priceHistory) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(priceHistory);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			throw new RuntimeException("Error in creating price history");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deletePriceHistory(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			PriceHistory priceHistory = em.find(PriceHistory.class, id);
			em.remove(priceHistory);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			throw new RuntimeException("Error in deleting price history");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void updatePriceHistory(PriceHistory priceHistory) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(priceHistory);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			throw new RuntimeException("Error in updating price history");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

}
