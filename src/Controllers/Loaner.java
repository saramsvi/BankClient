package Controllers;

public class Loaner {
    private String LUsername;
    private String LReason;
    private String LAmount;
    private String LTime;
    private String LOccupation;
    private String LSalary;
    private String LMstatus;
    private String LKids;

    public Loaner(String username, String reason, String amount, String time, String occupation, String salary, String mstatus, String kids) {
        LUsername = username;
        LReason = reason;
        LAmount = amount;
        LTime = time;
        LOccupation = occupation;
        LSalary = salary;
        LMstatus = mstatus;
        LKids = kids;
    }

    public String getLUsername() {
        return LUsername;
    }

    public void setLUsername(String LUsername) {
        this.LUsername = LUsername;
    }

    public String getLReason() {
        return LReason;
    }

    public void setLReason(String LReason) {
        this.LReason = LReason;
    }

    public String getLAmount() {
        return LAmount;
    }

    public void setLAmount(String LAmount) {
        this.LAmount = LAmount;
    }

    public String getLTime() {
        return LTime;
    }

    public void setLTime(String LTime) {
        this.LTime = LTime;
    }

    public String getLOccupation() {
        return LOccupation;
    }

    public void setLOccupation(String LOccupation) {
        this.LOccupation = LOccupation;
    }

    public String getLSalary() {
        return LSalary;
    }

    public void setLSalary(String LSalary) {
        this.LSalary = LSalary;
    }

    public String getLMstatus() {
        return LMstatus;
    }

    public void setLMstatus(String LMstatus) {
        this.LMstatus = LMstatus;
    }

    public String getLKids() {
        return LKids;
    }

    public void setLKids(String LKids) {
        this.LKids = LKids;
    }
}
