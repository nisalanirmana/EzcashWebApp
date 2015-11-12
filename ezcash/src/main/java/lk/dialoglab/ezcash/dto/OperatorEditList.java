package lk.dialoglab.ezcash.dto;

import java.util.ArrayList;
import java.util.List;

import lk.dialoglab.ezcash.domain.AtmLocation;
import lk.dialoglab.ezcash.domain.Operator;

public class OperatorEditList {
public static ArrayList<Operator> operator;
public static String taskvariable="addOperator";
public static String taskvariableshow="Add New";

public static String getTaskvariableshow() {
	return taskvariableshow;
}

public static void setTaskvariableshow(String taskvariableshow) {
	OperatorEditList.taskvariableshow = taskvariableshow;
}

public static ArrayList<Operator> getOperator() {
	return operator;
}

public static void setOperator(List<Operator> operatorlist) {
	OperatorEditList.operator = (ArrayList<Operator>) operatorlist;
}

public static void clearOperator(){
	OperatorEditList.operator =null;
}

public static String getTaskvariable() {
	return taskvariable;
}

public static void setTaskvariable(String taskvariable) {
	OperatorEditList.taskvariable = taskvariable;
}




}
