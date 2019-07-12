package tn.esprit.entities;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Question implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int questionId;
	private String question;
	private String prop1;
	private String prop2;
	private String prop3;
	private String prop4;
	private int response;
	private String description;
	private String warningCorrectResponse;
	
	
	@EJB
	DaoQuestion daoQuestion;


	public Question() {
		super();
	}


	public Question(int questionId, String question, String prop1, String prop2, String prop3, String prop4,
			int response, String description, String warningCorrectResponse, DaoQuestion daoQuestion) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.prop1 = prop1;
		this.prop2 = prop2;
		this.prop3 = prop3;
		this.prop4 = prop4;
		this.response = response;
		this.description = description;
		this.warningCorrectResponse = warningCorrectResponse;
		this.daoQuestion = daoQuestion;
	}


	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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


	public String getWarningCorrectResponse() {
		return warningCorrectResponse;
	}


	public void setWarningCorrectResponse(String warningCorrectResponse) {
		this.warningCorrectResponse = warningCorrectResponse;
	}


	public DaoQuestion getDaoQuestion() {
		return daoQuestion;
	}


	public void setDaoQuestion(DaoQuestion daoQuestion) {
		this.daoQuestion = daoQuestion;
	}


	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", prop1=" + prop1 + ", prop2=" + prop2
				+ ", prop3=" + prop3 + ", prop4=" + prop4 + ", response=" + response + ", description=" + description
				+ ", warningCorrectResponse=" + warningCorrectResponse + ", daoQuestion=" + daoQuestion + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
