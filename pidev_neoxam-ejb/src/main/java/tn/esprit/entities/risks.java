package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "risks")
public class risks implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ref;
	private Date date;
	private Float valueScore;
    private Float totalScore;
	private type_risk typeRisk;
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Float getValueScore() {
		return valueScore;
	}
	public void setValueScore(Float valueScore) {
		this.valueScore = valueScore;
	}
	public Float getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Float totalScore) {
		this.totalScore = totalScore;
	}
	public type_risk getTypeRisk() {
		return typeRisk;
	}
	public void setTypeRisk(type_risk typeRisk) {
		this.typeRisk = typeRisk;
	}
	/*@ManyToOne
	@JoinColumn(name= 'risks')
	indicators ind ;*/
	
	
	
	
}
