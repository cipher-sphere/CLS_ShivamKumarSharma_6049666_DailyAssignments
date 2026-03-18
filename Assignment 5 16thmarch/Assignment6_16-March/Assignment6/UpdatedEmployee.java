package Assignment6;

public class UpdatedEmployee {

    private int employeeId;
    private String employeeName;
    private double salary;
    private int age;

    private SBU sbu;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SBU getSbu() {
        return sbu;
    }

    public void setSbu(SBU sbu) {
        this.sbu = sbu;
    }

	@Override
	public String toString() {
		return "UpdatedEmployee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", age=" + age +"\n"+ ", sbuDetails=" + sbu + "]";
	}

    
}