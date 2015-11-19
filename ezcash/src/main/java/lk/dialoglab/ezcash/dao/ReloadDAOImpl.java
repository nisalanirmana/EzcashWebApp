package lk.dialoglab.ezcash.dao;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory;
import org.hibernate.hql.spi.QueryTranslator;
import org.springframework.stereotype.Component;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmReload;
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

}
