package dao.implement;

import java.util.List;

import dao.OrderDao;
import entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JPAUtil;

public class OrderDaoImp implements OrderDao{

	@Override
	public List<Order> getOrders() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Order> orders = null;
		try {
			String jpql = "SELECT o FROM Order o";
			orders = em.createQuery(jpql, Order.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error in getting orders");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return orders;
	}

	@Override
	public Order getOrder(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Order order = null;
		try {
			order = em.find(Order.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Error in getting order");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return order;
	}

	@Override
	public void createOrder(Order order) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(order);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Error in creating order");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteOrder(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
            Order order = em.find(Order.class, id);
            em.remove(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error in deleting order");
        } finally {
            if (em.isOpen()) {
                em.close();
            }
		}
	}

	@Override
	public void updateOrder(Order order) {
		EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error in updating order");
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
	}

}
