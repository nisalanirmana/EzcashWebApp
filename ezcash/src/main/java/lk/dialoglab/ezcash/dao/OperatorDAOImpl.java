package lk.dialoglab.ezcash.dao;




import java.util.List;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

@Component
public class OperatorDAOImpl extends GenericDAOImpl<Operator, Integer> implements
		OperatorDAO {
	
	public List<Operator> getOperatorDropDownList()
	{
		String hql = "select distinct o.operatorName from Operator o order by o.operatorName asc";
		// String hql =
		// "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
		Query query = HibernateUtil.getSession().createQuery(hql);
		

		List<Operator> operatorlist = findMany(query);
		
		return operatorlist;
	}
	
}
