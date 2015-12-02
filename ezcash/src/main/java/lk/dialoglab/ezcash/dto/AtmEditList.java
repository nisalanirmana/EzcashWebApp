package lk.dialoglab.ezcash.dto;

import java.util.ArrayList;
import java.util.List;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmLocation;
import lk.dialoglab.ezcash.domain.Operator;

public class AtmEditList {
    public static ArrayList<Atm> atm;
    public static String taskvariable = "addAtm";
    public static String taskvariableshow = "Add New";
    public static String disablebtntype = "submit" ;
    public static String enablebtntype = "submit" ;
    public static String rebootbtntype = "submit" ;
    public static String unlockbtntype = "submit" ;
    

    public static String getRebootbtntype() {
        return rebootbtntype;
    }

    public static void setRebootbtntype(String rebootbtntype) {
        AtmEditList.rebootbtntype = rebootbtntype;
    }

    public static String getUnlockbtntype() {
        return unlockbtntype;
    }

    public static void setUnlockbtntype(String unlockbtntype) {
        AtmEditList.unlockbtntype = unlockbtntype;
    }

    public static String getDisablebtntype() {
        return disablebtntype;
    }

    public static void setDisablebtntype(String disablebtntype) {
        AtmEditList.disablebtntype = disablebtntype;
    }

    public static String getEnablebtntype() {
        return enablebtntype;
    }

    public static void setEnablebtntype(String enablebtntype) {
        AtmEditList.enablebtntype = enablebtntype;
    }

    public static String getTaskvariableshow() {
        return taskvariableshow;
    }

    public static void setTaskvariableshow(String taskvariableshow) {
        AtmEditList.taskvariableshow = taskvariableshow;
    }

    public static ArrayList<Atm> getAtm() {
        return atm;
    }

    public static void setAtm(List<Atm> atmlist) {
        AtmEditList.atm = (ArrayList<Atm>) atmlist;
    }

    public static void clearAtm() {
        AtmEditList.atm = null;
    }

    public static String getTaskvariable() {
        return taskvariable;
    }

    public static void setTaskvariable(String taskvariable) {
        AtmEditList.taskvariable = taskvariable;
    }

}
