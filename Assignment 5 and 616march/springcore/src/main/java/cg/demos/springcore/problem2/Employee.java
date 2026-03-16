package cg.demos.springcore.problem2;

public class Employee {

    private int employeeId;
    private String employeeName;
    private double salary;
    private int age;

    private SBU businessUnit;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBusinessUnit(SBU businessUnit) {
        this.businessUnit = businessUnit;
    }

    public void displayEmployeeDetails() {

        System.out.println("Employee Details");
        System.out.println("----------------------");

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);

        System.out.println();
        System.out.println(businessUnit);
    }
}