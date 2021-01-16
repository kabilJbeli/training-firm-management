package com.managament.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Matiere.findAll", query="SELECT m FROM Matiere m")

public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	 private String name; 
	 private String theme;
	 
	 private int employee;
	 private String salle;
	

	public Matiere(String name, String theme, int employee, String salle) {
		super();
		this.name = name;
		this.theme = theme;
		this.employee = employee;
		this.salle = salle;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}
	public int getEmployee() {
		return this.employee;
	}


	public void setSalle(String salle) {
		this.salle = salle;
	}
	public String getSalle() {
		return this.salle;
	}
	
	
	

	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getTheme() {
		return this.theme;
	}

	public int getId() {
	    return id;
	}

	 

	public void setId(int id) {
	    this.id = id;
	}

	 

	public String getName() {
	    return name;
	}

	 

	public void setName(String name) {
	    this.name = name;
	}

	 

	 



}
