package org.example.configurations;


import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DatabaseConnection {

    public static SessionFactory createSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgesql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "312");

        properties.put(Environment.HBM2DDL_AUTO, "create");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);

        return configuration.buildSessionFactory();
    }
    public static EntityManagerFactory createEntityManagerFactory(){
        SessionFactory sessionFactory = createSessionFactory();
        EntityManagerFactory unwrap = sessionFactory.unwrap(EntityManagerFactory.class);
        return unwrap;
    }

}
