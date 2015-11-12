package lk.dialoglab.ezcash.dao;







import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory;
import org.hibernate.hql.spi.QueryTranslator;
import org.springframework.stereotype.Component;

@Component
public class TransactionDAOImpl extends GenericDAOImpl<Transactions, Integer> implements
		TransactionDAO {
	
	public List<Transactions> getFilteredTrans(Date fromDate,Date toDate)
	{
		String hql = "from Transactions t where t.cashOut.cashOutDate>:d1 and t.cashOut.cashOutDate<:d2 order by t.cashOut.cashOutDate desc";
		// String hql =
		// "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
		Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", fromDate).setParameter("d2", toDate);

		

		List<Transactions> transactions = findMany(query);

		return transactions;

		
		
	}
	/*
public int getAtmID(String AtmName){
	
	String hql = "from Transactions t where t.cashOut.cashOutDate>:d1 and t.cashOut.cashOutDate<:d2 order by t.cashOut.cashOutDate desc";
		
		return atmid
	}
	*/
	
	public List<Transactions> getTransactions()
	{
		String hql = "from Transactions t order by t.cashOut.cashOutDate desc";
		Query query = HibernateUtil.getSession().createQuery(hql);
		
		System.out.println(" Query TransactionDAOImpl "+query);

		List<Transactions> transactions = findMany(query);

		return transactions;

		
		
	}
	//reload
	
	public List<Transactions> getReloads()
	{
		//String hql = "from Transactions t order by t.cashOut.cashOutDate desc";
		String hql = "from Transactions t order by t.atmReload.taskCreatedTime desc";
		Query query = HibernateUtil.getSession().createQuery(hql);
		
		System.out.println(" Query TransactionDAOImpl "+query);
		System.out.println("test1");
		List<Transactions> reloads = findMany(query);
		System.out.println("test2");
		return reloads;

		
		
	}
	
	
	

	
}
