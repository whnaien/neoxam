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
	public Indicator addIndicator(Indicator indicators) {
		em.persist(indicators);
		em.flush();
		return indicators;	
	}
	/*
	 * em.persist(onlineTest);
		return onlineTest.getIdTestOnline();
	 */

	@Override
	public Indicator updateIndicator(Indicator indicators) {
		em.merge(indicators);
		em.flush();
		return indicators;
		
	}

	@Override
	public String deleteIndicator(String code) {

		
		//em.remove(em.find(Indicator.class, code));
		Indicator e = em.find(Indicator.class, code);
		em.remove(em.contains(e) ? e : em.merge(e));
		return "indicator deleted" +code;
				
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
