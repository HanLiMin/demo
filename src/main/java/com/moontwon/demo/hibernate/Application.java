package com.moontwon.demo.hibernate;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.MySQL55Dialect;

public class Application {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
//		configApplicationContext.scan("com.moontwon.hibernate");
//		configApplicationContext.refresh();
//		configApplicationContext.close();
		
		
		
		BootstrapServiceRegistryBuilder bootstrapServiceRegistryBuilder = new BootstrapServiceRegistryBuilder();
		BootstrapServiceRegistry bootstrapServiceRegistry = bootstrapServiceRegistryBuilder.build();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new  StandardServiceRegistryBuilder(bootstrapServiceRegistry);
		serviceRegistryBuilder.applySetting(Environment.DIALECT,new MySQL55Dialect());
		StandardServiceRegistry standardServiceRegistry = serviceRegistryBuilder.build();
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		metadataSources.addPackage("com.moontwon.hibernate");
//		SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
//		Session session = sessionFactory.getCurrentSession();
//		session.find(Student.class, primaryKey)
	}
}
