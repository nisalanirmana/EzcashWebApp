package lk.dialoglab.ezcash.dto;

public class AtmLocationDto {
private int locationId;
private String locationName;
private String locationX;
private String locationY;

public int getLocationId() {
	return locationId;
}

public void setLocationId(int locationId) {
	this.locationId = locationId;
}

public String getLocationX() {
	return locationX;
}

public void setLocationX(String locationX) {
	this.locationX = locationX;
}

public String getLocationY() {
	return locationY;
}

public void setLocationY(String locationY) {
	this.locationY = locationY;
}

public String getLocationName() {
	return locationName;
}

public void setLocationName(String locationName) {
	this.locationName = locationName;
}	

}
