package dao.implement;

import java.util.List;

import dao.DistrictDao;
import entity.District;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import util.JPAUtil;

public class DistrictDaoImp implements DistrictDao {

	@Override
	public void createDistrict(District district) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(district);
			entityTransaction.commit();
		} catch (Exception e) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			throw new RuntimeException("Error in creating district");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

	}

	@Override
	public void updateDistrict(District district) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.merge(district);
			entityTransaction.commit();
		} catch (Exception e) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			throw new RuntimeException("Error in updating district");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

	}

	@Override
	public void deleteDistrict(long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			District district = entityManager.find(District.class, id);
			entityManager.remove(district);
			entityTransaction.commit();
		} catch (Exception e) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			throw new RuntimeException("Error in deleting district");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}

	}

	@Override
	public District getDistrict(long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		District district = null;
		try {
			district = entityManager.find(District.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Error in getting district by id");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return district;
	}

	@Override
	public List<District> getDistricts() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<District> districts = null;
		try {
			String jdql = "SELECT d FROM District d";
			TypedQuery<District> query = entityManager.createQuery(jdql, District.class);
			districts = query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error in getting all districts");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return districts;
	}

}
