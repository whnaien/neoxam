package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		em.flush();
		return risks.getRef();
		
		
	}

	@Override
	public void updateRisks(Risk riskNewValue, String id) {
		
		Risk k = em.find(Risk.class, id);
		k.setDate(riskNewValue.getDate());
		k.setIndicators(riskNewValue.getIndicators());
		k.setTotalScore(riskNewValue.getTotalScore());
		k.setValueScore(riskNewValue.getValueScore());
		em.persist(k);
		
	}

	@Override
	public void deleteRisks(String ref) {
		TypedQuery<Risk> query = 
				em.createQuery("SELECT c FROM Risk c WHERE ref=:value", Risk.class); 
				query.setParameter("value", ref); 
				Risk risk=  query.getSingleResult();
		em.remove(risk);
		
	}
	

	@Override
	public List<Risk> getAllRisks() {
				
		return em.createQuery("SELECT s FROM Risk s").getResultList();
	       
		
	}

	@Override
	public Risk getRiskByRef(String ref) {
		return em.find(Risk.class, ref);
		
	}

	@Override
	public void sendWeeklyReport(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
