package Dao.Implement;

import java.util.ArrayList;
import java.util.List;

import Dao.UserDao;
import Entity.User;
import Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;


public class UserDAOImpl implements UserDao{

	@Override
	public User findById(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		User user = null;
		try {
			user = entityManager.find(User.class, id);
		} catch (Exception e) {
			entityManager.close();
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<User> users = new ArrayList<User>();
		try {
			String jpql = "SELECT u FROM User u";
			users = entityManager.createQuery(jpql, User.class).getResultList();
		} catch (Exception e) {
			entityManager.close();
		}
		return users;
	}

	@Override
	public void save(User user) {
		EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;
        
		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void update(User user) {
		EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;
        
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
	}

	@Override
	public void delete(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;
        
		try {
			transaction = em.getTransaction();
			transaction.begin();
			User user = em.find(User.class, id);
			em.remove(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
		}
		
	}

	@Override
	public User findByUsername(String username) {
		EntityManager em = JPAUtil.getEntityManager();
		User user = null;
		try {
			String jpql = "SELECT u FROM User u WHERE u.userName = :username";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			user = query.getSingleResult();
		} catch (Exception e) {
			return user;
        } finally {
            em.close();
        }
		return user;
	}

}
