package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Candidate;


@Local
public interface IcandidateServiceLocal {
	public String addCandidate(Candidate candidate);
	public void removeCandidate(String Email); 
	public void updateCandidate (Candidate candidateNewValue);
	public Candidate findCandidateById(String Email);
	public List<Candidate> findAllCandidates();
	public List<Candidate> findCandidatesStringCriteria(String criteria, String value);
	public List<Candidate> findCandidatesByExp( Integer experience);
	
}
