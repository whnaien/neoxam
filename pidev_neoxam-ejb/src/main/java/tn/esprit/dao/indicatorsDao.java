package tn.esprit.dao;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Indicator;


@Local
public interface indicatorsDao {
	public int addIndicator(Indicator indicators );
	public int updateIndicator(Indicator indicators);
	public void deleteIndicator(int code);
	public List<Indicator> getAllIndicators();
	public Indicator getIndicatorByCode(int code);
	
}
