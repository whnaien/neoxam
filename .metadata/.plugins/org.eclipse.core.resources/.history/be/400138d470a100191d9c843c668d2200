package tn.esprit.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.impl.IndicatorCrud;
import tn.esprit.entities.Indicator;
import tn.esprit.entities.Risk;
import tn.esprit.service.inter.IIndicatorServiceLocal;
import tn.esprit.service.inter.IIndicatorServiceRemote;

@Stateless
@LocalBean
public class IndicatorService implements IIndicatorServiceLocal, IIndicatorServiceRemote {
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	@EJB
	
	IndicatorCrud indicatorCrud;
	@Override
	public String addIndicator(Indicator indicators) {
		return indicatorCrud.addIndicator(indicators);	
	}

	@Override
	public void updateIndicator(Indicator indicators) {
		indicatorCrud.updateIndicator(indicators);	
	}

	@Override
	public void deleteIndicator(String code) {
		indicatorCrud.deleteIndicator(code);
		
	}

	@Override
	public List<Indicator> getAllIndicators() {
		return indicatorCrud.getAllIndicators();
	}

	@Override
	public Indicator getIndicatorByCode(String code) {
		TypedQuery<Indicator> query = 
				em.createQuery("SELECT c FROM Indicator c WHERE c.code=:code", Indicator.class); 
				query.setParameter("code",code); 
		return (Indicator) query.getResultList();
	}

}
