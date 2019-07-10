package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("risks")
public class Risk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String ref;
	private Date date;
	private Float valueScore;
    private Float totalScore;
	private type_risk typeRisk;
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
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

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="risk")
	private Set<Indicator> indicators =  new HashSet<Indicator>();
	
  
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="FK_Empl_CIN")
	Employee employee;
	
	public Set<Indicator> getIndicators() {
		return indicators;
	}
	public void setIndicators(Set<Indicator> indicators) {
		this.indicators = indicators;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Risk(String ref, Date date, Float valueScore, Float totalScore, type_risk typeRisk,
			Set<Indicator> indicators, Employee employee) {
		super();
		this.ref = ref;
		this.date = date;
		this.valueScore = valueScore;
		this.totalScore = totalScore;
		this.typeRisk = typeRisk;
		this.indicators = indicators;
		this.employee = employee;
	}
	public Risk() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Risk [ref=" + ref + ", date=" + date + ", valueScore=" + valueScore + ", totalScore=" + totalScore
				+ ", typeRisk=" + typeRisk + ", indicators=" + indicators + ", employee=" + employee + "]";
	}
	
}
