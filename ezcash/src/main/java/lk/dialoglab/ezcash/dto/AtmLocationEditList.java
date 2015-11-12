package lk.dialoglab.ezcash.dto;

import java.util.ArrayList;
import java.util.List;

import lk.dialoglab.ezcash.domain.AtmLocation;

public class AtmLocationEditList {
public static ArrayList<AtmLocation> atmlocation;
public static String taskvariable="addAtmLocation";
public static String taskvariableshow="Add New";

public static String getTaskvariableshow() {
	return taskvariableshow;
}

public static void setTaskvariableshow(String taskvariableshow) {
	AtmLocationEditList.taskvariableshow = taskvariableshow;
}

public static ArrayList<AtmLocation> getAtmlocation() {
	return atmlocation;
}

public static void setAtmlocation(List<AtmLocation> atmlocationlist) {
	AtmLocationEditList.atmlocation = (ArrayList<AtmLocation>) atmlocationlist;
}

public static void clearAtmLocation(){
	AtmLocationEditList.atmlocation =null;
}

public static String getTaskvariable() {
	return taskvariable;
}

public static void setTaskvariable(String taskvariable) {
	AtmLocationEditList.taskvariable = taskvariable;
}




}
