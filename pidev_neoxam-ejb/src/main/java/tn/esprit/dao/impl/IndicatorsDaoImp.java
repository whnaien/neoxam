package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.dao.indicatorsDao;
import tn.esprit.entities.Indicator;

@Stateless
public class IndicatorsDaoImp implements indicatorsDao {

	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
	@Override
	public int addIndicator(Indicator indicators) {
		em.persist(indicators);
		return indicators.getCode();
	}

	@Override
	public int updateIndicator(Indicator indicators) {
		em.persist(indicators);
	return indicators.getCode();	
	}

	@Override
	public void deleteIndicator(int code) {
		Indicator indicators = em.find(Indicator.class, code);
		em.remove(indicators);	
	}

	@Override
	public List<Indicator> getAllIndicators() {
		return (List<Indicator>) em.createQuery(
	            "SELECT ind FROM Indicator ind").getResultList();
	}
	
	@Override
	public Indicator getIndicatorByCode(int code) {
		return  em.find(Indicator.class, code);
	}

}
