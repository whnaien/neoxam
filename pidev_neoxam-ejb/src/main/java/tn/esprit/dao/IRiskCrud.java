package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;


public interface IRiskCrud {
	public String addRisk(Risk risks);

	public void updateRisks(Risk riskNewValue, String id);

	public void deleteRisks(String ref);

	public List<Risk> getAllRisks();

	public Risk getRiskByRef(String ref);

	public void sendWeeklyReport(Employee employee);

	
	
}

