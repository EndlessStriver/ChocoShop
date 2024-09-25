package Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("CHOCOSHOP");
		} catch (Exception e) {
			System.err.println("Initial EntityManagerFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	public static void shutdown() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}
}
