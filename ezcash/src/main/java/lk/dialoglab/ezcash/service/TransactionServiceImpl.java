package lk.dialoglab.ezcash.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.dialoglab.ezcash.dao.CashOutDAO;
import lk.dialoglab.ezcash.dao.TransactionDAO;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.CashOut;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.util.HibernateUtil;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDAO transactionDao;
    @Autowired
    private CashOutDAO cashoutDao;

   
    public List<CashOut> getCashOuts() {
        List<CashOut> cashouts = null;
        try {
            HibernateUtil.beginTransaction();
           
            cashouts = cashoutDao.getCashOuts();


            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return cashouts;

    }
    
    

    public List<Transactions> getTransactionsCompleted() {
        List<Transactions> transactions = null;
        try {
            HibernateUtil.beginTransaction();
           
            transactions = transactionDao.getTransactionsCompleted();


            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return transactions;

    }
    
    
    /*
    public List<Transactions> getTransactionsCompleted() {
        List<Transactions> cashouts =new ArrayList<Transactions>();
        Set<Transactions> transactionses =null;
        CashOut cashout = new CashOut();
        try {
            HibernateUtil.beginTransaction();
           
          //  cashouts = cashoutDao.getCashOuts();
            transactionses =cashout.getTransactionses();
            System.out.println("sadassssssssssssssssssssssssssssssssssssssssss");
            System.out.println("size" +transactionses.size());
            cashouts.addAll(transactionses);
            System.out.println("size" +cashouts.size());
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }
        
        return cashouts;

    }
    */


   
    public List<CashOut> getCashOutbyAtm(String atmname){
        System.out.println("getCashOutbyAtm(String atmname)");
        List<CashOut> cashoutsatm = null;
        try {
            HibernateUtil.beginTransaction();
           
            cashoutsatm = cashoutDao.getCashOutbyAtm(atmname);


            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return cashoutsatm;
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

    public List<CashOut> getFilteredCashOuts(Date fromDate, Date toDate) {
        List<CashOut> cashouts = null;

        try {
            HibernateUtil.beginTransaction();

            cashouts = cashoutDao.getFilteredCashOuts(fromDate, toDate);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return cashouts;

    }
    public List<CashOut> getFilteredCashOutsbyAtm(Date fromDate, Date toDate,String atmName){
        List<CashOut> cashouts = null;

        try {
            HibernateUtil.beginTransaction();

            cashouts = cashoutDao.getFilteredCashOutsbyAtm(fromDate, toDate,atmName);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return cashouts;

    }
    
    public List<Transactions> getFilteredTransactions(Date fromDate, Date toDate) {
        List<Transactions> cashouts = null;

        try {
            HibernateUtil.beginTransaction();

            cashouts = transactionDao.getFilteredTrans(fromDate, toDate);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return cashouts;

    }
    public List<Transactions> getFilteredTransactionsbyAtm(Date fromDate, Date toDate,String atmName){
        List<Transactions> cashouts = null;

        try {
            HibernateUtil.beginTransaction();

            cashouts = transactionDao.getFilteredTransbyAtm(fromDate, toDate,atmName);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return cashouts;

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
    
    public List<Transactions> getFilteredReloadsbyAtm(Date fromDate, Date toDate,String atmName)  {
        List<Transactions> reloads = null;

        try {
            HibernateUtil.beginTransaction();

            reloads = transactionDao.getFilteredReloadsbyAtm(fromDate, toDate, atmName);

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
    public CashOut findCashOutbyid(int id) {
        CashOut cashoutfind = null;
        try {
            HibernateUtil.beginTransaction();
            System.out.println("found" + id);
            cashoutfind = cashoutDao.findByID(CashOut.class, id);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        System.out.println("return" + id);
        return cashoutfind;
    }

    @Override
    public void deleteCashOutbyid(CashOut cashout) {
        try {
            HibernateUtil.beginTransaction();
            cashoutDao.delete(cashout);
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
