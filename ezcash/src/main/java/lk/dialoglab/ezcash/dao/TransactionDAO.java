package lk.dialoglab.ezcash.dao;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.CashOut;
import lk.dialoglab.ezcash.domain.Transactions;

/**
 * Define methods to connect with Event Class and handle database operations.
 * database:imoni, table:event
 * 
 * @author Dewmini Premaratna
 * @since April 10, 2014
 * @version 1.0
 */
public interface TransactionDAO extends GenericDAO<Transactions, Integer> {

    public List<Transactions> getFilteredTrans(Date fromDate, Date toDate);
    
    public List<Transactions> getFilteredReloads(Date fromDate, Date toDate);

    public List<Transactions> getTransactions();

    public List<Transactions> getReloads();

    public List<Transactions> getTransactionbyReloadid(int id);
    
    

}
