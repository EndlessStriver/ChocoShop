package db;

import jakarta.persistence.EntityManager;
import util.JPAUtil;

public class TestConnectDb {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		System.out.println("Connect to database successfully");
		em.close();
	}
}
