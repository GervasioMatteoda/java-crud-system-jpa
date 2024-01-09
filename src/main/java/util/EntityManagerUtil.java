package util;

import javax.persistence.*;

public class EntityManagerUtil {
	private static EntityManagerFactory factory;

	private EntityManagerUtil() {
	}

	public static EntityManager getEntityManager() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory("com.sistema-login");
		return factory.createEntityManager();
	}

	public static void closeEntityManagerFactory() {
		if (factory != null) {
			factory.close();
		}
	}
}