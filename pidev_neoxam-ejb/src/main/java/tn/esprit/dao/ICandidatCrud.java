package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.Candidat;





public interface ICandidatCrud {
	public String addCandidate(Candidat candidate);
	public void removeCandidate(String Email); 
	public void updateCandidate (Candidat candidateNewValue);
	public Candidat findCandidateById(String Email);
	public List<Candidat> findAllCandidates();
}
