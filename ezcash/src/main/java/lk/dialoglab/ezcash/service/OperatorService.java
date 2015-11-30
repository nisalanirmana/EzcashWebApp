package lk.dialoglab.ezcash.service;

import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.domain.WebUser;
import lk.dialoglab.ezcash.dto.OperatorDto;
import lk.dialoglab.ezcash.dto.WebUserDto;

import java.util.List;

public interface OperatorService {

    public List<Operator> getOperators();

    public List<WebUser> getWebUsers();

    public String getWebUserPassword(String password);

    public void addOperator(OperatorDto operator);

    public Operator findoperatorbyid(int id);

    public void deleteoperatorbyid(Operator operator);

    public void updateOperatorbyid(OperatorDto operatordto);

    // web user
    public void addWebUser(WebUserDto webuserdto);

}
