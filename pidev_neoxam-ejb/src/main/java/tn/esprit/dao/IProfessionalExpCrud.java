package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.ProfessionalExp;





public interface IProfessionalExpCrud {
	public void addProfessionalExp(ProfessionalExp professionalExp, String email);
	public void removeProfessionalExp(int id); 
	public void updateProfessionalExp (ProfessionalExp professionalExpNewValue);
	public ProfessionalExp findProfessionalExpById(int id);
	public List<ProfessionalExp> findAllProfessionalExps();
}
