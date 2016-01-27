package lk.dialoglab.ezcash.dao;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.CashOut;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

@Component
public class AlertDAOImpl extends GenericDAOImpl<Alerts, Integer> implements AlertDAO {
    public List<Alerts> getAlerts() {
        String hql = "from Alerts a order by a.triggeredTime desc";
        Query query = HibernateUtil.getSession().createQuery(hql);

        List<Alerts> alerts = findMany(query);

        return alerts;

    }
    
    public List<Alerts> getFilteredAlerts(Date fromDate, Date toDate) {
        String hql = "from Alerts t where t.triggeredTime>:d1 and t.triggeredTime<:d2 order by t.triggeredTime desc";
        // String hql =
        // "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", fromDate)
                .setParameter("d2", toDate);

        List<Alerts> alerts = findMany(query);

        return alerts ;

    }
    
    public List<Alerts> getFilteredAlertsbyAtm(Date fromDate, Date toDate,String atmName) {
        String hql = "from Alerts t where t.triggeredTime>:d1 and t.triggeredTime<:d2 and t.atm.atmName=:d3 order by t.triggeredTime desc";
        // String hql =
        // "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", fromDate).setParameter("d2", toDate).setParameter("d3", atmName);

        List<Alerts> alerts = findMany(query);

        return alerts ;

    }
    
    public List<Alerts> getAlertsbyAtm(String atmname){
        System.out.println(" getCashOutsbyATM()Start ");
        
        String hql = "from Alerts a where a.atm.atmName = :d1 order by a.alertId desc";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", atmname);
        System.out.println(" getTransactionbyReloadid() Start ");
        List<Alerts> alerts = findMany(query);
        
        System.out.println(" getCashOutsbyATM() END ");
        return alerts;
        
    }

}
