package ru.geekbrains.graduatework.utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Utility class that has one method getSession() for create
 * session factory for application to work with the database.
 *  */

public class HibernateConnectionUtil {
    final StandardServiceRegistry REGISTRY;
    SessionFactory sessionFactory;

    public HibernateConnectionUtil() {
        REGISTRY = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(REGISTRY).buildMetadata().buildSessionFactory();
    }
    /**
     * Method for open session factory
     * @return Session
     *  */
    public Session getSession (){
        return sessionFactory.openSession();
    }
}
