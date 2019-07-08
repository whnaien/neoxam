
package tn.esprit.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.impl.RiskCrud;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;
import tn.esprit.service.inter.IRiskServiceLocal;
import tn.esprit.service.inter.IRiskServiceRemote;

@Stateless
@LocalBean
public class RiskService implements IRiskServiceLocal, IRiskServiceRemote  {

	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	@EJB
	
	RiskCrud riskCrud;
	@Override																															
	public String addRisk(Risk risks) {
		return riskCrud.addRisk(risks);	
	}

	@Override
	public void updateRisks(Risk riskNewValue) {
		riskCrud.updateRisks(riskNewValue);	
	}
	
	@Override
	public void deleteRisks(String ref) {
		riskCrud.deleteRisks(ref);	
	}

	@Override
	public List<Risk> getAllRisks() {
		return riskCrud.getAllRisks();
		
	}

	@Override
	public List<Risk>getRiskByRef(String ref) {
		TypedQuery<Risk> query = 
				em.createQuery("SELECT c FROM Risk c WHERE c.ref=:ref", Risk.class); 
				query.setParameter("ref",ref); 
		return query.getResultList();
	}

	@Override
	public void sendWeeklyReport(Employee employee) {
		// TODO Auto-generated method stub
		
	}
}
