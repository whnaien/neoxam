package tn.esprit.service.inter;

import java.util.List;
import javax.ejb.Local;
import tn.esprit.entities.Indicator;

@Local
public interface IIndicatorServiceLocal {
	public Indicator addIndicator(Indicator indicators );
	public Indicator updateIndicator(Indicator indicators);
	public String deleteIndicator(String code);
	public List<Indicator> getAllIndicators();
	public Indicator getIndicatorByCode(String code);
	
}