package lk.dialoglab.ezcash.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class AtmDAOImpl extends GenericDAOImpl<Atm, Integer> implements AtmDAO {

    public List<Atm> getAtmDropDownList() {
        String hql = "select distinct a.atmName from Atm a order by a.atmName asc";
        // String hql =
        // "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
        Query query = HibernateUtil.getSession().createQuery(hql);

        List<Atm> atmlist = findMany(query);
        // System.out.println("ATM DAO"+atmlist.get(0).getAtmName());
        return atmlist;
    }

    public List<Atm> getAtmDetails(String atmname) {
        System.out.println("Atm Name DAO " + atmname);
        String hql = "from Atm a where a.atmName = :d1";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", atmname);

        List<Atm> atmlist = findMany(query);

        return atmlist;
    }

    @Override
    public int getAtmLocationId(String Atmlocation) {

        String hql = "select distinct l.locationId from AtmLocation l where l.locationName = :d1";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", Atmlocation);

        System.out.println(" Query TransactionDAOImpl " + query);

        return (int) query.uniqueResult();
    }

}
