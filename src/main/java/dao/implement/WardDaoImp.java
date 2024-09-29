package dao.implement;

import java.util.List;

import dao.WardDao;
import entity.Ward;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import util.JPAUtil;

public class WardDaoImp implements WardDao {

	@Override
	public List<Ward> getWards() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Ward> wards = null;
		try {
			String jpql = "SELECT w FROM Ward w";
			TypedQuery<Ward> query = em.createQuery(jpql, Ward.class);
			wards = query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error in getting wards");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return wards;
	}

	@Override
	public Ward getWard(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Ward ward = null;
		try {
			ward = em.find(Ward.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Error in getting ward");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return ward;
	}

	@Override
	public void CreateWard(Ward ward) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(ward);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			throw new RuntimeException("Error in creating ward");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void UpdateWard(Ward ward) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.merge(ward);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			throw new RuntimeException("Error in updating ward");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void DeleteWard(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			Ward ward = em.find(Ward.class, id);
			em.remove(ward);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			throw new RuntimeException("Error in deleting ward");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

}
