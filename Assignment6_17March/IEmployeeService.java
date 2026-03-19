package Assignment6_17March;
import java.util.List;

public interface IEmployeeService {

    Employee createEmployee(Employee emp);
    Employee fetchEmployee(int id);
    List<Employee> fetchAll();
    Employee modifyEmployee(Employee emp);
    boolean removeEmployee(int id);
}