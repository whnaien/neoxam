package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Candidate;


@Remote
public interface IcandidateServiceRemote {
	public String addCandidate(Candidate candidate);
	public void removeCandidate(String Email); 
	public void updateCandidate (Candidate candidateNewValue);
	public Candidate findCandidateById(String Email);
	public List<Candidate> findAllCandidates();
	public List<Candidate> findCandidatesStringCriteria(String criteria, String value);
	public List<Candidate> findCandidatesByExp( Integer experience);


}
