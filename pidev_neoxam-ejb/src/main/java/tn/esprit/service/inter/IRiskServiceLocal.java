package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;

@Local
public interface IRiskServiceLocal {
	public String addRisk(Risk risks);
	public void updateRisks(Risk riskNewValue);
	public void deleteRisks(String ref);
	public List<Risk> getAllRisks() ;
	public List<Risk> getRiskByRef(String ref);
	public void sendWeeklyReport(Employee employee);
}
