package cg.demo.associationmapping;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App2 {

    public static void main(String[] args) {

        System.out.println("Starting App2");

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JPA-PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department d1 = new Department();
        d1.setName("IT");
        d1.setManagerName("Kartik");

        Employee e1 = new Employee();
        e1.setName("Rahul");
        e1.setSalary(50000);
        e1.setDepartment(d1);   

        Employee e2 = new Employee();
        e2.setName("Aman");
        e2.setSalary(60000);
        e2.setDepartment(d1);  

        Set<Employee> empSet1 = new HashSet<>();
        empSet1.add(e1);
        empSet1.add(e2);

        d1.setEmployees(empSet1);

        Department d2 = new Department();
        d2.setName("HR");
        d2.setManagerName("Neha");

        Employee e3 = new Employee();
        e3.setName("Rohit");
        e3.setSalary(45000);
        e3.setDepartment(d2);   // IMPORTANT

        Employee e4 = new Employee();
        e4.setName("Priya");
        e4.setSalary(55000);
        e4.setDepartment(d2);   

        Set<Employee> empSet2 = new HashSet<>();
        empSet2.add(e3);
        empSet2.add(e4);

        d2.setEmployees(empSet2);

        em.persist(d1);
        em.persist(d2);

        em.getTransaction().commit();

        System.out.println("Data Saved Successfully");

        em.close();
        emf.close();
    }
}