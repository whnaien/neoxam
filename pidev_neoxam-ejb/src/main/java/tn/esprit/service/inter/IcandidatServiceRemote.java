package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Candidat;


@Remote
public interface IcandidatServiceRemote {
	public String addCandidat(Candidat candidate);
	public void removeCandidat(String Email); 
	public void updateCandidat (Candidat candidateNewValue);
	public Candidat findCandidatById(String Email);
	public List<Candidat> findAllCandidats();
	public List<Candidat> findCandidatsStringCriteria(String criteria, String value);
	public List<Candidat> findCandidatsByExp( Integer experience);


}
