package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.ICandidatCrud;
import tn.esprit.entities.Candidat;

@Stateless
@LocalBean
public class CandidatCrud implements ICandidatCrud {
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	@Override
	public String addCandidat(Candidat candidat) {
		em.persist(candidat);
		return candidat.getEmail();
	}


	@Override
	public void removeCandidat(String Email) {
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidat c WHERE email=:value", Candidat.class); 
				query.setParameter("value", Email); 
				Candidat candidat=  query.getSingleResult();
		em.remove(candidat);		
	}

	@Override
	public void updateCandidat(Candidat candidatNewValue) {

		em.merge(candidatNewValue);
		em.flush();
	}

	@Override
	public Candidat findCandidatById(String Email) {
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidat c WHERE email=:value", Candidat.class); 
				query.setParameter("value", Email); 
				Candidat candidat=  query.getSingleResult();
				return candidat;
	}

	@Override
	public List<Candidat> findAllCandidats() {
		List<Candidat> candidats = em.createQuery("from Candidat", Candidat.class).getResultList();
		return candidats;
	}


}
