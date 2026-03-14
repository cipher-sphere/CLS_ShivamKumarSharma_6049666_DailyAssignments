package cg.demo.jpahibernate;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import cg.demo.jpahibernate.entities.Employee;

public class EmployeeDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    EntityManager em = emf.createEntityManager();

    // INSERT
    public Employee insertEmployee(Employee e) {

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

        return e;
    }

    // FETCH BY ID
    public Employee getEmployeeById(int id) {

        Employee e = em.find(Employee.class, id);
        return e;
    }

    // UPDATE SALARY
    public Employee updateSalary(int id, double newsal) {

        Employee e = em.find(Employee.class, id);

        if (e != null) {

            em.getTransaction().begin();
            e.setSalary(newsal);
            em.getTransaction().commit();
        }

        return e;
    }

    //Display
    
    public List<Employee> getAllEmployees() {

        List<Employee> list =
            em.createQuery("SELECT e from Employee e", Employee.class).getResultList();

        return list;
    }

    
    //FETCH PARTICULAR COLS
    //Dynamic pARAMETR USED 
    
    public Double getSalaryById(int id) {

        Double salary = em.createQuery(
                "SELECT e.salary FROM Employee e WHERE e.id = :id",
                Double.class)
                .setParameter("id", id)
                .getSingleResult();

        return salary;
    }

    //fetch number of employees in each department using JPQL
    
    public List<Object[]> getEmployeeCountByDept() {

        List<Object[]> list =
                em.createQuery(
                "SELECT e.dept, COUNT(e) FROM Employee e GROUP BY e.dept",
                Object[].class)
                .getResultList();

        return list;
    }

    //find the list of employees whose salary is a certain value using JPQL
    
    public List<Employee> getEmployeeBySalary(double sal) {

        List<Employee> list =
                em.createQuery(
                "SELECT e FROM Employee e WHERE e.salary = :sal",
                Employee.class)
                .setParameter("sal", sal)
                .getResultList();

        return list;
    }

    //fetch full record of particular employee using mobile number elementCollection
    
    public List<Employee> getEmployeeByPhone(long phone) {

        List<Employee> list =
                em.createQuery(
                "SELECT e FROM Employee e JOIN e.phoneno p WHERE p = :ph",//when embedded 
                Employee.class)
                .setParameter("ph", phone)
                .getResultList();

        return list;
    }

    // DELETE
    public Employee deleteEmployee(int id) {

        Employee e = em.find(Employee.class, id);
        
     // Employee e = new Employee(1,"CS","KARTIK",1234567890,1234);   IllegalArgumentException...Detached object can't be removed

        if (e != null) {

            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }

        return e;
    }

}