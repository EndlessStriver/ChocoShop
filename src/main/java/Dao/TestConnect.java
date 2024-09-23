package Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestConnect {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_ORM_CHOCOSHOP");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Connected");
		
		em.close();
		emf.close();
	}
}
