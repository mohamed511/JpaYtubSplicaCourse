package main;

import entity.*;
import entity.embeddable.Address;
import entity.embeddable.BuildingPk;
import entity.enums.Currency;
import entity.pk.DepartmentPk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

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
            System.out.println("==========> ");
            Building building = new Building();
            building.setName("D_4");
            building.setBuildingPk(new BuildingPk());
            building.getBuildingPk().setCode("D");
            building.getBuildingPk().setNumber(4);
            em.persist(building);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }

    }
}
