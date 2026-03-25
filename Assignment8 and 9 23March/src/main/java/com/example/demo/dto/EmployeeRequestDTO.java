package com.example.demo.dto;

import jakarta.validation.constraints.*;

import java.util.Set;

public class EmployeeRequestDTO {

    @NotBlank(message = "Employee name must not be blank")
    @Size(min = 2, max = 100, message = "Employee name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Salary must not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @DecimalMax(value = "9999999.99", message = "Salary must not exceed 9,999,999.99")
    private Double salary;

    @NotEmpty(message = "At least one mobile number is required")
    private Set<
        @NotBlank(message = "Mobile number must not be blank")
        @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must be a valid 10-digit Indian number starting with 6-9")
        String> mobileNumbers;

    @NotNull(message = "Department ID must not be null")
    private Long departmentId;

    public EmployeeRequestDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Set<String> getMobileNumbers() { return mobileNumbers; }
    public void setMobileNumbers(Set<String> mobileNumbers) { this.mobileNumbers = mobileNumbers; }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
}
