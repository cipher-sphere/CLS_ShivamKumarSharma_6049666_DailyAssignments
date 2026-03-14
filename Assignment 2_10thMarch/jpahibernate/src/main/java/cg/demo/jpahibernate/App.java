package cg.demo.jpahibernate;

import cg.demo.jpahibernate.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting App!" );
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = emf.createEntityManager();
//        Employee emp=new Employee();
//        emp.setId(101);
//        emp.setName("Rohit");
//        emp.setDept("CS");
//        emp.setPhoneno(1234567890);
//        emp.setSalary(125444);
        em.getTransaction().begin();
        
        //em.persist(emp);
        //System.out.println("Employee has been Added Successfully");
        
        //Employee emp=em.find(Employee.class, 101);
//        System.out.println(emp);
        
        
        //update that is not good practice
//        Employee emp=new Employee();
//        emp.setId(101);
//        emp.setName("Rohit Sharma");
//        emp.setDept("CS");
//        emp.setPhoneno(1234567890);
//        emp.setSalary(48000);
//        System.out.println(emp);
//        em.merge(emp);
        
        
        //first do find then merge
//        Employee emp=em.find(Employee.class, 101);
//        emp.setName("Rohit Sharma");
//        System.out.println(em.merge(emp));
       
        //delete
//        Employee emp=em.find(Employee.class, 101);
//        if(emp!=null)
//           em.remove(emp);
//        else
//           System.out.println("Record not found");
        
        
        em.getTransaction().commit();
        System.out.println("Ending App!!");
        em.close();
        emf.close();
        
        
    }
}
