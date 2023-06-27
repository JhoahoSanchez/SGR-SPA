package epn.edu.ec.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class Conexion {

    public static SessionFactory sessionFactory;
    public static Session session;

    public static void open() {
        Conexion.sessionFactory = new Configuration().configure().buildSessionFactory();
        Conexion.session = sessionFactory.openSession();
    }

    public static void close() {
        Conexion.sessionFactory.close();
        Conexion.session.close();
    }

}
