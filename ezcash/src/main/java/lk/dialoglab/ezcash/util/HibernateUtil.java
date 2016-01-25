/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.dialoglab.ezcash.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

@Component
public class HibernateUtil {

    private static  SessionFactory sessionFactory;
    private static  ServiceRegistry serviceRegistry;
    
    
    @Autowired
    public HibernateUtil(DBInfo dbInfo) {
    
        System.out.println("++++++++++++++++Set session Factory+++++++++++++++++++++++++");
        setSessionFactory(dbInfo);
    }
    
    
    
    private static  void setSessionFactory(DBInfo dbInfo) {
        try {

            Configuration conf = new Configuration().configure();
            String url = "jdbc:mysql://" + dbInfo.getServer() + ":" + dbInfo.getPort() + "/" + dbInfo.getDbName();
            //System.out.println("dbInfo: " + dbInfo);
            System.out.println("url to open++++++++++++++++: " + url + " dbInfo:" + dbInfo.getUsername() + " dbInfo: " + dbInfo.getPassword());
            conf.setProperty("hibernate.connection.url", url);
            conf.setProperty("hibernate.connection.username", dbInfo.getUsername());
            conf.setProperty("hibernate.connection.password", dbInfo.getPassword());
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            sessionFactory = conf.buildSessionFactory(serviceRegistry);

        }

        catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session beginTransaction() {
        Session hibernateSession = getSession();
        hibernateSession.beginTransaction();
        return hibernateSession;
    }

    public static void commitTransaction() {
        getSession().getTransaction().commit();

    }

    public static void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }

    public static void closeSession() {
        getSession().close();
    }

    public static Session getSession() {
        Session hibernateSession = sessionFactory.getCurrentSession();
        return hibernateSession;
    }
}
