package org.kurolek.ecommerseDBSpringDemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

    private static SessionFactory sessionFactory = null;

    static {
        Configuration cfg = new Configuration();
        cfg.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ecommerse_db_demo?serverTimezone=UTC");
        cfg.setProperty("hibernate.connection.username", "root");
        cfg.setProperty("hibernate.connection.password", "root");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        cfg.setProperty("show_sql", "true");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.Address.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.Category.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.CreditCard.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.Delivery.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.DeliveryData.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.Order.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.OrderedProduct.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.Person.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.Product.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.Producer.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.ProductDetails.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.Role.class);
        cfg.addAnnotatedClass(org.kurolek.ecommerseDBSpringDemo.Entity.User.class);



        sessionFactory = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
