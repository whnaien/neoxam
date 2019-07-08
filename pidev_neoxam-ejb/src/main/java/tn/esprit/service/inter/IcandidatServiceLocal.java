package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Candidat;
import tn.esprit.entities.Skill;


@Local
public interface IcandidatServiceLocal {
	public String addCandidat(Candidat candidate);
	public void removeCandidat(String Email); 
	public void updateCandidat (Candidat candidateNewValue);
	public Candidat findCandidatById(String Email);
	public List<Candidat> findAllCandidats();
	public List<Candidat> findCandidatsStringCriteria(String criteria, String value);
	public List<Candidat> findCandidatsByExp( Integer experience);
	public void invitCandidat(String receiverEmail);
	public void extarctPst(String filename);
	
	
}
