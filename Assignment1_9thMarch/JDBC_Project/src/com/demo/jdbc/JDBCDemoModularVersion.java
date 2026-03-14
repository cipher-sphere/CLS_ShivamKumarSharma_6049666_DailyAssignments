package com.demo.jdbc;
import java.sql.*;
import java.util.Scanner;

class Employee{
	    
	    private int id;
	    private String name;
	    private double salary;
	    private String dept;
	    private long phoneno;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }


	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }

	    public String getDept() {
	        return dept;
	    }

	    public void setDept(String dept) {
	        this.dept = dept;
	    }

	    public long getPhoneno() {
	        return phoneno;
	    }

	    public void setPhoneno(long phoneno) {
	        this.phoneno = phoneno;
	    }
	
}

public class JDBCDemoModularVersion {

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        connect();

        int choice;

        do {
            System.out.println("\n----- EMPLOYEE MENU -----");
            System.out.println("1. Display Employees");
            System.out.println("2. Insert Employee");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch(choice)
            {
                case 1: displayEmp(); break;
                case 2: insertEmp(); break;
                case 3: updateEmp(); break;
                case 4: deleteEmp(); break;
                case 5: System.out.println("Exited"); break;
                default: System.out.println("Invalid Choice");
            }

        } while(choice != 5);

        con.close();
    }

    // Database Connection
    public static void connect() throws Exception {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/EmployeeDb";
        String user = "postgres";
        String password = "TIGER";

        con = DriverManager.getConnection(url,user,password);

        System.out.println("Database Connected");
    }

    // Display Employees
    public static void displayEmp() throws Exception {

        PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP");

        ResultSet rs = ps.executeQuery();

        while(rs.next())
        	
        {
        	Employee emp = new Employee();

            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setDept(rs.getString("dept"));
            emp.setPhoneno(rs.getLong("phoneno"));

            System.out.println(
                    emp.getId()+" "+
                    emp.getName()+" "+
                    emp.getSalary()+" "+
                    emp.getDept()+" "+
                    emp.getPhoneno());
        }

        rs.close();
        ps.close();
    }

    // Insert Employee
    public static void insertEmp() throws Exception {
    	 Employee emp = new Employee();

         System.out.print("Enter ID: ");
         emp.setId(sc.nextInt());

         System.out.print("Enter Name: ");
         emp.setName(sc.next());

         System.out.print("Enter Salary: ");
         emp.setSalary(sc.nextDouble());

         System.out.print("Enter Dept: ");
         emp.setDept(sc.next());

         System.out.print("Enter Phone: ");
         emp.setPhoneno(sc.nextLong());

         PreparedStatement ps =
                 con.prepareStatement("INSERT INTO EMP VALUES(?,?,?,?,?)");

         ps.setInt(1, emp.getId());
         ps.setString(2, emp.getName());
         ps.setDouble(3, emp.getSalary());
         ps.setString(4, emp.getDept());
         ps.setLong(5, emp.getPhoneno());

         int rows = ps.executeUpdate();

         System.out.println(rows + " Record Inserted");

        ps.close();
    }

    // Update Salary
    public static void updateEmp() throws Exception {

    	 Employee emp = new Employee();

         System.out.print("Enter Name: ");
         emp.setName(sc.next());

         System.out.print("Enter New Salary: ");
         emp.setSalary(sc.nextDouble());

         PreparedStatement ps =
                 con.prepareStatement("UPDATE EMP SET salary=? WHERE name=?");

         ps.setDouble(1, emp.getSalary());
         ps.setString(2, emp.getName());

         int rows = ps.executeUpdate();

         System.out.println(rows + " Record Updated");

        ps.close();
    }

    // Delete Employee
    public static void deleteEmp() throws Exception {

    	Employee emp = new Employee();

        System.out.print("Enter Name to Delete: ");
        emp.setName(sc.next());

        PreparedStatement ps =
                con.prepareStatement("DELETE FROM EMP WHERE name=?");

        ps.setString(1, emp.getName());

        int rows = ps.executeUpdate();

        if(rows > 0)
            System.out.println("Record Deleted");
        else
            System.out.println("No Record Found");

        ps.close();
    }
}