package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.ISkillCrud;
import tn.esprit.entities.Candidat;
import tn.esprit.entities.Skill;

@Stateless
@LocalBean
public class SkillCrud implements ISkillCrud {
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	@Override
	public void addSkills(Skill skill, String email)
	{
		TypedQuery<Candidat> query = 
				em.createQuery("SELECT c FROM Candidat c WHERE email=:value", Candidat.class); 
				query.setParameter("value", email); 
				Candidat candidat=  query.getSingleResult();
				skill.setCandidat(candidat);
		em.persist(skill);
		
	}


	@Override
	public void removeSkill(int id) {
		em.remove(em.find(Skill.class,id ));		
		
	}

	@Override
	public void updateSkill(Skill skillNewValue) {

		em.merge(skillNewValue);
		em.flush();
	}

	@Override
	public Skill findSkillById(int id) {
		Skill skill = em.find(Skill.class, id);
		return skill;
	}

	@Override
	public List<Skill> findAllSkills() {
		List<Skill> skills = em.createQuery("from Skill", Skill.class).getResultList();
		return skills;
	}


}
