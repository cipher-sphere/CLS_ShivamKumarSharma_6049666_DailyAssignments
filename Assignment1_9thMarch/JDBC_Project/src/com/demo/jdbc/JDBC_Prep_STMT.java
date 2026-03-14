package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Prep_STMT {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load PostgreSQL Driver
        Class.forName("org.postgresql.Driver");

        // Database URL
        String url = "jdbc:postgresql://localhost:5432/EmployeeDb";

        // Username and Password
        String user = "postgres";
        String password = "TIGER";

        // Create Connection
        Connection con = DriverManager.getConnection(url, user, password);


        // SELECT Query
        PreparedStatement pstmtSelect =
                con.prepareStatement("SELECT * FROM EMP");

        ResultSet rs = pstmtSelect.executeQuery();

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


        // DELETE
        String delName = "Neha";

        PreparedStatement pstmtDelete =
                con.prepareStatement("DELETE FROM EMP WHERE name=?");

        pstmtDelete.setString(1, delName);

        int rowsAffected = pstmtDelete.executeUpdate();

        if(rowsAffected >= 1)
        {
            System.out.println("Record Deleted Successfully");
        }
        else
        {
            System.out.println("No Record Found");
        }


        // INSERT
        PreparedStatement pstmtInsert =
                con.prepareStatement("INSERT INTO EMP VALUES(?,?,?,?,?)");

        pstmtInsert.setInt(1, 10);
        pstmtInsert.setString(2, "Rohit");
        pstmtInsert.setDouble(3, 55000);
        pstmtInsert.setString(4, "IT");
        pstmtInsert.setLong(5, 9876543210L);

        int insertRows = pstmtInsert.executeUpdate();

        System.out.println(insertRows + " Record Inserted");


        // UPDATE
        PreparedStatement pstmtUpdate =
                con.prepareStatement("UPDATE EMP SET salary=? WHERE name=?");

        pstmtUpdate.setDouble(1, 65000);
        pstmtUpdate.setString(2, "Priya");

        int updateRows = pstmtUpdate.executeUpdate();

        System.out.println(updateRows + " Record Updated");


        // Close resources
        pstmtSelect.close();
        pstmtDelete.close();
        pstmtInsert.close();
        pstmtUpdate.close();
        con.close();
    }
}
