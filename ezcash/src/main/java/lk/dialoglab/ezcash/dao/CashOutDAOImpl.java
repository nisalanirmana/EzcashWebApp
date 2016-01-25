package lk.dialoglab.ezcash.dao;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.CashOut;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory;
import org.hibernate.hql.spi.QueryTranslator;
import org.springframework.stereotype.Component;

@Component
public class CashOutDAOImpl extends GenericDAOImpl<CashOut, Integer> implements CashOutDAO {

    public List<CashOut> getFilteredCashOuts(Date fromDate, Date toDate) {
        String hql = "from CashOut t where t.cashOutDate>:d1 and t.cashOutDate<:d2 order by t.cashOutDate desc";
        // String hql =
        // "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", fromDate)
                .setParameter("d2", toDate);
        System.out.println(" getFilteredCashOuts() Start ");
        List<CashOut> cashout = findMany(query);
        System.out.println(" getFilteredCashOuts() END ");
        return cashout;

    }
    
    
    public List<CashOut> getCashOuts(){
        String hql = "from CashOut t order by t.cashOutDate desc";
        Query query = HibernateUtil.getSession().createQuery(hql);
        System.out.println(" getCashOuts() Start ");
        List<CashOut> cashout = findMany(query);
        System.out.println(" getCashOuts() END ");
        return cashout;

    }
    
    public List<CashOut> getCashOutbyAtm(String atmname){
        System.out.println(" getCashOutsbyATM()Start ");
        
        String hql = "from CashOut a where a.atm.atmName = :d1 order by a.cashOutId desc";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", atmname);
        System.out.println(" getTransactionbyReloadid() Start ");
        List<CashOut> transactions = findMany(query);
        
        System.out.println(" getCashOutsbyATM() END ");
        return transactions;
        
    }

   
}
