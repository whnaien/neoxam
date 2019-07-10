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
import tn.esprit.service.inter.IIndicatorServiceLocal;
import tn.esprit.service.inter.IIndicatorServiceRemote;

@Stateless
@LocalBean
public class IndicatorService implements IIndicatorServiceLocal, IIndicatorServiceRemote {
	@PersistenceContext(unitName = "pidev")
	
	@EJB
	IndicatorCrud indicatorCrud;
	
	@Override
	public Indicator addIndicator(Indicator indicators) {
		return indicatorCrud.addIndicator(indicators);	
			}

	@Override
	public Indicator updateIndicator(Indicator indicators) {
		return indicatorCrud.updateIndicator(indicators);	
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
		return indicatorCrud.getIndicatorByCode(code);
	}

}
