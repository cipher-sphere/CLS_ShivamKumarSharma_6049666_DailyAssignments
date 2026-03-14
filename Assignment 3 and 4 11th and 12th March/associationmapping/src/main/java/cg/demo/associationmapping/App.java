package cg.demo.associationmapping;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        System.out.println("Starting App!!");

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JPA-PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create Citizen
        Citizen ct1 = new Citizen();
        ct1.setAdharNo(12425454);
        ct1.setName("Praniti");
        ct1.setAddress("12/67 Delhi");

        // Create Passport
        IndianPassport ip1 = new IndianPassport();
        ip1.setPassportNo(243545);
        ip1.setPassportExpiryDate(LocalDate.of(2030, 10, 12));

        // Bidirectional Association
        ip1.setCitizen(ct1);
        ct1.setPassport(ip1);

        // Persist only Passport
        em.persist(ip1);

        em.getTransaction().commit();

        System.out.println("Data Saved Successfully");

        em.close();
        emf.close();
    }
}