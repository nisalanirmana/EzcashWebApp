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
public class TransactionDAOImpl extends GenericDAOImpl<Transactions, Integer> implements TransactionDAO {

    public List<Transactions> getFilteredTrans(Date fromDate, Date toDate) {
        String hql = "from Transactions t where t.cashOut.cashOutDate>:d1 and t.cashOut.cashOutDate<:d2 order by t.cashOut.cashOutDate desc";
        // String hql =
        // "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", fromDate)
                .setParameter("d2", toDate);
        System.out.println(" getFilteredTrans() Start ");
        List<Transactions> transactions = findMany(query);
        System.out.println(" getFilteredTrans() END ");
        return transactions;

    }
    
    public List<Transactions> getFilteredReloads(Date fromDate, Date toDate) {
        String hql = "from Transactions t where t.atmReload.reloadEndTime>:d1 and t.atmReload.reloadEndTime<:d2 order by t.atmReload.reloadEndTime desc";
        // String hql =
        // "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", fromDate)
                .setParameter("d2", toDate);
        System.out.println(" getFilteredReloads() Start ");
        List<Transactions> reloads = findMany(query);
        System.out.println(" getFilteredReloads() END ");
        return reloads;

    }

    /*
     * public int getAtmID(String AtmName){
     * 
     * String hql =
     * "from Transactions t where t.cashOut.cashOutDate>:d1 and t.cashOut.cashOutDate<:d2 order by t.cashOut.cashOutDate desc"
     * ;
     * 
     * return atmid
     * }
     */

    public List<Transactions> getTransactions() {
        String hql = "from Transactions t order by t.cashOut.cashOutDate desc";
        Query query = HibernateUtil.getSession().createQuery(hql);

        System.out.println(" getTransactions() Start ");
        List<Transactions> transactions = findMany(query);
        System.out.println(" getTransactions() END ");
        return transactions;

    }

    // reload

    public List<Transactions> getReloads() {
        // String hql = "from Transactions t order by t.cashOut.cashOutDate desc";
        String hql = "from Transactions t order by t.atmReload.taskCreatedTime desc";
        Query query = HibernateUtil.getSession().createQuery(hql);

        System.out.println(" getReloads() Start ");
        List<Transactions> reloads = findMany(query);
        System.out.println(" getReloads() END ");
        return reloads;

    }

    public List<Transactions> getTransactionbyReloadid(int id) {

        System.out.println("Atm Name DAO " + id);
        String hql = "from Transactions a where a.atmReload.reloadId = :d1";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", id);
        System.out.println(" getTransactionbyReloadid() Start ");
        List<Transactions> transactions = findMany(query);
        System.out.println(" getTransactionbyReloadid() END ");
        return transactions;
    }

}
