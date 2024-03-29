package tn.esprit.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int active;
	private String university;
	private String lastDiplom;
	private double salaire;
	@Lob
	private byte[] imageUri;

	
	
	@ManyToOne
	private Employee responsable;
	

	private String job;
	
	
	@ManyToOne
	private Project project;
	

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getLastDiplom() {
		return lastDiplom;
	}

	public void setLastDiplom(String lastDiplom) {
		this.lastDiplom = lastDiplom;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public Employee getResponsable() {
		return responsable;
	}

	public void setResponsable(Employee responsable) {
		this.responsable = responsable;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public byte[] getImageUri() {
		return imageUri;
	}

	public void setImageUri(byte[] imageUri) {
		this.imageUri = imageUri;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	
	
	
}
