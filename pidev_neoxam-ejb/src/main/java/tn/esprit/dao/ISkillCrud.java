package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.Skill;





public interface ISkillCrud {
	public void addSkills(Skill skill, String email);
	public void removeSkill(int id); 
	public void updateSkill (Skill skillNewValue);
	public Skill findSkillById(int id);
	public List<Skill> findAllSkills();
}
