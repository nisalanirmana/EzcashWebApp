package lk.dialoglab.ezcash.dao;

import java.util.List;

import lk.dialoglab.ezcash.domain.AtmLocation;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

@Component
public class AtmLocationDAOImpl extends GenericDAOImpl<AtmLocation, Integer> implements
		AtmLocationDAO {
	
	public List<AtmLocation> getAtmLocationDropDownList()
	{
		String hql = "select distinct a.locationName from AtmLocation a order by a.locationName asc";
		// String hql =
		// "from Event e where e.eventtime between d1 and d2+1 order by e.eventtime desc";
		Query query = HibernateUtil.getSession().createQuery(hql);

		List<AtmLocation> atmlocationlist = findMany(query);
		//System.out.println("atmlocation dao"+atmlocationlist.get(0));
		return atmlocationlist;
	}
}
