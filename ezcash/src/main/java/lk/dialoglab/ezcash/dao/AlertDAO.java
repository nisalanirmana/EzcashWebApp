package lk.dialoglab.ezcash.dao;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.Atm;
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
public interface AlertDAO extends GenericDAO<Alerts, Integer> {

    public List<Alerts> getAlerts();
    public List<Alerts> getFilteredAlerts(Date fromDate, Date toDate);
    public List<Alerts> getAlertsbyAtm(String atmname);

}
