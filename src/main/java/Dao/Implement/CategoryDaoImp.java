package Dao.Implement;

import java.util.List;

import Dao.CategoryDao;
import Entity.Category;
import Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CategoryDaoImp implements CategoryDao {

	@Override
	public List<Category> getCategories() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Category> categories = null;
		try {
			String jqpl = "SELECT c FROM c";
			categories = em.createQuery(jqpl, Category.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error in getting categories");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

		return categories;
	}

	@Override
	public Category getCategory(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Category category = null;
		try {
			category = em.find(Category.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Error in getting category");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return category;
	}

	@Override
	public void createCategory(Category category) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(category);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Error in creating category");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	@Override
	public void updateCategory(Category category) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
            transaction.begin();
            em.merge(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error in updating category");
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
	}

	@Override
	public void deleteCategory(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Category category = em.find(Category.class, id);
			em.remove(category);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Error in deleting category");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

}
