package Assignment6_17March;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServiceImpl implements IEmployeeService, DisposableBean {

    @Autowired
    private IEmployeeDAO dao;

    @Override
    public Employee createEmployee(Employee emp) {
        return dao.addEmployee(emp);
    }

    @Override
    public Employee fetchEmployee(int id) {
        return dao.getEmployeeById(id);
    }

    @Override
    public List<Employee> fetchAll() {
        return dao.getAllEmployees();
    }

    @Override
    public Employee modifyEmployee(Employee emp) {
        return dao.updateEmployee(emp);
    }

    @Override
    public boolean removeEmployee(int id) {
        return dao.deleteEmployee(id);
    }

    @Override
    public void destroy() {
        System.out.println("Service Bean Destroyed");
    }
}