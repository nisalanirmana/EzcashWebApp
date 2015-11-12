package lk.dialoglab.ezcash.service;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Transactions;

public interface TransactionService {

	public List<Transactions> getTransactions();
	
	public List<Transactions> getReloads();
	
	public List<Transactions> getFilteredTrans(Date fromDate,Date toDate);
	
	public Transactions findtransactionbyid(int id);
	
	public void deletetransactionbyid(Transactions transaction);
	
	public List<Transactions> getTransactionbyReloadid(int id);
	
	
	
}
