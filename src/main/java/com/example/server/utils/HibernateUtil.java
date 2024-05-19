package com.example.server.utils;

import com.example.server.entity.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try{
                Configuration configuration = getConfiguration();
                configuration.addAnnotatedClass(Contact.class);
                ServiceRegistry registry =
                        new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties())
                                .build();
                sessionFactory = configuration.buildSessionFactory(registry);
            }catch (Exception e){
                new ServerUtil().getOutput(e.getMessage());
            }
        }
        return sessionFactory;
    }

    private static Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        Properties prop = new Properties();
        try {
            prop.load(HibernateUtil.class.getResourceAsStream("/db/db.properties"));
        } catch (IOException e) {
            new ServerUtil().getOutput(e.getMessage());
        }
        prop.put(Environment.JAKARTA_JDBC_DRIVER, prop.getProperty("driver"));
        prop.put(Environment.JAKARTA_JDBC_URL, prop.getProperty("url"));
        prop.put(Environment.JAKARTA_JDBC_USER, prop.getProperty("username"));
        prop.put(Environment.JAKARTA_JDBC_PASSWORD, prop.getProperty("password"));
        configuration.setProperties(prop);
        return configuration;
    }

}
