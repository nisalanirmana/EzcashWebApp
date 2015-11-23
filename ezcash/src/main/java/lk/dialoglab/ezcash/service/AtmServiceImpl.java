package lk.dialoglab.ezcash.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lk.dialoglab.ezcash.dao.AssignedAtmDAO;
import lk.dialoglab.ezcash.dao.AtmDAO;
import lk.dialoglab.ezcash.dao.AtmLocationDAO;
import lk.dialoglab.ezcash.dao.ReloadDAO;
import lk.dialoglab.ezcash.domain.AssignedAtm;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmLocation;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.dto.AssignedAtmDto;
import lk.dialoglab.ezcash.dto.AtmDto;
import lk.dialoglab.ezcash.dto.AtmLocationDto;
import lk.dialoglab.ezcash.dto.ReloadDto;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtmServiceImpl implements AtmService {

    @Autowired
    AtmDAO atmDao;

    @Override
    public List<Atm> getAtmList() {
        List<Atm> atm = null;
        try {
            HibernateUtil.beginTransaction();
            atm = atmDao.findAll(Atm.class);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return atm;

    }

    @Autowired
    AssignedAtmDAO assignedatmDao;

    @Override
    public List<AssignedAtm> getAtmAssignedOperatorList() {
        List<AssignedAtm> assignedAtm = null;
        try {
            HibernateUtil.beginTransaction();
            assignedAtm = assignedatmDao.findAll(AssignedAtm.class);
            System.out.println("Assigned Atm get 0 " + assignedAtm.get(0).getAtm().getAtmName());
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return assignedAtm;

    }

    @Override
    public AssignedAtm findassignedatmoperatorbyid(int id) {
        AssignedAtm assignedAtmfind = null;
        try {
            HibernateUtil.beginTransaction();
            System.out.println("found" + id);
            assignedAtmfind = assignedatmDao.findByID(AssignedAtm.class, id);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        System.out.println("return" + id);
        return assignedAtmfind;
    }

    @Override
    public void deleteassignedatmoperatorbyid(AssignedAtm assignedatm) {
        try {
            HibernateUtil.beginTransaction();
            assignedatmDao.delete(assignedatm);
            System.out.println("Deleted");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    @Autowired
    ReloadDAO reloadDao;

    @Override
    public void addAssignedAtmOperator(AssignedAtmDto assignedAtmDto) {

        try {
            HibernateUtil.beginTransaction();
            AssignedAtm assignedAtm = new AssignedAtm();
            // atmlocation.setLocationId(atmlocationdto.getLocationId());

            // Atm

            Atm atmobject = new Atm();
            String str1Id = assignedAtmDto.getAtmId();
            System.out.println("Atm Name " + str1Id);
            int str5Id = reloadDao.getAtmID(str1Id);
            System.out.println("Atm Id " + str5Id);
            atmobject.setAtmId(reloadDao.getAtmID(str1Id));;
            assignedAtm.setAtm(atmobject);

            // Operator
            Operator operatorobject = new Operator();
            String str1Id2 = assignedAtmDto.getOperatorId();
            operatorobject.setOperatorId(reloadDao.getOperatorID(str1Id2));;
            assignedAtm.setOperator(operatorobject);

            assignedatmDao.save(assignedAtm);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }
    }

    @Override
    public List<Atm> getAtmDetails(String atmname) {
        List<Atm> atm = null;
        try {
            HibernateUtil.beginTransaction();
            atm = atmDao.getAtmDetails(atmname);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return atm;

    }

    @Override
    public Atm findatmbyid(int id) {
        Atm atmfind = null;
        try {
            HibernateUtil.beginTransaction();
            System.out.println("found" + id);
            atmfind = atmDao.findByID(Atm.class, id);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        System.out.println("return" + id);
        return atmfind;
    }

    @Override
    public void deleteatmbyid(Atm atm) {
        try {
            HibernateUtil.beginTransaction();
            atmDao.delete(atm);
            System.out.println("Deleted");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    @Override
    public void addAtm(AtmDto atmdto) {

        try {
            HibernateUtil.beginTransaction();
            Atm atm = new Atm();
            // atm.setAtmId(atmdto.getAtmId());

            // Atm Name
            atm.setAtmName(atmdto.getAtmName());

            // Atm Location
            AtmLocation atmlocationObject = new AtmLocation();

            String atmname = atmdto.getAtmLocation();
            // Integer atmId = Integer.parseInt(atmid);
            atmlocationObject.setLocationId(atmDao.getAtmLocationId(atmname));
            atm.setAtmLocation(atmlocationObject);

            // Serial No//
            atm.setSerialNo(atmdto.getSerialNo());
            // Tray 1
            atm.setTray1(atmdto.getTray1());
            // Tray 2
            atm.setTray2(atmdto.getTray2());
            // atmcode
            atm.setAtmCode(atmdto.getAtmcode());
            // Tray1 Note
            atm.setTray1NoteValue(atmdto.getTray1NoteValue());
            // Tray2 Note
            atm.setTray2NoteValue(atmdto.getTray2NoteValue());

            // Operator//
            // Operator operatorObject = new Operator();// create a new ATM object
            // String str1Id2 = atmdto.getOperator(); // we receive id as a string
            // Integer atmId = Integer.parseInt(str1Id); // need to convert string to Integer
            // System.out.println("Operator name1 "+str1Id2);
            // atmObject.setAtmName(str1Id);
            // System.out.println("atm Id " + reloadDao.getAtmID(str1Id));
            // operatorObject.setOperatorId(reloadDao.getOperatorID(str1Id2));// set this to newly created ATM object
            // Integer atmId = Integer.parseInt(str1Id2);
            // operatorObject.setOperatorId(atmId);
            // System.out.println("Atm name2 "+atmObject.getAtmName());
            // atm.set(operatorObject); // set this to reload
            // System.out.println("Atm name3 "+reload.getAtm().getAtmName());

            // DateCreated//
            DateFormat formatter2 = new SimpleDateFormat("dd-MM-yy hh:mm");
            Date date2 = new Date();
            Date datenow = formatter2.parse(formatter2.format(date2));
            atm.setInstalledDate(datenow);

            // status
            atm.setStatus("0");

            // LivePkt Time
            atm.setLivePktTime(datenow);

            // reject1
            atm.setReject1(0);
            // reject2
            atm.setReject2(0);

            // bat level
            atm.setbatteryLevel(0);

            atmDao.save(atm);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

    }

    @Override
    public void updateatmbyid(AtmDto atmdto) {
        try {
            HibernateUtil.beginTransaction();
            Atm atm = new Atm();

            /*
             * System.out.println("atmlocation"+atmlocationdto.getLocationId());
             * System.out.println("atmlocation"+atmlocationdto.getLocationName());
             * System.out.println("atmlocation"+atmlocationdto.getLocationX());
             * System.out.println("atmlocation"+atmlocationdto.getLocationY());
             */
            atm.setAtmId(atmdto.getAtmId());
            atm.setAtmName(atmdto.getAtmName());

            // Atm Location
            AtmLocation atmlocationObject = new AtmLocation();
            String atmname = atmdto.getAtmLocation();
            // Integer atmId = Integer.parseInt(atmid);
            atmlocationObject.setLocationId(atmDao.getAtmLocationId(atmname));
            atm.setAtmLocation(atmlocationObject);
            atm.setSerialNo(atmdto.getSerialNo());
            atm.setTray1(atmdto.getTray1());
            atm.setTray2(atmdto.getTray1());
            atm.setAtmCode(atmdto.getAtmcode());
            atm.setTray1NoteValue(atmdto.getTray1NoteValue());
            atm.setTray2NoteValue(atmdto.getTray2NoteValue());

            // DateCreated//
            DateFormat formatter2 = new SimpleDateFormat("dd-MM-yy hh:mm");
            Date date2 = new Date();
            Date datenow = formatter2.parse(formatter2.format(date2));

            atm.setInstalledDate(atmdto.getInstalledDate());

            // status
            atm.setStatus(atmdto.getStatus());

            // LivePkt Time
            atm.setLivePktTime(atmdto.getLivePktTime());

            // reject1
            atm.setReject1(atmdto.getReject1());
            // reject2
            atm.setReject2(atmdto.getReject2());

            // bat level
            atm.setbatteryLevel(atmdto.getBatLevel());

            atmDao.update(atm);
            System.out.println("Updated");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    @Autowired
    private AtmLocationDAO atmLocationDao;

    public List<AtmLocation> getAtmLocationDropDownList() {
        List<AtmLocation> atmlocation = null;
        try {
            HibernateUtil.beginTransaction();
            atmlocation = atmLocationDao.getAtmLocationDropDownList();

            // System.out.println("Cashout date"+atm.get(1).getAtmName());

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        return atmlocation;
    }

    @Override
    public void addAtmLocation(AtmLocationDto atmlocationdto) {

        try {
            HibernateUtil.beginTransaction();
            AtmLocation atmlocation = new AtmLocation();
            // atmlocation.setLocationId(atmlocationdto.getLocationId());
            // Location Name
            atmlocation.setLocationName(atmlocationdto.getLocationName());

            atmlocation.setLocationX(atmlocationdto.getLocationX());

            atmlocation.setLocationY(atmlocationdto.getLocationY());
            atmLocationDao.save(atmlocation);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

    }

    public List<AtmLocation> getAtmLocationList() {
        List<AtmLocation> atmlocation = null;
        try {
            HibernateUtil.beginTransaction();
            atmlocation = atmLocationDao.findAll(AtmLocation.class);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return atmlocation;

    }

    @Override
    public AtmLocation findatmLocationbyid(int id) {
        AtmLocation atmlocationfind = null;
        try {
            HibernateUtil.beginTransaction();
            System.out.println("found" + id);
            atmlocationfind = atmLocationDao.findByID(AtmLocation.class, id);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        System.out.println("return" + id);
        return atmlocationfind;
    }

    @Override
    public void deleteatmLocationbyid(AtmLocation atmlocation) {
        try {
            HibernateUtil.beginTransaction();
            atmLocationDao.delete(atmlocation);
            System.out.println("Deleted");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    @Override
    public void updateatmLocationbyid(AtmLocationDto atmlocationdto) {
        try {
            HibernateUtil.beginTransaction();
            AtmLocation atmlocation = new AtmLocation();

            System.out.println("atmlocation" + atmlocationdto.getLocationId());
            System.out.println("atmlocation" + atmlocationdto.getLocationName());
            System.out.println("atmlocation" + atmlocationdto.getLocationX());
            System.out.println("atmlocation" + atmlocationdto.getLocationY());

            atmlocation.setLocationId(atmlocationdto.getLocationId());
            atmlocation.setLocationName(atmlocationdto.getLocationName());
            atmlocation.setLocationX(atmlocationdto.getLocationX());
            atmlocation.setLocationY(atmlocationdto.getLocationY());
            atmLocationDao.update(atmlocation);
            System.out.println("Updated");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    @Override
    public void setAtmStatus(String id) {
        try {
            HibernateUtil.beginTransaction();
            System.out.println("Updated Test");
            atmDao.setAtmStatus(id);;
            System.out.println("Updated");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }
}
