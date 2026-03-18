package Assignment7;

import java.util.List;

public class SBU {

    private int sbuId;;
   

	private String sbuHead;
    private String sbuName;
    private List<Employee>empList;

    
    public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	
	@Override
	public String toString() {
		return "SBU [sbuId=" + sbuId + ", sbuHead=" + sbuHead + ", sbuName=" + sbuName +"\n"+ "Employee Details....."+"\n"+"Employee" + empList + "]";
	}

	public int getSbuId() {
		return sbuId;
	}

	public void setSbuId(int sbuId) {
		this.sbuId = sbuId;
	}
    public String getSbuHead() {
        return sbuHead;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    public String getSbuName() {
        return sbuName;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }
}