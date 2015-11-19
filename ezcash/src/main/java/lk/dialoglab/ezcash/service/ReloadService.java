package lk.dialoglab.ezcash.service;

import java.util.List;

import lk.dialoglab.ezcash.dao.AtmDAO;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.dto.ReloadDto;

public interface ReloadService {
    public void addReload(ReloadDto reloaddto);

    public List<AtmReload> getReload();

    public AtmReload findreloadbyid(int id);

    public void deletereloadbyid(AtmReload atmreload);

    public List<Atm> getAtmDropDownList();

    public List<Operator> getOperatorDropDownList();
}
