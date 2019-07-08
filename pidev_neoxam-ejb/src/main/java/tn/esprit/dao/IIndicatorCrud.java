package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.Indicator;



public interface IIndicatorCrud {
	public String addIndicator(Indicator indicators );
	public void updateIndicator(Indicator indicators);
	public void deleteIndicator(String code);
	public List<Indicator> getAllIndicators();
	public Indicator getIndicatorByCode(String code);
	
}
