package main;

import entity.Product;
import javax.persistence.*;
import java.util.List;

public class MainJpql {
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
            String jpql = "select p from Product p ";
            TypedQuery<Product> q = em.createQuery(jpql,Product.class);
            List<Product> list = q.getResultList();
            list.forEach(System.out::println);

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
