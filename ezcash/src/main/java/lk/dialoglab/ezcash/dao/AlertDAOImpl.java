package lk.dialoglab.ezcash.dao;

import java.util.List;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.Atm;
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

}
