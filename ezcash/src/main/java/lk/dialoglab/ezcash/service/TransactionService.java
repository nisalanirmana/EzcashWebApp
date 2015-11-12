package lk.dialoglab.ezcash.service;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Transactions;

public interface TransactionService {

	public List<Transactions> getTransactions();
	
	public List<Transactions> getReloads();
	
	public List<Transactions> getFilteredTrans(Date fromDate,Date toDate);
}
