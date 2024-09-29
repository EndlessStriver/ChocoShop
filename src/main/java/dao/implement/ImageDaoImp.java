package dao.implement;

import java.util.List;

import dao.ImageDao;
import entity.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JPAUtil;

public class ImageDaoImp implements ImageDao{

	@Override
	public List<Image> getImages() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Image> images = null;
		try {
			String jpql = "SELECT i FROM Image i";
			images = em.createQuery(jpql, Image.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error in getting images");
		} finally {
			if (em.isOpen()) {
                em.close();
			}
		}
		return images;
	}

	@Override
	public Image getImage(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Image image = null;
		try {
			image = em.find(Image.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Error in getting image");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return image;
	}

	@Override
	public void createImage(Image image) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(image);
			et.commit();
		} catch (Exception e) {
			if(et.isActive()) {
				et.rollback();
			}
			throw new RuntimeException("Error in creating image");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteImage(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			Image image = em.find(Image.class, id);
			em.remove(image);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			throw new RuntimeException("Error in deleting image");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void updateImage(Image image) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(image);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			throw new RuntimeException("Error in updating image");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}
	
}
