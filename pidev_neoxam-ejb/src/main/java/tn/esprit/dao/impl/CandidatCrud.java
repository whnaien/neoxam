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
	public String addCandidat(Candidat candidate) {
		em.persist(candidate);
		return candidate.getEmail();
	}


	@Override
	public void removeCandidat(String Email) {
		em.remove(em.find(Candidat.class, Email));		
	}

	@Override
	public void updateCandidat(Candidat candidatNewValue) {

		em.merge(candidatNewValue);
		em.flush();
	}

	@Override
	public Candidat findCandidatById(String Email) {
		Candidat candidate = em.find(Candidat.class, Email);
		return candidate;
	}

	@Override
	public List<Candidat> findAllCandidats() {
		List<Candidat> candidats = em.createQuery("from Candidat", Candidat.class).getResultList();
		return candidats;
	}


}
