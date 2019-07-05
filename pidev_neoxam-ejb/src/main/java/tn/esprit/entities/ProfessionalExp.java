package tn.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: ProfessionalExp
 *
 */
@Entity
@XmlRootElement

public class ProfessionalExp implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String discription;
	private Integer years;
	private String company;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="FK_CAND_ID")
	Candidat candidat;
	
	private static final long serialVersionUID = 1L;

	public ProfessionalExp() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}   
	public Integer getYears() {
		return this.years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}   
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public Candidat getCandidat() {
		return candidat;
	}
	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
  
}
