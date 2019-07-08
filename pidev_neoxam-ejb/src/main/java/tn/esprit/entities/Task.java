package tn.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@XmlRootElement
public class Task implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String discription;
	private Date started;
	private Date finished;
	private TaskStatus status;
	private Priority priority;
	@ManyToOne (fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="FK_PROJECT_ID")
	Project project;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="FK_EMP_ID")
	Employee employee;
	
	private static final long serialVersionUID = 1L;

	public Task() {
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
	public Date getStarted() {
		return this.started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}   
	public Date getFinished() {
		return this.finished;
	}

	public void setFinished(Date finished) {
		this.finished = finished;
	}   
	public TaskStatus getStatus() {
		return this.status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
   
}
