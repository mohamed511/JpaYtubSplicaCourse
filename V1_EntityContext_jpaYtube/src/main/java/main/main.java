package main;

import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        // define Entity Manager
        // create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        //create entity manager
        EntityManager em = emf.createEntityManager();
        // create a product
        Product p = new Product();
        p.setId(100);
        p.setName("table");
        p.setPrice(250);
        p.setExpirationDate(LocalDate.now());
        try{
            // get transaction
            em.getTransaction().begin();
            em.persist(p); // adding the instance in the context
            em.getTransaction().commit();
            em.close();
        }catch (Exception e){
            em.getTransaction().rollback();
            em.close();
        }

    }
}
