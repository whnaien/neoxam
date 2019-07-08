package tn.esprit.service;

import java.util.List;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import tn.esprit.dao.impl.SkillCrud;
import tn.esprit.entities.Skill;
import tn.esprit.service.inter.IskillServiceLocal;
import tn.esprit.service.inter.IskillServiceRemote;



@Stateless
@LocalBean
public class SkillService implements IskillServiceLocal,IskillServiceRemote  {
	
		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		@EJB
		SkillCrud skillCrud;
		

	@Override
	public void addSkills(Skill skill,String email) {
		 skillCrud.addSkills(skill, email);
		
			
	}

	@Override
	public void removeSkill(int id) {
		skillCrud.removeSkill(id);
		
	}

	@Override
	public void updateSkill(Skill skillNewValue) {

		skillCrud.updateSkill(skillNewValue);
	}

	@Override
	public Skill findSkillById(int  id) {
		// TODO Auto-generated method stub
		return skillCrud.findSkillById(id);
	}

	@Override
	public List<Skill> findAllSkills() {
		// TODO Auto-generated method stub
		return skillCrud.findAllSkills();
	}



}
