package lk.dialoglab.ezcash.dto;

public class ReloadDto {

    private Integer reloadId;
    private String atm;
    private String operator;
    private String taskExpiryTime;
    private int tray1;
    private int tray2;
    private int otk;

    public Integer getReloadId() {
        return reloadId;
    }

    public int getOtk() {
        return otk;
    }

    public void setOtk(int otk) {
        this.otk = otk;
    }

    public void setReloadId(Integer reloadId) {
        this.reloadId = reloadId;
    }

    public String getAtm() {
        return atm;
    }

    public void setAtm(String atm) {
        this.atm = atm;
    }

    public String getOperator() {
        return operator;
    }

    public int getTray1() {
        return tray1;
    }

    public void setTray1(int tray1) {
        this.tray1 = tray1;
    }

    public int getTray2() {
        return tray2;
    }

    public void setTray2(int tray2) {
        this.tray2 = tray2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTaskExpiryTime() {
        return taskExpiryTime;
    }

    public void setTaskExpiryTime(String taskExpiryTime) {
        this.taskExpiryTime = taskExpiryTime;
    }

}
