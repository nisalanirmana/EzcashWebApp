package lk.dialoglab.ezcash.dao;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.CashOut;
import lk.dialoglab.ezcash.domain.Transactions;

public interface ReloadDAO extends GenericDAO<AtmReload, Integer> {

    public int getAtmID(String AtmName);

    public int getOperatorID(String OperatorName);
    
    public List<AtmReload> getFilteredReloads(Date fromDate, Date toDate);
    
    public List<AtmReload> getReloadsbyAtm(String atmname);


}
