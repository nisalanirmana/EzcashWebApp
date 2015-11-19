package lk.dialoglab.ezcash.dto;

public class OperatorDto {

    private Integer operatorId;
    private String operatorName;
    private int phoneNumber;
    private String email;
    private int operatorPin;
    private String operatorType;

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOperatorPin() {
        return operatorPin;
    }

    public void setOperatorPin(int operatorPin) {
        this.operatorPin = operatorPin;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }
}
