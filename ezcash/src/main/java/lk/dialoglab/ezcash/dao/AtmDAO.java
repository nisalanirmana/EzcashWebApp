package lk.dialoglab.ezcash.dao;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.Transactions;

/**
 * Define methods to connect with Event Class and handle database operations.
 * database:imoni, table:event
 * 
 * @author Dewmini Premaratna
 * @since April 10, 2014
 * @version 1.0
 */
public interface AtmDAO extends GenericDAO<Atm, Integer> {

    public List<Atm> getAtmDropDownList();

    public List<Atm> getAtmDetails(String Atmname);

    public int getAtmLocationId(String Atmlocation);
    
    public void setAtmStatus(String id);

}
