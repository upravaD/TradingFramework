package com.trading.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private final SessionFactory sessionFactory;
    public HibernateUtil() {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
