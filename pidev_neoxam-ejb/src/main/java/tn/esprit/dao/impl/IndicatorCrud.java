package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.IIndicatorCrud;
import tn.esprit.entities.Indicator;


@Stateless
@LocalBean
public class IndicatorCrud implements IIndicatorCrud{
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
	@Override
	public Indicator addIndicator(Indicator indicator) {
		em.persist(indicator);
		em.flush();
		return indicator;	
		
		}
	

	@Override
	public Indicator updateIndicator(Indicator indicators) {
		em.merge(indicators);
		em.flush();
		return indicators;
		
	}

	@Override
	public void deleteIndicator(String code) {
		TypedQuery<Indicator> query = 
				em.createQuery("SELECT c FROM Indicator c WHERE code=:value", Indicator.class); 
				query.setParameter("value", code); 
				Indicator ind=  query.getSingleResult();
		em.remove(ind);
				
	}
	
	@Override
	public List<Indicator> getAllIndicators() {
		List<Indicator> indicators = em.createQuery("from Indicator", Indicator.class).getResultList();
		return indicators;
	}
	
	@Override
	public Indicator getIndicatorByCode(String code) {
		return em.find(Indicator.class, code);
		
	}

}
