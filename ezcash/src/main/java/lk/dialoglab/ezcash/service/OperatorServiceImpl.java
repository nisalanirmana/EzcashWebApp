package lk.dialoglab.ezcash.service;


import java.util.List;
import lk.dialoglab.ezcash.dao.OperatorDAO;
import lk.dialoglab.ezcash.dao.WebUserDAO;
import lk.dialoglab.ezcash.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.domain.UserType;
import lk.dialoglab.ezcash.domain.WebUser;
import lk.dialoglab.ezcash.dto.OperatorDto;
import lk.dialoglab.ezcash.dto.WebUserDto;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    OperatorDAO operatorDao;

    @Autowired
    WebUserDAO webUserDao;

    @Override
    public List<Operator> getOperators() {
        List<Operator> operators = null;
        try {
            HibernateUtil.beginTransaction();
            operators = operatorDao.findAll(Operator.class);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return operators;

    }

    @Override
    public Operator findoperatorbyid(int id) {
        Operator operatorfind = null;
        try {
            HibernateUtil.beginTransaction();
            System.out.println("found" + id);
            operatorfind = operatorDao.findByID(Operator.class, id);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
        System.out.println("return" + id);
        return operatorfind;
    }

    @Override
    public void deleteoperatorbyid(Operator operator) {
        try {
            HibernateUtil.beginTransaction();
            operatorDao.delete(operator);
            System.out.println("Deleted");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    @Override
    public List<WebUser> getWebUsers() {
        List<WebUser> users = null;
        try {
            HibernateUtil.beginTransaction();
            users = webUserDao.findAll(WebUser.class);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return users;

    }

    @Override
    public String getWebUserPassword(String password) {

        String passwd = "";

        try {
            HibernateUtil.beginTransaction();

            passwd = webUserDao.getWebUserPassword(password);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

        return passwd;

    }

    @Override
    public void addOperator(OperatorDto operatordto) {

        try {
            HibernateUtil.beginTransaction();
            Operator operator = new Operator();
            // operator.setOperatorId(operatordto.getOperatorId());
            operator.setOperatorName(operatordto.getOperatorName());
            operator.setEmail(operatordto.getEmail());
            operator.setOperatorPin(operatordto.getOperatorPin());
            operator.setPhoneNumber(operatordto.getPhoneNumber());
            String operatorType = operatordto.getOperatorType();
            System.out.println("Operator Type " + operatorType);
            if (operatorType.equals("Finance Division")) {
                operator.setOperatorType(1);
            } else {
                operator.setOperatorType(0);
            }

            operatorDao.save(operator);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

    }

    @Override
    public void updateOperatorbyid(OperatorDto operatordto) {
        try {
            HibernateUtil.beginTransaction();
            Operator operator = new Operator();

            System.out.println("atmlocation" + operatordto.getOperatorName());
            System.out.println("atmlocation" + operatordto.getOperatorName());
            System.out.println("atmlocation" + operatordto.getOperatorPin());
            System.out.println("atmlocation" + operatordto.getOperatorType());

            operator.setOperatorId(operatordto.getOperatorId());
            operator.setOperatorName(operatordto.getOperatorName());
            operator.setOperatorPin(operatordto.getOperatorPin());
            operator.setEmail(operatordto.getEmail());
            operator.setPhoneNumber(operatordto.getPhoneNumber());
            String operatorType = operatordto.getOperatorType();
            System.out.println("Operator Type " + operatorType);
            if (operatorType.equals("Finance Division")) {
                operator.setOperatorType(1);
            } else {
                operator.setOperatorType(0);
            }
            operatorDao.update(operator);
            System.out.println("Updated");
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }

    @Override
    public void addWebUser(WebUserDto webuserdto) {

        try {
            HibernateUtil.beginTransaction();
            WebUser webuser = new WebUser();
            // operator.setOperatorId(operatordto.getOperatorId());
            webuser.setUserName(webuserdto.getUserName());
            webuser.setPassword(webuserdto.getPassword());
            webuser.setEmail(webuserdto.getEmail());
            webuser.setPhoneNumber(webuserdto.getPhoneNumber());
            UserType usertype = new UserType();
            String userType = webuserdto.getUserType();
            System.out.println("User Type " + userType);
            if (userType.equals("Admin")) {
                usertype.setTypeId(1);
            } else {
                usertype.setTypeId(0);
            }

            webuser.setUserType(usertype);
            webUserDao.save(webuser);

            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();

        }

    }
}
