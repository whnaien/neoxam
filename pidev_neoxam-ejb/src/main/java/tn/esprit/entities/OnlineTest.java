package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "OnlineTest")
public class OnlineTest implements Serializable {
	
	
	
	public enum OnlineTestType implements Serializable {
		java, javaee, english, php,plsql,python,languageC,vbs, vba
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "OnlineTest_id")
	private int idTestOnline;
	
	@Enumerated(EnumType.ORDINAL)
	private OnlineTestType onlineTestType;
	private String onlineTestdescription;
	private String onlineTestaddressURL;
	private Boolean isActif;
	private String onlineTestDuration;
	
	
	
	@OneToMany(mappedBy = "onlineTestResult")
	private List<OnlineTestResult> onlineTestResults;



	public OnlineTest() {
		super();
	}



	public OnlineTest(int idTestOnline, OnlineTestType onlineTestType, String onlineTestdescription,
			String onlineTestaddressURL, Boolean isActif, String onlineTestDuration,
			List<OnlineTestResult> onlineTestResults) {
		super();
		this.idTestOnline = idTestOnline;
		this.onlineTestType = onlineTestType;
		this.onlineTestdescription = onlineTestdescription;
		this.onlineTestaddressURL = onlineTestaddressURL;
		this.isActif = isActif;
		this.onlineTestDuration = onlineTestDuration;
		this.onlineTestResults = onlineTestResults;
	}



	public int getIdTestOnline() {
		return idTestOnline;
	}



	public void setIdTestOnline(int idTestOnline) {
		this.idTestOnline = idTestOnline;
	}



	public OnlineTestType getOnlineTestType() {
		return onlineTestType;
	}



	public void setOnlineTestType(OnlineTestType onlineTestType) {
		this.onlineTestType = onlineTestType;
	}



	public String getOnlineTestdescription() {
		return onlineTestdescription;
	}



	public void setOnlineTestdescription(String onlineTestdescription) {
		this.onlineTestdescription = onlineTestdescription;
	}



	public String getOnlineTestaddressURL() {
		return onlineTestaddressURL;
	}



	public void setOnlineTestaddressURL(String onlineTestaddressURL) {
		this.onlineTestaddressURL = onlineTestaddressURL;
	}



	public Boolean getIsActif() {
		return isActif;
	}



	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}



	public String getOnlineTestDuration() {
		return onlineTestDuration;
	}



	public void setOnlineTestDuration(String onlineTestDuration) {
		this.onlineTestDuration = onlineTestDuration;
	}



	public List<OnlineTestResult> getOnlineTestResults() {
		return onlineTestResults;
	}



	public void setOnlineTestResults(List<OnlineTestResult> onlineTestResults) {
		this.onlineTestResults = onlineTestResults;
	}



	@Override
	public String toString() {
		return "OnlineTest [idTestOnline=" + idTestOnline + ", onlineTestType=" + onlineTestType
				+ ", onlineTestdescription=" + onlineTestdescription + ", onlineTestaddressURL=" + onlineTestaddressURL
				+ ", isActif=" + isActif + ", onlineTestDuration=" + onlineTestDuration + ", onlineTestResults="
				+ onlineTestResults + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTestOnline;
		result = prime * result + ((isActif == null) ? 0 : isActif.hashCode());
		result = prime * result + ((onlineTestDuration == null) ? 0 : onlineTestDuration.hashCode());
		result = prime * result + ((onlineTestResults == null) ? 0 : onlineTestResults.hashCode());
		result = prime * result + ((onlineTestType == null) ? 0 : onlineTestType.hashCode());
		result = prime * result + ((onlineTestaddressURL == null) ? 0 : onlineTestaddressURL.hashCode());
		result = prime * result + ((onlineTestdescription == null) ? 0 : onlineTestdescription.hashCode());
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
		OnlineTest other = (OnlineTest) obj;
		if (idTestOnline != other.idTestOnline)
			return false;
		if (isActif == null) {
			if (other.isActif != null)
				return false;
		} else if (!isActif.equals(other.isActif))
			return false;
		if (onlineTestDuration == null) {
			if (other.onlineTestDuration != null)
				return false;
		} else if (!onlineTestDuration.equals(other.onlineTestDuration))
			return false;
		if (onlineTestResults == null) {
			if (other.onlineTestResults != null)
				return false;
		} else if (!onlineTestResults.equals(other.onlineTestResults))
			return false;
		if (onlineTestType != other.onlineTestType)
			return false;
		if (onlineTestaddressURL == null) {
			if (other.onlineTestaddressURL != null)
				return false;
		} else if (!onlineTestaddressURL.equals(other.onlineTestaddressURL))
			return false;
		if (onlineTestdescription == null) {
			if (other.onlineTestdescription != null)
				return false;
		} else if (!onlineTestdescription.equals(other.onlineTestdescription))
			return false;
		return true;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
