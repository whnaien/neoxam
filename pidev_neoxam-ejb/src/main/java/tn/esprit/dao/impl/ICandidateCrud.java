package tn.esprit.dao.impl;

import java.util.List;

import tn.esprit.entities.Candidate;





public interface ICandidateCrud {
	public String addCandidate(Candidate candidate);
	public void removeCandidate(String Email); 
	public void updateCandidate (Candidate candidateNewValue);
	public Candidate findCandidateById(String Email);
	public List<Candidate> findAllCandidates();
}
