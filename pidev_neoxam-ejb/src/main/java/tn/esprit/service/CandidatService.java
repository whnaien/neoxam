package tn.esprit.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.impl.CandidatCrud;
import tn.esprit.entities.Candidat;
import tn.esprit.service.inter.IcandidateServiceLocal;
import tn.esprit.service.inter.IcandidateServiceRemote;



@Stateless
@LocalBean
public class CandidatService implements IcandidateServiceLocal,IcandidateServiceRemote  {
	
		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		@EJB
		CandidatCrud candCrud;
		

	@Override
	public String addCandidate(Candidat candidate) {
		return candCrud.addCandidate(candidate);
			
	}

	@Override
	public void removeCandidate(String Email) {
		candCrud.removeCandidate(Email);
		
	}

	@Override
	public void updateCandidate(Candidat candidateNewValue) {

		candCrud.updateCandidate(candidateNewValue);
	}

	@Override
	public Candidat findCandidateById(String Email) {
		// TODO Auto-generated method stub
		return candCrud.findCandidateById(Email);
	}

	@Override
	public List<Candidat> findAllCandidates() {
		// TODO Auto-generated method stub
		return candCrud.findAllCandidates();
	}

	@Override
	public List<Candidat> findCandidatesStringCriteria(String criteria, String value) {
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidate c WHERE "+ "c."+criteria+"=:value", Candidat.class); 
				query.setParameter("value", value); 
		return query.getResultList();
	}

	@Override
	public List<Candidat> findCandidatesByExp(Integer experience) {
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidate c WHERE c.Experience=:experience", Candidat.class); 
				query.setParameter("experience", experience); 
		return query.getResultList();
	}

}
