package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Candidat;


@Local
public interface IcandidateServiceLocal {
	public String addCandidate(Candidat candidate);
	public void removeCandidate(String Email); 
	public void updateCandidate (Candidat candidateNewValue);
	public Candidat findCandidateById(String Email);
	public List<Candidat> findAllCandidates();
	public List<Candidat> findCandidatesStringCriteria(String criteria, String value);
	public List<Candidat> findCandidatesByExp( Integer experience);
	
}
