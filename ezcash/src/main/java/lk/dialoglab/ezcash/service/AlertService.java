package lk.dialoglab.ezcash.service;

import java.util.List;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.AtmReload;

public interface AlertService {

    public List<Alerts> getAlerts();
    public Alerts findalertbyid(int id);
    public void deletealertbyid(Alerts alert);
}
