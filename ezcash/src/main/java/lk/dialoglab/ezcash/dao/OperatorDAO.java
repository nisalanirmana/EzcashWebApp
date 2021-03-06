package lk.dialoglab.ezcash.dao;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.Operator;

/**
 * Define methods to connect with Event Class and handle database operations.
 * database:imoni, table:event
 * 
 * @author Dewmini Premaratna
 * @since April 10, 2014
 * @version 1.0
 */
public interface OperatorDAO extends GenericDAO<Operator, Integer> {

    public List<Operator> getOperatorDropDownList();

}
