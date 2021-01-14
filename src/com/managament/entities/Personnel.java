package com.managament.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the don database table.
 * 
 */
@Entity
@NamedQuery(name="Personnel.findAll", query="SELECT d FROM Personnel d")
@XmlRootElement
public class Personnel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Nom;
	private String Prenom;
    @Column(length = 20)
	private Poste poste;
    private double honoraireparheure;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	public double getHonoraireparheure() {
		return honoraireparheure;
	}
	public void setHonoraireparheure(double honoraireparheure) {
		this.honoraireparheure = honoraireparheure;
	}
	public Personnel(int id, String nom, String prenom, Poste poste, double honoraireparheure) {
		super();
		this.id = id;
		Nom = nom;
		Prenom = prenom;
		this.poste = poste;
		this.honoraireparheure = honoraireparheure;
	}
	public Personnel() {
		super();
	}
}

