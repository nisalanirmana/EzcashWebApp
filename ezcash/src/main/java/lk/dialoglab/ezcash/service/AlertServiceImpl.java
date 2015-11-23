package lk.dialoglab.ezcash.service;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.dao.AlertDAO;
import lk.dialoglab.ezcash.dao.AtmDAO;
import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertDAO alertDao;

    @Override
    public List<Alerts> getAlerts() {
        List<Alerts> alerts = null;
        try {
            HibernateUtil.beginTransaction();
            // alerts = alertDao.findAll(Alerts.class);
            alerts = alertDao.getAlerts();

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return alerts;

    }
    
    @Override
    public Alerts findalertbyid(int id) {
        Alerts alertsfind = new Alerts();
        try {
            HibernateUtil.beginTransaction();
            System.out.println("found" + id);
            alertsfind = alertDao.findByID(Alerts.class, id);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        System.out.println("return" + id);
        return alertsfind;
    }

    @Override
    public void deletealertbyid(Alerts alert){
        try {
            HibernateUtil.beginTransaction();
            alertDao.delete(alert);
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
    
    public List<Alerts> getFilteredAlerts(Date fromDate, Date toDate) {
        List<Alerts> alerts = null;

        try {
            HibernateUtil.beginTransaction();

            alerts = alertDao.getFilteredAlerts(fromDate, toDate);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return alerts;

    }

}
