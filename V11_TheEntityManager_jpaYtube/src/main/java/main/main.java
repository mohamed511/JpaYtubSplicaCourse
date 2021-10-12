package main;

import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
- persist() - flush() - find() - getReference()
- contains() - detach() - clear() - remove() - merge() - refresh()
 */
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

            Product p = new Product();
            p.setId(55L);
            p.setName("Test");
            em.persist(p); // add to the context
            em.clear(); // take all instance out from the context
            //em.detach(p); // take p out from the context
            System.out.println("End!!!");
            em.getTransaction().commit();// insert to the database
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
}
