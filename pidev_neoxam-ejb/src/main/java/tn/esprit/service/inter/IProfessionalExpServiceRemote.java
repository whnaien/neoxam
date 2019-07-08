package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.ProfessionalExp;


@Remote
public interface IProfessionalExpServiceRemote {
	public void addProfessionalExp(ProfessionalExp professionalExp, String email);
	public void removeProfessionalExp(int id); 
	public void updateProfessionalExp (ProfessionalExp professionalExpNewValue);
	public ProfessionalExp findProfessionalExpById(int id);
	public List<ProfessionalExp> findAllProfessionalExps();
}
