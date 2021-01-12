package com.managament.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the don database table.
 * 
 */
@Entity
@NamedQuery(name="Don.findAll", query="SELECT d FROM Don d")
@XmlRootElement
public class Don implements Serializable {
	

	public Don() {
		super();
	}
	
	public Don(String description, String doncol, int quantity, Type type, String affectation) {
		super();
		Description = description;
		this.type = type;
		this.affectation = affectation;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Description;
	private int quantity;
	@OneToOne
	private Type type;
	private String affectation;
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getDescription() {
		return Description;
	}




	public void setDescription(String description) {
		Description = description;
	}






	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public Type getType() {
		return type;
	}




	public void setType(Type type) {
		this.type = type;
	}




	public String getAffectation() {
		return affectation;
	}




	public void setAffectation(String affectation) {
		this.affectation = affectation;
	}



}