package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OnlineTestResultPk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idCandidate;
	private int idOnlineTest;
	public OnlineTestResultPk() {
		super();
	}
	public OnlineTestResultPk(int idCandidate, int idOnlineTest) {
		super();
		this.idCandidate = idCandidate;
		this.idOnlineTest = idOnlineTest;
	}
	public int getIdCandidate() {
		return idCandidate;
	}
	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}
	public int getIdOnlineTest() {
		return idOnlineTest;
	}
	public void setIdOnlineTest(int idOnlineTest) {
		this.idOnlineTest = idOnlineTest;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCandidate;
		result = prime * result + idOnlineTest;
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
		OnlineTestResultPk other = (OnlineTestResultPk) obj;
		if (idCandidate != other.idCandidate)
			return false;
		if (idOnlineTest != other.idOnlineTest)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	

}
