package com.demo.jdbc2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String url = "jdbc:postgresql://localhost:5432/EmployeeDb";
    private static final String user = "postgres";
    private static final String password = "TIGER";

    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // CREATE TABLE
    public boolean createTable() throws SQLException {

        String sql = "create table if not exists employee("
                + "id int primary key,"
                + "dept varchar(50),"
                + "name varchar(50),"
                + "phoneno bigint,"
                + "salary double precision)";

        try (Connection con = getConnection();
             Statement st = con.createStatement()) {

            st.executeUpdate(sql);
            return true;
        }
    }

    // INSERT
    public Employee insertEmployee(Employee e) throws SQLException {

        String sql = "insert into employee values(?,?,?,?,?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getId());
            ps.setString(2, e.getDept());
            ps.setString(3, e.getName());
            ps.setLong(4, e.getPhoneno());
            ps.setDouble(5, e.getSalary());

            int r = ps.executeUpdate();

            if (r > 0)
                return e;

            return null;
        }
    }

    // FETCH BY ID
    public Employee getEmployeeById(int id) throws SQLException {

        String sql = "select * from employee where id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Employee(
                        rs.getInt("id"),
                        rs.getString("dept"),
                        rs.getString("name"),
                        rs.getLong("phoneno"),
                        rs.getDouble("salary")
                );
            }

            return null;
        }
    }

    // UPDATE
    public Employee updateSalary(int id, Employee e) throws SQLException {

        String sql = "update employee set salary=? where id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, e.getSalary());
            ps.setInt(2, id);

            int r = ps.executeUpdate();

            if (r > 0)
                return getEmployeeById(id);

            return null;
        }
    }

    // DELETE
    public Employee deleteEmployee(int id) throws SQLException {

        Employee emp = getEmployeeById(id);

        if (emp == null)
            return null;

        String sql = "delete from employee where id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int r = ps.executeUpdate();

            if (r > 0)
                return emp;

            return null;
        }
    }

    // SELECT ALL
    public List<Employee> getAllEmployees() throws SQLException {

        List<Employee> list = new ArrayList<>();

        String sql = "select * from employee";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("dept"),
                        rs.getString("name"),
                        rs.getLong("phoneno"),
                        rs.getDouble("salary")
                );

                list.add(e);
            }

            return list;
        }
    }
}