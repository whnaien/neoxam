package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("candidate")
public class Candidate extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "candidateResult")
	private List<OnlineTestResult> onlineTestResults;
	

	public List<OnlineTestResult> getOnlineTestResults() {
		return onlineTestResults;
	}

	public void setOnlineTestResults(List<OnlineTestResult> onlineTestResults) {
		this.onlineTestResults = onlineTestResults;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String candiateCode;

	public String getCandiateCode() {
		return candiateCode;
	}

	public void setCandiateCode(String candiateCode) {
		this.candiateCode = candiateCode;
	}

}
