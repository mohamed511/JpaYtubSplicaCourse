package main;


import entity.Department;
import entity.Document;
import entity.Employee;
import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
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
//            System.out.println("Start...");
//            Person person = new Person("p2");
//            Document doc1 = new Document("doc2",person);
//            Document doc2 = new Document("doc3",person);
//            Document doc3 = new Document("doc4",person);
//            Collection<Document> documents = new ArrayList<>();
//            documents.add(doc1);
//            documents.add(doc2);
//            documents.add(doc3);
//            em.persist(doc1);
//            em.persist(doc2);
//            em.persist(doc3);
//            em.persist(person);
            Person p1 = new Person();
            p1.setPersonName("P1");
            p1.setDocuments(new ArrayList<>());

            Document d1 = new Document();
            d1.setDocumentName("DOC 1");

            d1.setPerson(p1);
            p1.getDocuments().add(d1);

            //em.persist(p1);
            em.persist(d1);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
}
