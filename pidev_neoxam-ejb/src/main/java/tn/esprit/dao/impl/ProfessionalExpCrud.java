package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.IProfessionalExpCrud;
import tn.esprit.entities.Candidat;
import tn.esprit.entities.ProfessionalExp;

@Stateless
@LocalBean
public class ProfessionalExpCrud implements IProfessionalExpCrud {
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	@Override
	public void addProfessionalExp(ProfessionalExp professionalExp, String email)
	{
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidat c WHERE email=:value", Candidat.class); 
				query.setParameter("value", email); 
				Candidat candidat=  query.getSingleResult();
				professionalExp.setCandidat(candidat);
		em.persist(professionalExp);
		
	}


	@Override
	public void removeProfessionalExp(int id) {
		em.remove(em.find(ProfessionalExp.class,id ));		
		
	}

	@Override
	public void updateProfessionalExp(ProfessionalExp professionalExpNewValue) {

		em.merge(professionalExpNewValue);
		em.flush();
	}

	@Override
	public ProfessionalExp findProfessionalExpById(int id) {
		ProfessionalExp professionalExp = em.find(ProfessionalExp.class, id);
		return professionalExp;
	}

	@Override
	public List<ProfessionalExp> findAllProfessionalExps() {
		List<ProfessionalExp> professionalExps = em.createQuery("from ProfessionalExp", ProfessionalExp.class).getResultList();
		return professionalExps;
	}


}
