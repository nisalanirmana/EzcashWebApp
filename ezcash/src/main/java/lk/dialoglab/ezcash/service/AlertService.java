package lk.dialoglab.ezcash.service;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Transactions;

public interface AlertService {

    public List<Alerts> getAlerts();
    public Alerts findalertbyid(int id);
    public void deletealertbyid(Alerts alert);
    public List<Alerts> getFilteredAlerts(Date fromDate, Date toDate);
    public List<Alerts> getFilteredAlertsbyAtm(Date fromDate, Date toDate,String atmName);
    public List<Alerts> getAlertsbyAtm(String atmname);
    
}
