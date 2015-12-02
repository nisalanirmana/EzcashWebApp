package lk.dialoglab.ezcash.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.dialoglab.ezcash.dao.TransactionDAO;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.util.HibernateUtil;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDAO transactionDao;

    public List<Transactions> getTransactions() {
        List<Transactions> transactions = null;
        try {
            HibernateUtil.beginTransaction();
           
            transactions = transactionDao.getTransactions();


            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return transactions;

    }

    public List<Transactions> getReloads() {
        List<Transactions> reloads = null;
        try {
            HibernateUtil.beginTransaction();
            // transactions = transactionDao.findAll(Transactions.class);
            reloads = transactionDao.getReloads();

          //  System.out.println("Transaction amount" + reloads.get(2).getTray1());
         //   System.out.println("Transaction amount" + reloads.get(2).getTray2());
           // System.out.println("Cashout date" + reloads.get(2).getAtmReload().getReloadEndTime());
            // System.out.println("Transaction amount"+transactions.get(1).getAtmReload().getReloadId());

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return reloads;

    }

    /*
     * @Override
     * public List<Transactions> getReloads(){
     * List<Transactions> reloads=null;
     * try {
     * HibernateUtil.beginTransaction();
     * reloads = transactionDao.findAll(Transactions.class);
     * 
     * 
     * HibernateUtil.commitTransaction();
     * } catch (Exception e) {
     * e.printStackTrace();
     * HibernateUtil.rollbackTransaction();
     * 
     * }
     * 
     * return reloads;
     * 
     * 
     * }
     */

    public List<Transactions> getFilteredTrans(Date fromDate, Date toDate) {
        List<Transactions> transactions = null;

        try {
            HibernateUtil.beginTransaction();

            transactions = transactionDao.getFilteredTrans(fromDate, toDate);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return transactions;

    }
    
    public List<Transactions> getFilteredReloads(Date fromDate, Date toDate) {
        List<Transactions> reloads = null;

        try {
            HibernateUtil.beginTransaction();

            reloads = transactionDao.getFilteredReloads(fromDate, toDate);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return reloads;

    }

    @Override
    public Transactions findtransactionbyid(int id) {
        Transactions transactionsfind = null;
        try {
            HibernateUtil.beginTransaction();
            System.out.println("found" + id);
            transactionsfind = transactionDao.findByID(Transactions.class, id);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        System.out.println("return" + id);
        return transactionsfind;
    }

    @Override
    public void deletetransactionbyid(Transactions transaction) {
        try {
            HibernateUtil.beginTransaction();
            transactionDao.delete(transaction);
            System.out.println("Deleted");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    @Override
    public List<Transactions> getTransactionbyReloadid(int id) {
        List<Transactions> transactions = null;
        try {
            HibernateUtil.beginTransaction();
            System.out.println("found" + id);
            transactions = transactionDao.getTransactionbyReloadid(id);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        System.out.println("return" + id);
        return transactions;
    }

}
