package tn.esprit.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.impl.ICandidateCrud;
import tn.esprit.entities.Candidate;



@Stateless
@LocalBean
public class CandidateCrud implements ICandidateCrud {
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	@Override
	public String addCandidate(Candidate candidate) {
		em.persist(candidate);
		return candidate.getEmail();
	}


	@Override
	public void removeCandidate(String Email) {
		em.remove(em.find(Candidate.class, Email));		
	}

	@Override
	public void updateCandidate(Candidate candidateNewValue) {

		em.merge(candidateNewValue);
		em.flush();
	}

	@Override
	public Candidate findCandidateById(String Email) {
		Candidate candidate = em.find(Candidate.class, Email);
		return candidate;
	}

	@Override
	public List<Candidate> findAllCandidates() {
		List<Candidate> candidates = em.createQuery("from Candidate", Candidate.class).getResultList();
		return candidates;
	}


}
