package cg.demos.springcore.problem1;

public class Employee {

    private int employeeId;
    private String employeeName;
    private double salary;
    private String businessUnit;
    private int age;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayEmployeeDetails() {

        System.out.println("Employee Details");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Salary: " + salary);
        System.out.println("Business Unit: " + businessUnit);
        System.out.println("Age: " + age);
    }
}