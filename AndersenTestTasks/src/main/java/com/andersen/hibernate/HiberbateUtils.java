package com.andersen.hibernate;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/*
 * Creates Hibernate SessionFactory
 */

public class HiberbateUtils {

	private static final File HIBERNATE_CONFIG = new File("src/com/andersen/hibernate/config/hibernate.cfg.xml");

	public static SessionFactory createFectory() {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(HIBERNATE_CONFIG).build();
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}

		/* For Hibernate before v.5+ */

//		Configuration configuration = new Configuration().configure(HIBERNATE_CONFIG);
//		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
//		srb.applySettings(configuration.getProperties());
//		ServiceRegistry serviceRegistry = srb.build();
//		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
	}

}
