package cg.demos.springcore.problem2;

public class SBU {

    private int sbuId;
    private String sbuName;
    private String sbuHead;

    public void setSbuId(int sbuId) {
        this.sbuId = sbuId;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    @Override
    public String toString() {
        return "SBU Details\n" +
                "SBU Id: " + sbuId + "\n" +
                "SBU Name: " + sbuName + "\n" +
                "SBU Head: " + sbuHead;
    }
}