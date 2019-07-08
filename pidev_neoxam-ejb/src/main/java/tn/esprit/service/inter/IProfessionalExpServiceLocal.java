package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.ProfessionalExp;


@Local
public interface IProfessionalExpServiceLocal {
	public void addProfessionalExp(ProfessionalExp professionalExp, String email);
	public void removeProfessionalExp(int id); 
	public void updateProfessionalExp (ProfessionalExp professionalExpNewValue);
	public ProfessionalExp findProfessionalExpById(int id);
	public List<ProfessionalExp> findAllProfessionalExps();
	
	
}
