package main;


import entity.*;
import entity.enums.PhoneType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
//            Person person = new Person("aly", new HashMap<>());
//            person.getPhoneNumbers().put(PhoneType.HOME, "5555");
//            person.getPhoneNumbers().put(PhoneType.MOBILE, "444");
//            em.persist(person);

//            Student s1 = new Student("Aly");
//            Professor p1 = new Professor("prof1",new HashMap<>());
//            p1.getStudents().put("C1",s1);
//            em.persist(s1);
//            em.persist(p1);
//            Employee emp = new Employee("Emp1");
//            Department d1 = new Department("D1", new HashMap<>());
//            emp.setDepartment(d1);
//            d1.getEmployees().put(0, emp);
//            em.persist(emp);
//            em.persist(d1);
            Department d = em.find(Department.class, 2);
            System.out.println(d.getEmployees());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
}
