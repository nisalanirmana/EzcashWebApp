package lk.dialoglab.ezcash.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory;
import org.hibernate.hql.spi.QueryTranslator;
import org.springframework.stereotype.Component;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.CashOut;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.util.HibernateUtil;

@Component
public class ReloadDAOImpl extends GenericDAOImpl<AtmReload, Integer> implements ReloadDAO {

    @Override
    public int getAtmID(String atmName) {

        String hql = "select distinct a.atmId from Atm a where a.atmName = :d1";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", atmName);

        System.out.println(" Query TransactionDAOImpl " + query);

        return (int) query.uniqueResult();

    }

    @Override
    public int getOperatorID(String operatorName) {

        String hql = "select distinct a.operatorId from Operator a where a.operatorName = :d1";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", operatorName);

        System.out.println(" Query TransactionDAOImpl " + query);

        return (int) query.uniqueResult();

    }
    
    public List<AtmReload> getFilteredReloads(Date fromDate, Date toDate) {
        String hql = "from  AtmReload t where t.reloadEndTime>:d1 and t.reloadEndTime<:d2 order by t.reloadEndTime desc";
        // String hql =
        // "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", fromDate)
                .setParameter("d2", toDate);

        List<AtmReload> reloads = findMany(query);

        return reloads;

    }
    
    public List<AtmReload> getReloadsbyAtm(String atmname){
        System.out.println(" getCashOutsbyATM()Start ");
        
        String hql = "from AtmReload a where a.atm.atmName = :d1 order by a.reloadId desc";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", atmname);
        System.out.println(" getTransactionbyReloadid() Start ");
        List<AtmReload> atmreloads = findMany(query);
        
        System.out.println(" getCashOutsbyATM() END ");
        return atmreloads;
        
    }

}
