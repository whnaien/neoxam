package tn.esprit.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.dao.IIndicatorCrud;
import tn.esprit.entities.Indicator;

public class IndicatorCrud implements IIndicatorCrud{
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
	@Override
	public String addIndicator(Indicator indicators) {
		em.persist(indicators);
		return indicators.getCode();
	}

	@Override
	public void updateIndicator(Indicator indicators) {
		em.merge(indicators);
		em.flush();
	}

	@Override
	public void deleteIndicator(String code) {
		em.remove(em.find(Indicator.class, code));
		
	}

	@Override
	public List<Indicator> getAllIndicators() {
		List<Indicator> indicators = em.createQuery("from Indicator", Indicator.class).getResultList();
		return indicators;
	}
	

	@Override
	public Indicator getIndicatorByCode(String code) {
		Indicator indicator = em.find(Indicator.class, code);
		return indicator;
	}

}
