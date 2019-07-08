package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "DaoQuestion")
public class DaoQuestion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "daoQuestionId")
	private int daoQuestionId;
	private String question;
	private String prop1;
	private String prop2;
	private String prop3;
	private String prop4;
	private int response;
	private String description;
	
	public DaoQuestion() {
		super();
	}

	public DaoQuestion(int daoQuestionId, String question, String prop1, String prop2, String prop3, String prop4,
			int response, String description) {
		super();
		this.daoQuestionId = daoQuestionId;
		this.question = question;
		this.prop1 = prop1;
		this.prop2 = prop2;
		this.prop3 = prop3;
		this.prop4 = prop4;
		this.response = response;
		this.description = description;
	}

	public int getDaoQuestionId() {
		return daoQuestionId;
	}

	public void setDaoQuestionId(int daoQuestionId) {
		this.daoQuestionId = daoQuestionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public String getProp2() {
		return prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	public String getProp3() {
		return prop3;
	}

	public void setProp3(String prop3) {
		this.prop3 = prop3;
	}

	public String getProp4() {
		return prop4;
	}

	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}

	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DaoQuestion [daoQuestionId=" + daoQuestionId + ", question=" + question + ", prop1=" + prop1
				+ ", prop2=" + prop2 + ", prop3=" + prop3 + ", prop4=" + prop4 + ", response=" + response
				+ ", description=" + description + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
