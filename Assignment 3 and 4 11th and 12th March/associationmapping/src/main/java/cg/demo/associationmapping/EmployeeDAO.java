//package cg.demo.associationmapping;
//
//import jakarta.persistence.*;
//import jakarta.persistence.criteria.*;
//
//import java.util.*;
//
//public class EmployeeDAO {
//
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
//    EntityManager em = emf.createEntityManager();
//
//    // INSERT EMPLOYEE
//    public Employee insertEmployee(Employee e) throws Exception {
//
//        em.getTransaction().begin();
//        em.persist(e);
//        em.getTransaction().commit();
//
//        return e;
//    }
//
//    // FETCH EMPLOYEES WITH DEPARTMENT (JPQL JOIN)
//    public List<Object[]> fetchAllEmployees() throws Exception {
//
//        List<Object[]> list = em.createQuery(
//                "SELECT e.name, d.name, d.managerName FROM Employee e JOIN e.department d",
//                Object[].class)
//                .getResultList();
//
//        return list;
//    }
//
//    // FETCH ALL EMPLOYEES USING CRITERIA QUERY
//    public List<Employee> getAllEmployees() throws Exception {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
//
//        Root<Employee> emp = cq.from(Employee.class);
//
//        cq.select(emp);
//
//        return em.createQuery(cq).getResultList();
//    }
//
//    // FETCH EMPLOYEES WITH SALARY GREATER THAN GIVEN VALUE
//    public List<Employee> fetchEmployeeGreaterThanSalary(double salary) {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
//
//        Root<Employee> root = cq.from(Employee.class);
//
//        Predicate predicate = cb.gt(root.get("salary"), salary);
//
//        cq.select(root).where(predicate);
//
//        TypedQuery<Employee> query = em.createQuery(cq);
//
//        return query.getResultList();
//    }
//
//    // COUNT EMPLOYEES PER DEPARTMENT
//    public List<Object[]> countEmployeesPerDept() throws Exception {
//
//        List<Object[]> list = em.createQuery(
//                "SELECT d.name, COUNT(e) FROM Department d JOIN d.employees e GROUP BY d.name",
//                Object[].class)
//                .getResultList();
//
//        return list;
//    }
//
//    // FETCH EMPLOYEES BY DEPARTMENT
//    public List<Employee> employeesByDepartment(String deptName) throws Exception {
//
//        List<Employee> list = em.createQuery(
//                "FROM Employee e WHERE e.department.name = :name",
//                Employee.class)
//                .setParameter("name", deptName)
//                .getResultList();
//
//        return list;
//    }
//
//    // FIND EMPLOYEE + DEPARTMENT USING MOBILE NUMBER
//    public List<Object[]> departmentByMobile(String mobile) throws Exception {
//
//        List<Object[]> list = em.createQuery(
//                "SELECT e.id, e.name, d.name FROM Employee e JOIN e.mobileNumbers m JOIN e.department d WHERE m = :num",
//                Object[].class)
//                .setParameter("num", mobile)
//                .getResultList();
//
//        return list;
//    }
//
//    // CLOSE RESOURCES
//    public void close() {
//
//        if (em != null) {
//            em.close();
//        }
//
//        if (emf != null) {
//            emf.close();
//        }
//    }
//}



package cg.demo.associationmapping;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import java.util.*;

public class EmployeeDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
    EntityManager em = emf.createEntityManager();

    // INSERT EMPLOYEE
    public Employee insertEmployee(Employee e) throws Exception {

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

        return e;
    }

    // FETCH EMPLOYEE NAME + DEPARTMENT NAME + MANAGER (CRITERIA JOIN)
    public List<Object[]> fetchAllEmployees() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Employee> emp = cq.from(Employee.class);
        Join<Employee, Department> dept = emp.join("department");

        cq.multiselect(
                emp.get("name"),
                dept.get("name"),
                dept.get("managerName")
        );

        return em.createQuery(cq).getResultList();
    }

    // FETCH ALL EMPLOYEES
    public List<Employee> getAllEmployees() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> emp = cq.from(Employee.class);
        cq.select(emp);

        return em.createQuery(cq).getResultList();
    }

    // FETCH EMPLOYEES WITH SALARY GREATER THAN
    public List<Employee> fetchEmployeeGreaterThanSalary(double salary) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> root = cq.from(Employee.class);

        Predicate salaryPredicate = cb.gt(root.get("salary"), salary);

        cq.select(root).where(salaryPredicate);

        return em.createQuery(cq).getResultList();
    }

    // COUNT EMPLOYEES PER DEPARTMENT
    public List<Object[]> countEmployeesPerDept() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Department> dept = cq.from(Department.class);
        Join<Department, Employee> emp = dept.join("employees");

        cq.multiselect(
                dept.get("name"),
                cb.count(emp)
        );

        cq.groupBy(dept.get("name"));

        return em.createQuery(cq).getResultList();
    }

    // EMPLOYEES BY DEPARTMENT NAME
    public List<Employee> employeesByDepartment(String deptName) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> emp = cq.from(Employee.class);

        Predicate deptPredicate =
                cb.equal(emp.get("department").get("name"), deptName);

        cq.select(emp).where(deptPredicate);

        return em.createQuery(cq).getResultList();
    }

    // FIND EMPLOYEE + DEPARTMENT USING MOBILE NUMBER
    public List<Object[]> departmentByMobile(String mobile) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Employee> emp = cq.from(Employee.class);

        Join<Employee, String> mobileJoin = emp.join("mobileNumbers");
        Join<Employee, Department> deptJoin = emp.join("department");

        Predicate mobilePredicate = cb.equal(mobileJoin, mobile);

        cq.multiselect(
                emp.get("id"),
                emp.get("name"),
                deptJoin.get("name")
        ).where(mobilePredicate);

        return em.createQuery(cq).getResultList();
    }

    // CLOSE RESOURCES
    public void close() {

        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}