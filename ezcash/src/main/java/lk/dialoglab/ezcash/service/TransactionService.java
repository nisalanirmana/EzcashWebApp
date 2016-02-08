package lk.dialoglab.ezcash.service;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.CashOut;
import lk.dialoglab.ezcash.domain.Transactions;

public interface TransactionService {

   public List<CashOut> getCashOuts();
   public List<Transactions> getTransactionsCompleted();

    public List<Transactions> getReloads();

    public List<CashOut> getFilteredCashOuts(Date fromDate, Date toDate);
    public List<CashOut> getFilteredCashOutsbyAtm(Date fromDate, Date toDate,String atmName);
    
    public List<Transactions> getFilteredTransactions(Date fromDate, Date toDate);
    public List<Transactions> getFilteredTransactionsbyAtm(Date fromDate, Date toDate,String atmName);
    
    
    public List<Transactions> getFilteredReloads(Date fromDate, Date toDate);
    public List<Transactions> getFilteredReloadsbyAtm(Date fromDate, Date toDate,String atmName);

    public Transactions findtransactionbyid(int id);

    public void deletetransactionbyid(Transactions transaction);
    
    public CashOut findCashOutbyid(int id);

    public void deleteCashOutbyid(CashOut cashout);

    public List<Transactions> getTransactionbyReloadid(int id);
    
    public List<CashOut> getCashOutbyAtm(String atmname);
    

}
