package lk.dialoglab.ezcash.service;

import java.util.List;

import lk.dialoglab.ezcash.domain.AssignedAtm;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmLocation;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.dto.AssignedAtmDto;
import lk.dialoglab.ezcash.dto.AtmDto;
import lk.dialoglab.ezcash.dto.AtmLocationDto;
import lk.dialoglab.ezcash.dto.ReloadDto;

public interface AtmService {
	public List<Atm> getAtmList();
	public List<AtmLocation> getAtmLocationList();
	public List<Atm> getAtmDetails(String atmname);
	public void updateatmbyid(AtmDto atmdto);
	
	public Atm findatmbyid(int id);
	public void deleteatmbyid(Atm atm);
	public void updateatmLocationbyid(AtmLocationDto atmlocationdto);
	
	public AtmLocation findatmLocationbyid(int id);
	public void deleteatmLocationbyid(AtmLocation atmlocation);
	
	public void addAtm(AtmDto atmdto);
	public List<AtmLocation> getAtmLocationDropDownList();
	public void addAtmLocation(AtmLocationDto atmlocationdto);
	
	//Assign Operators
	public List<AssignedAtm> getAtmAssignedOperatorList();
	public void addAssignedAtmOperator(AssignedAtmDto assignedAtmDto);
	public AssignedAtm findassignedatmoperatorbyid(int id);
	public void deleteassignedatmoperatorbyid(AssignedAtm assignedatm);
	
}
