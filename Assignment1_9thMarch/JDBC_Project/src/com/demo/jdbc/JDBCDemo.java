package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    	// Load PostgreSQL Driver
        Class.forName("org.postgresql.Driver");

        // Database URL
        String url = "jdbc:postgresql://localhost:5432/EmployeeDb";

        // Username and Password of postgre
        String user = "postgres";
        String password = "TIGER";

        // Create Connection
        Connection con = DriverManager.getConnection(url, user, password);

        // Create Statement
        Statement stmt = con.createStatement();

        // Execute Query
        ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");

        // Display Data
        while(rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double salary = rs.getDouble("salary");
            String dept = rs.getString("dept");
            long phoneno = rs.getLong("phoneno");

            System.out.println(id+" "+name+" "+salary+" "+dept+" "+phoneno);
        }

        rs.close();

        // Deletion
        String delName = "Neha";

        int rowsAffected = stmt.executeUpdate(
                "DELETE FROM EMP WHERE name='"+delName+"'");

        if(rowsAffected >=1)
        {
            System.out.println("Record Deleted Successfully");
        }
        else
        {
            System.out.println("No Record Found");
        }


        // Insertion
        int insertRows = stmt.executeUpdate(
        "INSERT INTO EMP VALUES(10,'Rohit',55000,'IT',9876543210)");

        System.out.println(insertRows+" Record Inserted");


        // Update
        int updateRows = stmt.executeUpdate(
        "UPDATE EMP SET salary=65000 WHERE name='Priya'");

        System.out.println(updateRows+" Record Updated");


        stmt.close();
        con.close();
    }
}