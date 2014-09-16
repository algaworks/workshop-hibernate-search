package com.algaworks.ecommerce.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@ApplicationScoped
public class EntityManagerProducer {

	@Inject
	private EntityManagerFactory factory;
	
	@Produces
	@RequestScoped
	public EntityManager create() {
		return factory.createEntityManager();
	}

	public void close(@Disposes EntityManager manager) {
		if (manager.isOpen()) {
			manager.close();
		}
	}

}
