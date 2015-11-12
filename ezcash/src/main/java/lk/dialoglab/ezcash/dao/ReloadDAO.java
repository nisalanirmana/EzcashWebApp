package lk.dialoglab.ezcash.dao;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmReload;



public interface ReloadDAO extends GenericDAO<AtmReload, Integer> {
	
	public int getAtmID(String AtmName);
	public int getOperatorID(String OperatorName);

}

