package main;

import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MainCriteria {
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
            // make this select using criteria builder
            // "select p from Product p "
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> product = query.from(Product.class);
            query.select(product);


            TypedQuery<Product> q = em.createQuery(query);
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
