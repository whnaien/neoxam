package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
    @Enumerated(EnumType.STRING)
	private Role namePosition;
    
    
	private Date datedebutpos;
	private Date datefinpos;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Role getNamePosition() {
		return namePosition;
	}
	public void setNamePosition(Role namePosition) {
		this.namePosition = namePosition;
	}
	public Date getDatedebutpos() {
		return datedebutpos;
	}
	public void setDatedebutpos(Date datedebutpos) {
		this.datedebutpos = datedebutpos;
	}
	public Date getDatefinpos() {
		return datefinpos;
	}
	public void setDatefinpos(Date datefinpos) {
		this.datefinpos = datefinpos;
	}
	
	
	
	

}
