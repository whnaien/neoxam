package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.IRiskCrud;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;

@Stateless
@LocalBean
	
public class RiskCrud implements IRiskCrud {
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
	@Override
	public String addRisk(Risk risks) {
		em.persist(risks);
		return risks.getRef();
	}

	@Override
	public void updateRisks(Risk riskNewValue) {
		em.merge(riskNewValue);
		em.flush();
		
	}

	@Override
	public void deleteRisks(String ref) {
		em.remove(em.find(Risk.class, ref));
		
	}

	@Override
	public List<Risk> getAllRisks() {
		List<Risk> candidates = em.createQuery("from Risk", Risk.class).getResultList();
		return candidates;
	}

	@Override
	public Risk getRiskByRef(String ref) {
		Risk risk = em.find(Risk.class, ref);
		return risk;
	}

	@Override
	public void sendWeeklyReport(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
