package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Skill;


@Local
public interface IskillServiceLocal {
	public void addSkills(Skill skill, String email);
	public void removeSkill(int id); 
	public void updateSkill (Skill skillNewValue);
	public Skill findSkillById(int id);
	public List<Skill> findAllSkills();
	
	
}
