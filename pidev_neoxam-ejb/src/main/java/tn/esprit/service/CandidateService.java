package tn.esprit.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.impl.CandidateCrud;
import tn.esprit.entities.Candidate;
import tn.esprit.service.inter.IcandidateServiceLocal;
import tn.esprit.service.inter.IcandidateServiceRemote;



@Stateless
@LocalBean
public class CandidateService implements IcandidateServiceLocal,IcandidateServiceRemote  {
	
		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		@EJB
		CandidateCrud candCrud;
		

	@Override
	public String addCandidate(Candidate candidate) {
		return candCrud.addCandidate(candidate);
			
	}

	@Override
	public void removeCandidate(String Email) {
		candCrud.removeCandidate(Email);
		
	}

	@Override
	public void updateCandidate(Candidate candidateNewValue) {

		candCrud.updateCandidate(candidateNewValue);
	}

	@Override
	public Candidate findCandidateById(String Email) {
		// TODO Auto-generated method stub
		return candCrud.findCandidateById(Email);
	}

	@Override
	public List<Candidate> findAllCandidates() {
		// TODO Auto-generated method stub
		return candCrud.findAllCandidates();
	}

	@Override
	public List<Candidate> findCandidatesStringCriteria(String criteria, String value) {
		TypedQuery<Candidate> query = 
				em.createQuery("SELECT c FROM Candidate c WHERE "+ "c."+criteria+"=:value", Candidate.class); 
				query.setParameter("value", value); 
		return query.getResultList();
	}

	@Override
	public List<Candidate> findCandidatesByExp(Integer experience) {
		TypedQuery<Candidate> query = 
				em.createQuery("SELECT c FROM Candidate c WHERE c.Experience=:experience", Candidate.class); 
				query.setParameter("experience", experience); 
		return query.getResultList();
	}

}
