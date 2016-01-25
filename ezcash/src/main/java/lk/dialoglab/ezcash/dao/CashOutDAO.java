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
public interface CashOutDAO extends GenericDAO<CashOut, Integer> {

    public List<CashOut> getFilteredCashOuts(Date fromDate, Date toDate);
    
    public List<CashOut> getCashOuts();
    
    public List<CashOut> getCashOutbyAtm(String atmname);


}
