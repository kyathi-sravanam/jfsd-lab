package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class VehicleManager {
    private SessionFactory factory;

    public VehicleManager() {
        // Load configuration and build SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate/hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
    }

    // Save a Vehicle
    public void saveVehicle(Vehicle vehicle) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(vehicle);
        tx.commit();
        session.close();
        System.out.println("Vehicle saved successfully!");
    }

    // Get a Vehicle by ID
    public Vehicle getVehicleById(int id) {
        Session session = factory.openSession();
        Vehicle vehicle = session.get(Vehicle.class, id);
        session.close();
        return vehicle;
    }

    // Get all Vehicles
    @SuppressWarnings("unchecked")
    public List<Vehicle> getAllVehicles() {
        Session session = factory.openSession();
        List<Vehicle> vehicles = session.createQuery("from Vehicle").list();
        session.close();
        return vehicles;
    }

    // Update a Vehicle
    public void updateVehicle(Vehicle vehicle) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(vehicle);
        tx.commit();
        session.close();
        System.out.println("Vehicle updated successfully!");
    }

    // Delete a Vehicle
    public void deleteVehicle(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Vehicle vehicle = session.get(Vehicle.class, id);
        if (vehicle != null) {
            session.delete(vehicle);
            tx.commit();
            System.out.println("Vehicle deleted successfully!");
        } else {
            System.out.println("Vehicle not found!");
        }
        session.close();
    }

    // Close the SessionFactory
    public void close() {
        factory.close();
    }
}
