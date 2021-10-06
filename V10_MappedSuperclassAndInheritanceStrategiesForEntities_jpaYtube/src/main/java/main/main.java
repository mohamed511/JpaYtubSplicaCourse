package main;


import entity.*;

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

            Product product = new Product();
            product.setName("Prod_1");

            Chocolate chocolate = new Chocolate();
            chocolate.setName("chocolate");
            chocolate.setkCal(1500);
            em.persist(product);
            em.persist(chocolate);

            System.out.println("End!!!");
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
}
