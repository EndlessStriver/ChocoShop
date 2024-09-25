package Dao.Implement;

import java.util.List;

import Dao.UserDao;
import Entity.User;
import Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class UserDaoImp implements UserDao {

	@Override
	public User getUser(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		User user = null;
		try {
			user = entityManager.find(User.class, id);
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while getting user.");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return user;
	}

	@Override
	public List<User> getUsers() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<User> users = null;
		try {
			String jpql = "SELECT u FROM User u";
			users = entityManager.createQuery(jpql, User.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while getting users.");
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return users;
	}

	@Override
	public void createUser(User user) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("An error occurred while creating user.");
		} finally {
			em.close();
		}

	}

	@Override
	public void updateUser(User user) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.merge(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("An error occurred while updating user.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteUser(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = em.getTransaction();
			transaction.begin();
			User user = em.find(User.class, id);
			em.remove(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("An error occurred while deleting user.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	@Override
	public User findUserByUsername(String username) {
		EntityManager em = JPAUtil.getEntityManager();
		User user = null;
		try {
			String jpql = "SELECT u FROM User u WHERE u.userName = :username";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			user = query.getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while finding user by username.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return user;
	}

}
