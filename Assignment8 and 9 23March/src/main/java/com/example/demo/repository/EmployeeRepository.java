package com.example.demo.repository;

import com.example.demo.dto.DepartmentEmployeeCountDTO;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Fetch all employees with their department name and manager name.
     * Uses JOIN FETCH for performance optimization to avoid N+1 problem.
     */
    @Query("SELECT e FROM Employee e JOIN FETCH e.department d")
    List<Employee> findAllEmployeesWithDepartment();

    /**
     * Count of employees grouped by department name.
     */
    @Query("SELECT new com.example.demo.dto.DepartmentEmployeeCountDTO(d.name, COUNT(e)) " +
           "FROM Employee e JOIN e.department d GROUP BY d.name")
    List<DepartmentEmployeeCountDTO> countEmployeesPerDepartment();

    /**
     * All employees under a specific department name.
     * Uses JOIN FETCH to load department in one query.
     */
    @Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE d.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    /**
     * Find an employee by mobile number.
     * Uses JOIN FETCH to load department in the same query.
     */
    @Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE :mobile MEMBER OF e.mobileNumbers")
    Optional<Employee> findEmployeeByMobileNumber(@Param("mobile") String mobile);
}
