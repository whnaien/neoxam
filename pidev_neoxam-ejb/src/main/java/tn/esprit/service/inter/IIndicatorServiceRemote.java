package tn.esprit.service.inter;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.entities.Indicator;

@Remote
public interface IIndicatorServiceRemote {
	public String addIndicator(Indicator indicators );
	public void updateIndicator(Indicator indicators);
	public void deleteIndicator(String code);
	public List<Indicator> getAllIndicators();
	public Indicator getIndicatorByCode(String code);
}
