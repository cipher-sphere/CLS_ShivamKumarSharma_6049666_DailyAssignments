package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee name must not be blank")
    @Size(min = 2, max = 100, message = "Employee name must be between 2 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Salary must not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @DecimalMax(value = "9999999.99", message = "Salary must not exceed 9,999,999.99")
    @Column(nullable = false)
    private Double salary;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_mobile_numbers",
            joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "mobile_number")
    @NotEmpty(message = "At least one mobile number is required")
    private Set<
        @NotBlank(message = "Mobile number must not be blank")
        @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must be a valid 10-digit Indian number starting with 6-9")
        String> mobileNumbers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    public Employee() {}

    public Employee(String name, Double salary, Set<String> mobileNumbers, Department department) {
        this.name = name;
        this.salary = salary;
        this.mobileNumbers = mobileNumbers;
        this.department = department;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Set<String> getMobileNumbers() { return mobileNumbers; }
    public void setMobileNumbers(Set<String> mobileNumbers) { this.mobileNumbers = mobileNumbers; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
