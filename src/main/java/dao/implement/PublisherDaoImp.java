package dao.implement;

import java.util.List;

import dao.PublisherDao;
import entity.Publisher;
import jakarta.persistence.EntityManager;
import util.JPAUtil;

public class PublisherDaoImp implements PublisherDao {

	@Override
	public List<Publisher> getPublishers() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Publisher> publishers = null;
		try {
			String jpql = "SELECT p FROM Publisher p";
			publishers = em.createQuery(jpql, Publisher.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error in getting publishers");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return publishers;
	}

	@Override
	public Publisher getPublisher(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Publisher publisher = null;
		try {
			publisher = em.find(Publisher.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Error in getting publisher");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return publisher;
	}

	@Override
	public void savePublisher(Publisher publisher) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(publisher);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new RuntimeException("Error in saving publisher");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deletePublisher(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Publisher publisher = em.find(Publisher.class, id);
			em.remove(publisher);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new RuntimeException("Error in deleting publisher");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void updatePublisher(Publisher publisher) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(publisher);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new RuntimeException("Error in updating publisher");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

}
