package lk.dialoglab.ezcash.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.dao.AtmDAO;
import lk.dialoglab.ezcash.dao.OperatorDAO;
import lk.dialoglab.ezcash.dao.ReloadDAO;
import lk.dialoglab.ezcash.dao.TransactionDAO;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.dto.ReloadDto;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReloadServiceImpl implements ReloadService {

    @Autowired
    ReloadDAO reloadDao;

    @Override
    public List<AtmReload> getReload() {
        List<AtmReload> reload = null;
        try {
            HibernateUtil.beginTransaction();
            reload = reloadDao.findAll(AtmReload.class);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return reload;

    }
    
    @Override
    public List<AtmReload> getReloadsbyAtm(String atmname){
        List<AtmReload> reload = null;
        try {
            HibernateUtil.beginTransaction();
            reload = reloadDao.getReloadsbyAtm(atmname);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return reload;

    }

    @Override
    public AtmReload findreloadbyid(int id) {
        AtmReload reloadfind = null;
        try {
            HibernateUtil.beginTransaction();
            System.out.println("found" + id);
            reloadfind = reloadDao.findByID(AtmReload.class, id);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        System.out.println("return" + id);
        return reloadfind;
    }

    @Override
    public void deletereloadbyid(AtmReload atmreload) {
        try {
            HibernateUtil.beginTransaction();
            reloadDao.delete(atmreload);
            System.out.println("Deleted");
            HibernateUtil.commitTransaction();
        }
        /*
         * catch (ConstraintViolationException ex) {
         * System.out.println("Transaction Table");
         * 
         * 
         * 
         * ex.printStackTrace();
         * HibernateUtil.rollbackTransaction();
         * 
         * }
         */
        catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    @Override
    public void addReload(ReloadDto reloaddto) {

        try {
            HibernateUtil.beginTransaction();
            AtmReload reload = new AtmReload();
            reload.setReloadId(reloaddto.getReloadId());

            // Atm//
            /*
             * Atm atmObject = new Atm();// create a new ATM object
             * String str1Id = reloaddto.getAtm(); // we receive id as a string
             * Integer atmId = Integer.parseInt(str1Id); // need to convert string to Integer
             * atmObject.setAtmId(atmId); // set this to newly created ATM object
             * reload.setAtm( atmObject ); // set this to reload
             */

            // Atm
            Atm atmObject = new Atm();// create a new ATM object
            String str1Id = reloaddto.getAtm(); // we receive id as a string
            // Integer atmId = Integer.parseInt(str1Id); // need to convert string to Integer
            // System.out.println("Atm name1 "+str1Id);
            // atmObject.setAtmName(str1Id);
            // System.out.println("atm Id " + reloadDao.getAtmID(str1Id));
            atmObject.setAtmId(reloadDao.getAtmID(str1Id));// set this to newly created ATM object
            // System.out.println("Atm name2 "+atmObject.getAtmName());
            reload.setAtm(atmObject); // set this to reload
            // System.out.println("Atm name3 "+reload.getAtm().getAtmName());
            // Atm//

            // Operator//
            /*
             * Operator operatorObject = new Operator();
             * String str2Id = reloaddto.getOperator();
             * Integer operatorId = Integer.valueOf(str2Id);
             * operatorObject.setOperatorId(operatorId);
             * reload.setOperator(operatorObject);
             */
            // Operator//
            Operator operatorObject = new Operator();// create a new ATM object
            String str1Id2 = reloaddto.getOperator(); // we receive id as a string
            // Integer atmId = Integer.parseInt(str1Id); // need to convert string to Integer
            // System.out.println("Operator name1 "+str1Id2);
            // atmObject.setAtmName(str1Id);
            // System.out.println("atm Id " + reloadDao.getAtmID(str1Id));
            operatorObject.setOperatorId(reloadDao.getOperatorID(str1Id2));// set this to newly created ATM object
            // System.out.println("Atm name2 "+atmObject.getAtmName());
            reload.setOperator(operatorObject); // set this to reload
            // System.out.println("Atm name3 "+reload.getAtm().getAtmName());

            // DateExpiry//
            DateFormat formatter1 = new SimpleDateFormat("dd-MM-yy hh:mm");
            System.out.println("From Service" + reloaddto.getTaskExpiryTime());
            Date date1 = formatter1.parse(reloaddto.getTaskExpiryTime());
            System.out.println("From Service after Format" + date1);
            reload.setTaskExpiryTime(date1);
            // DateExpiry//
            DateFormat formatter2 = new SimpleDateFormat("dd-MM-yy hh:mm");
            Date date2 = new Date();
            Date datenow = formatter1.parse(formatter2.format(date2));
            reload.setTaskCreatedTime(datenow);
            // DateCreated//

            // DateCreated//

            reload.setTray1(reloaddto.getTray1());
            reload.setTray2(reloaddto.getTray2());
            // status
            reload.setStatus("1");
            // otk
            reload.setotk(1);
            reloadDao.save(reload);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

    }

    @Autowired
    private AtmDAO atmDao;

    public List<Atm> getAtmDropDownList() {
        List<Atm> atm = null;
        try {
            HibernateUtil.beginTransaction();
            atm = atmDao.getAtmDropDownList();
            // System.out.println("Transaction amount"+atm.get(0).getAtmName());
            // System.out.println("Cashout date"+atm.get(1).getAtmName());
            System.out.println("hi");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        return atm;
    }

    @Autowired
    private OperatorDAO operatorDao;

    public List<Operator> getOperatorDropDownList() {
        List<Operator> operator = null;
        try {
            HibernateUtil.beginTransaction();
            operator = operatorDao.getOperatorDropDownList();
            // System.out.println("Transaction amount"+atm.get(1).getAtmName());
            // System.out.println("Cashout date"+atm.get(1).getAtmName());

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        return operator;
    }

}
