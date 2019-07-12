package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "OnlineTestResult")
public class OnlineTestResult implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private OnlineTestResultPk onlineTestResultPk;
	
	
	private Date onlineTestResultDate;
	private String onlineTestResultScore;
	private String onlineTestResultDescription;
	private Boolean isActif;
	private String onlineTestResultDuration;
	
	@ManyToOne
	@JoinColumn(name="cin" , referencedColumnName="cin", insertable=false, updatable=false)
	private Candidate candidateResult;
	
	
	
	public Candidate getCandidateResult() {
		return candidateResult;
	}



	public void setCandidateResult(Candidate candidateResult) {
		this.candidateResult = candidateResult;
	}



	@ManyToOne
	@JoinColumn(name="OnlineTest_id" , referencedColumnName="OnlineTest_id", insertable=false, updatable=false)
	private OnlineTest onlineTestResult ;



	public OnlineTest getOnlineTestResult() {
		return onlineTestResult;
	}



	public void setOnlineTestResult(OnlineTest onlineTestResult) {
		this.onlineTestResult = onlineTestResult;
	}



	public OnlineTestResult() {
		super();
	}



	public OnlineTestResult(OnlineTestResultPk onlineTestResultPk, Date onlineTestResultDate,
			String onlineTestResultScore, String onlineTestResultDescription, Boolean isActif,
			String onlineTestResultDuration, Candidate candidateResult, OnlineTest onlineTestResult) {
		super();
		this.onlineTestResultPk = onlineTestResultPk;
		this.onlineTestResultDate = onlineTestResultDate;
		this.onlineTestResultScore = onlineTestResultScore;
		this.onlineTestResultDescription = onlineTestResultDescription;
		this.isActif = isActif;
		this.onlineTestResultDuration = onlineTestResultDuration;
		this.candidateResult = candidateResult;
		this.onlineTestResult = onlineTestResult;
	}



	public OnlineTestResultPk getOnlineTestResultPk() {
		return onlineTestResultPk;
	}



	public void setOnlineTestResultPk(OnlineTestResultPk onlineTestResultPk) {
		this.onlineTestResultPk = onlineTestResultPk;
	}



	public Date getOnlineTestResultDate() {
		return onlineTestResultDate;
	}



	public void setOnlineTestResultDate(Date onlineTestResultDate) {
		this.onlineTestResultDate = onlineTestResultDate;
	}



	public String getOnlineTestResultScore() {
		return onlineTestResultScore;
	}



	public void setOnlineTestResultScore(String onlineTestResultScore) {
		this.onlineTestResultScore = onlineTestResultScore;
	}



	public String getOnlineTestResultDescription() {
		return onlineTestResultDescription;
	}



	public void setOnlineTestResultDescription(String onlineTestResultDescription) {
		this.onlineTestResultDescription = onlineTestResultDescription;
	}



	public Boolean getIsActif() {
		return isActif;
	}



	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}



	public String getOnlineTestResultDuration() {
		return onlineTestResultDuration;
	}



	public void setOnlineTestResultDuration(String onlineTestResultDuration) {
		this.onlineTestResultDuration = onlineTestResultDuration;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidateResult == null) ? 0 : candidateResult.hashCode());
		result = prime * result + ((isActif == null) ? 0 : isActif.hashCode());
		result = prime * result + ((onlineTestResult == null) ? 0 : onlineTestResult.hashCode());
		result = prime * result + ((onlineTestResultDate == null) ? 0 : onlineTestResultDate.hashCode());
		result = prime * result + ((onlineTestResultDescription == null) ? 0 : onlineTestResultDescription.hashCode());
		result = prime * result + ((onlineTestResultDuration == null) ? 0 : onlineTestResultDuration.hashCode());
		result = prime * result + ((onlineTestResultPk == null) ? 0 : onlineTestResultPk.hashCode());
		result = prime * result + ((onlineTestResultScore == null) ? 0 : onlineTestResultScore.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OnlineTestResult other = (OnlineTestResult) obj;
		if (candidateResult == null) {
			if (other.candidateResult != null)
				return false;
		} else if (!candidateResult.equals(other.candidateResult))
			return false;
		if (isActif == null) {
			if (other.isActif != null)
				return false;
		} else if (!isActif.equals(other.isActif))
			return false;
		if (onlineTestResult == null) {
			if (other.onlineTestResult != null)
				return false;
		} else if (!onlineTestResult.equals(other.onlineTestResult))
			return false;
		if (onlineTestResultDate == null) {
			if (other.onlineTestResultDate != null)
				return false;
		} else if (!onlineTestResultDate.equals(other.onlineTestResultDate))
			return false;
		if (onlineTestResultDescription == null) {
			if (other.onlineTestResultDescription != null)
				return false;
		} else if (!onlineTestResultDescription.equals(other.onlineTestResultDescription))
			return false;
		if (onlineTestResultDuration == null) {
			if (other.onlineTestResultDuration != null)
				return false;
		} else if (!onlineTestResultDuration.equals(other.onlineTestResultDuration))
			return false;
		if (onlineTestResultPk == null) {
			if (other.onlineTestResultPk != null)
				return false;
		} else if (!onlineTestResultPk.equals(other.onlineTestResultPk))
			return false;
		if (onlineTestResultScore == null) {
			if (other.onlineTestResultScore != null)
				return false;
		} else if (!onlineTestResultScore.equals(other.onlineTestResultScore))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "OnlineTestResult [onlineTestResultPk=" + onlineTestResultPk + ", onlineTestResultDate="
				+ onlineTestResultDate + ", onlineTestResultScore=" + onlineTestResultScore
				+ ", onlineTestResultDescription=" + onlineTestResultDescription + ", isActif=" + isActif
				+ ", onlineTestResultDuration=" + onlineTestResultDuration + ", candidateResult=" + candidateResult
				+ ", onlineTestResult=" + onlineTestResult + "]";
	}
	
    
	
	
	
	
	
	
	

}
