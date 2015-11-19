package lk.dialoglab.ezcash.dao;

import java.util.List;

import lk.dialoglab.ezcash.domain.WebUser;

import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

@Component
public class WebUserDAOImpl extends GenericDAOImpl<WebUser, Integer> implements WebUserDAO {

    @Override
    public String getWebUserPassword(String username) {

        String hql = "select distinct w.password from WebUser w where w.userName = :d1";
        Query query = HibernateUtil.getSession().createQuery(hql).setParameter("d1", username);

        System.out.println(" Query TransactionDAOImpl " + query);

        return (String) query.uniqueResult();

    }

}
