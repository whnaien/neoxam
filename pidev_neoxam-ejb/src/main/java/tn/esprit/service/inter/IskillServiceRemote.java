package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Skill;


@Remote
public interface IskillServiceRemote {
	public void addSkills(Skill skill, String email);
	public void removeSkill(int id); 
	public void updateSkill (Skill skillNewValue);
	public Skill findSkillById(int id);
	public List<Skill> findAllSkills();
}
