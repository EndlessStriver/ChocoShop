package dao.implement;

import java.util.List;

import dao.ProvinceDao;
import entity.Province;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import util.JPAUtil;

public class ProvinceDaoImp implements ProvinceDao {

	@Override
	public List<Province> getProvinces() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<Province> provinces = null;

		try {
			String query = "SELECT p FROM Province p";
			TypedQuery<Province> typedQuery = entityManager.createQuery(query, Province.class);
			provinces = typedQuery.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error in getting provinces");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

		return provinces;
	}

	@Override
	public Province getProvince(long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		Province province = null;

		try {
			province = entityManager.find(Province.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Error in getting province");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

		return province;
	}

	@Override
	public void createProvince(Province province) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(province);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Error in creating province");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

	}

	@Override
	public void updateProvince(Province province) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(province);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Error in updating province");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	@Override
	public void deleteProvince(long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Province province = entityManager.find(Province.class, id);
			entityManager.remove(province);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Error in deleting province");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

	}

}
