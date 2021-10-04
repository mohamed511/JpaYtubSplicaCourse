package main;


import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;

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
//            Department department = new Department("I_T");
//            DepartmentDetail dd = new DepartmentDetail("C2", department);
//            Employee employee = new Employee("emp1", dd);
//            Employee employee2 = new Employee("emp2", dd);
//            em.persist(department);
//            em.persist(employee);
//            em.persist(employee2);
//            Professor professor = new Professor("prof");
//            ProfessorDetail pd = new ProfessorDetail(Arrays.asList(professor));
//            Student student = new Student("Aly", pd);
//            em.persist(professor);
//            em.persist(student);

            Document document = new Document(1,"DC1");
            Person person = new Person("Yasser",Arrays.asList("1994","1999"),Arrays.asList(document));
            em.persist(person);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
}
