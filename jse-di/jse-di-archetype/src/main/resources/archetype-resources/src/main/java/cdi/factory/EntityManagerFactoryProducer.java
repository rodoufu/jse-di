package ${groupId}.cdi.factory;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Creates an EntityManagerFactory factory.
 * @author rodoufu
 */
public class EntityManagerFactoryProducer implements Serializable {
	private static final long serialVersionUID = 3984407303706444077L;

	public EntityManagerFactory createEntityManagerFactory(String persistenceUnitName) {
		return Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	/**
	 * Creates the EntityManagerFactory.
	 * @return The EntityManagerFactory object.
	 */
	@Produces
	@ApplicationScoped
	public EntityManagerFactory createEntityManagerFactory() {
		return createEntityManagerFactory("${artifactId}");
	}

	/**
	 * Closes the EntityManagerFactory on it disposes.
	 * @param manager The EntityManagerFactory to close.
	 */
	public void closeEntityManager(@Disposes EntityManagerFactory managerFactory) {
		managerFactory.close();
	}

}
