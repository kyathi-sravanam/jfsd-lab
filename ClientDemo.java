package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate/hibernate.cfg.xml");
        
        // Build SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        
        // Open a session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        TypedQuery<Student> qry =se.createQuery("select s from Vehicle  s", Vehicle.class);
        TypedQuery<Student> qry =se.createQuery("select s from bike  s", Vehicle.class);
        TypedQuery<Student> qry =se.createQuery("select s from car  s", Vehicle.class);

        // Insert a Car
        Car car = new Car();
        car.setNoOfWheels(4);
        car.setPrice(20000);
        car.setModel("Tesla Model S");
        car.setAutomatic(true);
        session.save(car);

        // Insert a Bike
        Bike bike = new Bike();
        bike.setNoOfWheels(2);
        bike.setPrice(1500);
        bike.setModel("Yamaha FZ");
        bike.setType("Sport");
        session.save(bike);

        // Commit transaction
        tx.commit();
        
        // Close session
        session.close();
        factory.close();
    }
}
