package dao.implement;

import java.util.List;

import dao.ProductDao;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JPAUtil;

public class ProductDaoImp implements ProductDao{

	@Override
	public List<Product> getProducts() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Product> products = null;
		try {
			String jqpl = "SELECT p FROM Product p";
			products = em.createQuery(jqpl, Product.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error in getting products");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return products;
	}

	@Override
	public Product getProduct(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Product product = null;
		try {
			product = em.find(Product.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Error in getting product");
		} finally {
            if (em.isOpen()) {
                em.close();
            }
		}
		return product;
	}

	@Override
	public void createProduct(Product product) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Error in creating product");
		} finally {
            if (em.isOpen()) {
                em.close();
            }
		}
	}

	@Override
	public void deleteProduct(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Product product = em.find(Product.class, id);
			em.remove(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error in deleting product");
        } finally {
            if (em.isOpen()) {
                em.close();
            }
		}
	}

	@Override
	public void updateProduct(Product product) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Error in updating product");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

}
