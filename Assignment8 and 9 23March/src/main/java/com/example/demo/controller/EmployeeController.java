package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * POST /api/employees
     * 1. Insert an employee
     */
    @PostMapping
    public ResponseEntity<Employee> insertEmployee(@Valid @RequestBody EmployeeRequestDTO dto) {
        Employee saved = employeeService.insertEmployee(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * GET /api/employees
     * 2. Fetch all employees with department name and manager name
     */
    @GetMapping
    public ResponseEntity<List<EmployeeWithDepartmentDTO>> getAllEmployeesWithDepartment() {
        return ResponseEntity.ok(employeeService.fetchAllEmployeesWithDepartment());
    }

    /**
     * GET /api/employees/count-per-department
     * 3. Number of employees working under each department
     */
    @GetMapping("/count-per-department")
    public ResponseEntity<List<DepartmentEmployeeCountDTO>> countEmployeesPerDepartment() {
        return ResponseEntity.ok(employeeService.countEmployeesPerDepartment());
    }

    /**
     * GET /api/employees/by-department?name=HR
     * 4. All employees under given department name
     */
    @GetMapping("/by-department")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(
            @RequestParam("name") String departmentName) {
        return ResponseEntity.ok(employeeService.fetchEmployeesByDepartmentName(departmentName));
    }

    /**
     * GET /api/employees/by-mobile?number=9876543210
     * 5. Complete department details of an employee by mobile number
     */
    @GetMapping("/by-mobile")
    public ResponseEntity<EmployeeDepartmentByMobileDTO> getEmployeeByMobile(
            @RequestParam("number")
            @Pattern(regexp = "^[6-9]\\d{9}$",
                     message = "Mobile number must be a valid 10-digit Indian number starting with 6-9")
            String mobileNumber) {
        return ResponseEntity.ok(employeeService.fetchDepartmentByMobileNumber(mobileNumber));
    }
}
