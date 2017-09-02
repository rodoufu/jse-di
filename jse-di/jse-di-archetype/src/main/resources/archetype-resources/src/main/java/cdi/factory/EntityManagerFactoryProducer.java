package ${groupId}.cdi.factory;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProducer implements Serializable {
	private static final long serialVersionUID = 3984407303706444077L;

	public EntityManagerFactory createEntityManagerFactory(String persistenceUnitName) {
		return Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	@Produces
	@ApplicationScoped
	public EntityManagerFactory createEntityManagerFactory() {
		return createEntityManagerFactory("${artifactId}");
	}

	public void closeEntityManager(@Disposes EntityManagerFactory managerFactory) {
		managerFactory.close();
	}

}
