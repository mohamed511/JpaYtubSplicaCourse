package main;


import entity.Company;
import entity.Detail;
import entity.Product;

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
            Product p = em.find(Product.class,7);
            System.out.println(p);
//            Product product = new Product("orange", 20);
//            em.persist(product);
//            Detail detail = new Detail(20, product);
//            product.setDetail(detail);
//            em.persist(detail);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
}
