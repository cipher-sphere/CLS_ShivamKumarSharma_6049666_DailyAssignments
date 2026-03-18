package Assignment6;



public class SBU {

    private int sbuId;;
   

	private String sbuHead;
    private String sbuName;

    
    @Override
	public String toString() {
		return "SBU [sbuId=" + sbuId + ", sbuHead=" + sbuHead + ", sbuName=" + sbuName + "]";
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