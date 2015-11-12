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
