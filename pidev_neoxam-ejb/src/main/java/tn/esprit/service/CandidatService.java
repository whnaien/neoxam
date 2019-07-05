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
import tn.esprit.service.inter.IcandidatServiceLocal;
import tn.esprit.service.inter.IcandidatServiceRemote;



@Stateless
@LocalBean
public class CandidatService implements IcandidatServiceLocal,IcandidatServiceRemote  {
	
		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		@EJB
		CandidatCrud candCrud;
		

	@Override
	public String addCandidat(Candidat candidate) {
		return candCrud.addCandidat(candidate);
			
	}

	@Override
	public void removeCandidat(String Email) {
		candCrud.removeCandidat(Email);
		
	}

	@Override
	public void updateCandidat(Candidat candidateNewValue) {

		candCrud.updateCandidat(candidateNewValue);
	}

	@Override
	public Candidat findCandidatById(String Email) {
		// TODO Auto-generated method stub
		return candCrud.findCandidatById(Email);
	}

	@Override
	public List<Candidat> findAllCandidats() {
		// TODO Auto-generated method stub
		return candCrud.findAllCandidats();
	}

	@Override
	public List<Candidat> findCandidatsStringCriteria(String criteria, String value) {
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidat c WHERE "+ "c."+criteria+"=:value", Candidat.class); 
				query.setParameter("value", value); 
		return query.getResultList();
	}

	@Override
	public List<Candidat> findCandidatsByExp(Integer experience) {
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidat c WHERE c.Experience=:experience", Candidat.class); 
				query.setParameter("experience", experience); 
		return query.getResultList();
	}

}
