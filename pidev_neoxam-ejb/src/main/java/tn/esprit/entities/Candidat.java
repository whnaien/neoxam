package tn.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Entity implementation class for Entity: Candidate
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@XmlRootElement

public class Candidat extends User implements Serializable {

	   

	private String academicLevel;
	private String University;
	private Integer Experience;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="candidat")
	@JsonIgnore
	private Set<Skill> skills = new HashSet<Skill>();
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="candidat")
	@JsonIgnore
	private Set<ProfessionalExp> professionalExps = new HashSet<ProfessionalExp>();
	

	public Candidat(String academicLevel, String university,Integer experience) {
		super();

		this.academicLevel = academicLevel;
		University = university;
		Experience = experience;
	}
	public Candidat() {
		super();
	}   
	public String getAcademicLevel() {
		return this.academicLevel;
	}

	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}   
	public String getUniversity() {
		return this.University;
	}

	public void setUniversity(String University) {
		this.University = University;
	}   
	public Integer getExperience() {
		return this.Experience;
	}

	public void setExperience(Integer Experience) {
		this.Experience = Experience;
	}
	
	public Set<Skill> getSkills() {
		return skills;
	}
	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Set<ProfessionalExp> getProfessionalExps() {
		return professionalExps;
	}
	public void setProfessionalExps(Set<ProfessionalExp> professionalExps) {
		this.professionalExps = professionalExps;
	}
	
	@Override
	public String toString() {
		return "Candidat [academicLevel="
				+ academicLevel + ", University=" + University + ", Experience=" + Experience + "]";
	}
   
}
