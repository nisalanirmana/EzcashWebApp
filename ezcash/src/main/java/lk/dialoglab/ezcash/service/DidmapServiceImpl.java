package lk.dialoglab.ezcash.service;

import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.dao.DidmapDAO;
import lk.dialoglab.ezcash.domain.Didmap;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.dto.DidmapDto;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DidmapServiceImpl implements DidmapService {

    @Autowired
    DidmapDAO didmapDao;

    @Override
    public List<Didmap> getDidmap() {
        List<Didmap> didmap = null;
        try {
            HibernateUtil.beginTransaction();
            didmap = didmapDao.findAll(Didmap.class);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return didmap;

    }

    @Override
    public void addDidmap(DidmapDto didmapdto) {

        try {
            HibernateUtil.beginTransaction();
            Didmap didmap = new Didmap();
            Date date = new Date();
            didmap.setMapno(didmapdto.getMapId());
            didmap.setDid(didmapdto.getDid());
            didmap.setPhone(didmapdto.getPhone());
            didmap.setName(didmapdto.getName());

            didmapDao.save(didmap);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

    }

}
