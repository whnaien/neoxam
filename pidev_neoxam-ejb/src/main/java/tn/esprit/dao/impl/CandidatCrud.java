package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.ICandidatCrud;
import tn.esprit.entities.Candidat;



@Stateless
@LocalBean
public class CandidatCrud implements ICandidatCrud {
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	@Override
	public String addCandidate(Candidat candidate) {
		em.persist(candidate);
		return candidate.getEmail();
	}


	@Override
	public void removeCandidate(String Email) {
		em.remove(em.find(Candidat.class, Email));		
	}

	@Override
	public void updateCandidate(Candidat candidateNewValue) {

		em.merge(candidateNewValue);
		em.flush();
	}

	@Override
	public Candidat findCandidateById(String Email) {
		Candidat candidate = em.find(Candidat.class, Email);
		return candidate;
	}

	@Override
	public List<Candidat> findAllCandidates() {
		List<Candidat> candidates = em.createQuery("from Candidate", Candidat.class).getResultList();
		return candidates;
	}


}
