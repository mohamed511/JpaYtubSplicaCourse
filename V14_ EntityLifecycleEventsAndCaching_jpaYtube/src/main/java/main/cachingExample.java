package main;

import entity.Product;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class cachingExample {
    public static void main(String[] args) {
        // define Entity Manager
        // create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        //create entity manager
        EntityManager em = emf.createEntityManager();

        try {
            // get transaction
            em.getTransaction().begin();
            System.out.println("============> Start...");
            Product p = em.find(Product.class, 21L); // goes to level2 cache
            // cache
            Cache cache = emf.getCache();
            System.out.println("======> " + cache.contains(Product.class, 21L));

            System.out.println("===============> End!!!");
            em.getTransaction().commit();// insert to the database
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
        }
    }
}
