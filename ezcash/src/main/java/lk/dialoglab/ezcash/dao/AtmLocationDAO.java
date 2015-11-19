package lk.dialoglab.ezcash.dao;

import java.util.List;

import lk.dialoglab.ezcash.domain.AtmLocation;

public interface AtmLocationDAO extends GenericDAO<AtmLocation, Integer> {
    public List<AtmLocation> getAtmLocationDropDownList();
}
