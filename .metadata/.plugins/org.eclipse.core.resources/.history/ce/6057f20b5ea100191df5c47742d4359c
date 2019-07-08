package tn.esprit.dao;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;

@Local
public interface IRiskCrud {
	public String addRisk(Risk risks);

	public void updateRisks(Risk riskNewValue);

	public void deleteRisks(String ref);

	public List<Risk> getAllRisks();

	public Risk getRiskByRef(String ref);

	public void sendWeeklyReport(Employee employee);

}

