package tn.esprit.dao;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;

@Local
public interface RisksDao {
	public int addRisk(Risk risks);
	public int updateRisks(Risk risks);
	public void deleteRisks(int ref);
	public List<Risk> getAllRisks();
	public Risk getRiskByRef(int ref);
	public void sendWeeklyReport(Employee employee);
}
