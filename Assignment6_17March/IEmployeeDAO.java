package Assignment6_17March;

import java.util.List;

public interface IEmployeeDAO {

    Employee addEmployee(Employee emp);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee emp);
    boolean deleteEmployee(int id);
}