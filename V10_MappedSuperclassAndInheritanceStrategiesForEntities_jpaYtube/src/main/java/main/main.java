package main;


import entity.*;
import entity.superClass.Bicycle;
import entity.superClass.Car;
import entity.tablePerClass.Employee;
import entity.tablePerClass.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class main {
    public static void main(String[] args) {
        // define Entity Manager
        // create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        //create entity manager
        EntityManager em = emf.createEntityManager();

        try {
            // get transaction
            em.getTransaction().begin();
            System.out.println("Start...");
            Car c = new Car();
            c.setColor("Black");
            c.setGas("Gas");
            Bicycle b = new Bicycle();
            b.setColor("Blue");
            b.setModel("BMW");
            em.persist(c);
            em.persist(b);
            System.out.println("End!!!");
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
}
