package main;

import entity.Employee;
import entity.Product;

import javax.persistence.*;
import java.util.List;

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
            System.out.println("============> Start...");
            String jpql = "SELECT e FROM Employee e, Department d WHERE e.department = d AND d.id = :id";
            TypedQuery<Employee> list = em.createQuery(jpql,Employee.class);
            list.setParameter("id",1);

            List<Employee> employees = list.getResultList();
            employees.forEach(System.out::println);

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
