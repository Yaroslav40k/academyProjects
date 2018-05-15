package com.andersen.hibernate;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/*
 * Creates Hibernate SessionFactory
 */

public class HiberbateUtils {
	
	private static final File HIBERNATE_CONFIG = new File("src/com/andersen/hibernate/config/hibernate.cfg.xml");
	
	public static SessionFactory createFectory() {
		Configuration configuration = new Configuration().configure(HIBERNATE_CONFIG);
		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		srb.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = srb.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

}
