package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;

@Remote
public interface IRiskServiceRemote {
	public String addRisk(Risk risks);
	public void updateRisks(Risk riskNewValue);
	public void deleteRisks(String ref);
	public List<Risk> getAllRisks() ;
	public List<Risk> getRiskByRef(String ref);
	public void sendWeeklyReport(Employee employee);
}
