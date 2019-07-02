package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("condidate")
public class Condidate extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String condiateCode;

	public String getCondiateCode() {
		return condiateCode;
	}

	public void setCondiateCode(String condiateCode) {
		this.condiateCode = condiateCode;
	}

}
