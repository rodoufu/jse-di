package ${groupId}.cdi.factory;

import java.io.Serializable;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.jboss.weld.environment.se.contexts.ThreadScoped;

public class EntityManagerProducer implements Serializable {
	private static final long serialVersionUID = -2881200607579967227L;

	private @Inject EntityManagerFactory factory;

	@Produces
	@ThreadScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		final EntityTransaction transaction = manager.getTransaction();
		if (transaction.isActive()) {
			transaction.commit();
		}
		manager.close();
	}

}
