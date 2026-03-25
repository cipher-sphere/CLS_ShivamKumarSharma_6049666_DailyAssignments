package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DepartmentNameNotFoundException;
import com.example.demo.exception.MobileNumberDoesNotExistsForEmployeeException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    // ─────────────────────────────────────────────
    // 1. Insert Employee
    // ─────────────────────────────────────────────
    @Transactional
    public Employee insertEmployee(EmployeeRequestDTO dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new DepartmentNameNotFoundException(
                        "ID: " + dto.getDepartmentId()));

        Employee employee = new Employee(
                dto.getName(),
                dto.getSalary(),
                dto.getMobileNumbers(),
                department
        );
        return employeeRepository.save(employee);
    }

    // ─────────────────────────────────────────────
    // 2. Fetch all employees with dept name & manager name
    // ─────────────────────────────────────────────
    public List<EmployeeWithDepartmentDTO> fetchAllEmployeesWithDepartment() {
        return employeeRepository.findAllEmployeesWithDepartment()
                .stream()
                .map(e -> new EmployeeWithDepartmentDTO(
                        e.getId(),
                        e.getName(),
                        e.getSalary(),
                        e.getMobileNumbers(),
                        e.getDepartment().getName(),
                        e.getDepartment().getManagerName()
                ))
                .collect(Collectors.toList());
    }

    // ─────────────────────────────────────────────
    // 3. Number of employees per department
    // ─────────────────────────────────────────────
    public List<DepartmentEmployeeCountDTO> countEmployeesPerDepartment() {
        return employeeRepository.countEmployeesPerDepartment();
    }

    // ─────────────────────────────────────────────
    // 4. Employees under a given department name
    // ─────────────────────────────────────────────
    public List<Employee> fetchEmployeesByDepartmentName(String departmentName) {
        // Validate department exists
        if (!departmentRepository.existsByName(departmentName)) {
            throw new DepartmentNameNotFoundException(departmentName);
        }
        List<Employee> employees = employeeRepository.findEmployeesByDepartmentName(departmentName);
        return employees;
    }

    // ─────────────────────────────────────────────
    // 5. Complete department details by mobile number
    // ─────────────────────────────────────────────
    public EmployeeDepartmentByMobileDTO fetchDepartmentByMobileNumber(String mobileNumber) {
        Employee employee = employeeRepository.findEmployeeByMobileNumber(mobileNumber)
                .orElseThrow(() -> new MobileNumberDoesNotExistsForEmployeeException(mobileNumber));

        Department dept = employee.getDepartment();
        return new EmployeeDepartmentByMobileDTO(
                employee.getId(),
                employee.getName(),
                dept.getId(),
                dept.getName(),
                dept.getManagerName()
        );
    }
}
