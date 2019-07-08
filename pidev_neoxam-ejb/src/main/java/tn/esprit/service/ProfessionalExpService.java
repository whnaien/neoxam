package tn.esprit.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.impl.ProfessionalExpCrud;
import tn.esprit.entities.ProfessionalExp;
import tn.esprit.service.inter.IProfessionalExpServiceLocal;
import tn.esprit.service.inter.IProfessionalExpServiceRemote;





@Stateless
@LocalBean
public class ProfessionalExpService implements IProfessionalExpServiceLocal,IProfessionalExpServiceRemote  {
	
		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		@EJB
		ProfessionalExpCrud professionalExpCrud;
		

	@Override
	public void addProfessionalExp(ProfessionalExp professionalExp,String email) {
		 professionalExpCrud.addProfessionalExp(professionalExp, email);
		
			
	}

	@Override
	public void removeProfessionalExp(int id) {
		professionalExpCrud.removeProfessionalExp(id);
		
	}

	@Override
	public void updateProfessionalExp(ProfessionalExp professionalExpNewValue) {

		professionalExpCrud.updateProfessionalExp(professionalExpNewValue);
	}

	@Override
	public ProfessionalExp findProfessionalExpById(int  id) {
		// TODO Auto-generated method stub
		return professionalExpCrud.findProfessionalExpById(id);
	}

	@Override
	public List<ProfessionalExp> findAllProfessionalExps() {
		// TODO Auto-generated method stub
		return professionalExpCrud.findAllProfessionalExps();
	}



}
