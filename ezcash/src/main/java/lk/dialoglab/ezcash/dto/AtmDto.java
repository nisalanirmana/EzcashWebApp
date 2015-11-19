package lk.dialoglab.ezcash.dto;

import java.util.Date;

public class AtmDto {

    private Integer atmId;
    private String atmName;
    private String atmLocation;
    private String serialNo;
    private int tray1;
    private int tray2;
    private String atmcode;
    private int tray1NoteValue;
    private int tray2NoteValue;
    private String Operator;
    private Date installedDate;
    private Date livePktTime;
    private Integer batLevel;
    private int reject1;
    private int reject2;
    private String status;

    public Date getInstalledDate() {
        return installedDate;
    }

    public void setInstalledDate(Date installedDate) {
        this.installedDate = installedDate;
    }

    public Date getLivePktTime() {
        return livePktTime;
    }

    public void setLivePktTime(Date livePktTime) {
        this.livePktTime = livePktTime;
    }

    public Integer getBatLevel() {
        return batLevel;
    }

    public void setBatLevel(Integer batLevel) {
        this.batLevel = batLevel;
    }

    public int getReject1() {
        return reject1;
    }

    public void setReject1(int reject1) {
        this.reject1 = reject1;
    }

    public int getReject2() {
        return reject2;
    }

    public void setReject2(int reject2) {
        this.reject2 = reject2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAtmId() {
        return atmId;
    }

    public void setAtmId(Integer atmId) {
        this.atmId = atmId;
    }

    public String getAtmName() {
        return atmName;
    }

    public void setAtmName(String atmName) {
        this.atmName = atmName;
    }

    public String getAtmLocation() {
        return atmLocation;
    }

    public void setAtmLocation(String atmLocation) {
        this.atmLocation = atmLocation;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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

    public String getAtmcode() {
        return atmcode;
    }

    public void setAtmcode(String atmcode) {
        this.atmcode = atmcode;
    }

    public int getTray1NoteValue() {
        return tray1NoteValue;
    }

    public void setTray1NoteValue(int tray1NoteValue) {
        this.tray1NoteValue = tray1NoteValue;
    }

    public int getTray2NoteValue() {
        return tray2NoteValue;
    }

    public void setTray2NoteValue(int tray2NoteValue) {
        this.tray2NoteValue = tray2NoteValue;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String operator) {
        Operator = operator;
    }

}
