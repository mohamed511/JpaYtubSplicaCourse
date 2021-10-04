package main;


import entity.Professor;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

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
            Student s1 = new Student("stu2",new ArrayList<>());
            Student s2 = new Student("stu3",new ArrayList<>());
            Professor p1 = new Professor("p2",new ArrayList<>());
            p1.getStudents().add(s1);
            p1.getStudents().add(s2);

            s1.getProfessors().add(p1);
            s2.getProfessors().add(p1);
            em.persist(p1);
            em.persist(s1);
            em.persist(s2);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
}
