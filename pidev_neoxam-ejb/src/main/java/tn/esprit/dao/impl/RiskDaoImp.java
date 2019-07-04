package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.RisksDao;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;

    @Stateless
public class RiskDaoImp implements RisksDao{

	@PersistenceContext(unitName = "pidev")
	EntityManager em;

	@Override
	public int addRisk(Risk risks) {
		em.persist(risks);
		return risks.getRef();
	}

	@Override
	public int updateRisks(Risk risks) {
		em.persist(risks);
		return risks.getRef();
		
	}

	@Override
	public void deleteRisks(int ref) {
		Risk risk = em.find(Risk.class, ref);
		em.remove(risk);
		
	}
	
	@Override
	public List<Risk> getAllRisks() {
		return (List<Risk>) em.createQuery(
	            "SELECT r FROM Risk r").getResultList();
	}

	@Override
	public Risk getRiskByRef(int ref) {
		
		return  em.find(Risk.class, ref);
	}

	@Override
	public void sendWeeklyReport(Employee employee) {
	String mailContent = "";
	
		/*for (Risk risk : employee.getRisks()) {
			mailContent+="Risk: "+risk.getTypeRisk()+" date "+risk.getDate().toLocaleString()+"<br>";
		}*/
		String to = employee.getEmail();
		//send with java library
	}

	
}
