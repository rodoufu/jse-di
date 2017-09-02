package com.gitlab.rodoufu.jsedi.cdi.factory;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProducer implements Serializable {
	private static final long serialVersionUID = 3994407303706444077L;

	public EntityManagerFactory createEntityManagerFactory(String persistenceUnitName) {
		return Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	@Produces
	@ApplicationScoped
	public EntityManagerFactory createEntityManagerFactory() {
//		System.out.println("--- Criando EntityManagerFactory ---");
		return createEntityManagerFactory("btc");
	}

	public void closeEntityManager(@Disposes EntityManagerFactory managerFactory) {
		managerFactory.close();
//		System.out.println("--- Fechando EntityManagerFactory ---");
	}

}
