package tn.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@XmlRootElement
public class Project implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String discription;
	private Date started;
	private Date finished;
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="project")
	private Set<Task> tasks = new HashSet<Task>();
	
	public Project() {
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
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
   
}
