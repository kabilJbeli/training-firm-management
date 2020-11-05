package com.don.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Benificiere
 *
 */
@Entity

public class Benificiere implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IdBenificier;
	private String LibBenificiere;
	private boolean ZoneRurale;
	private boolean ZoneInterne;
	private boolean ExistSegCovid;
	private boolean BlocREA;
	private static final long serialVersionUID = 1L;

	public Benificiere() {
		super();
	}   
	public int getIdBenificier() {
		return this.IdBenificier;
	}

	public void setIdBenificier(int IdBenificier) {
		this.IdBenificier = IdBenificier;
	}   
	public String getLibBenificiere() {
		return this.LibBenificiere;
	}

	public void setLibBenificiere(String LibBenificiere) {
		this.LibBenificiere = LibBenificiere;
	}   
	public boolean getZoneRurale() {
		return this.ZoneRurale;
	}

	public void setZoneRurale(boolean ZoneRurale) {
		this.ZoneRurale = ZoneRurale;
	}   
	public boolean getZoneInterne() {
		return this.ZoneInterne;
	}

	public void setZoneInterne(boolean ZoneInterne) {
		this.ZoneInterne = ZoneInterne;
	}   
	public boolean getExistSegCovid() {
		return this.ExistSegCovid;
	}

	public void setExistSegCovid(boolean ExistSegCovid) {
		this.ExistSegCovid = ExistSegCovid;
	}   
	public boolean getBlocREA() {
		return this.BlocREA;
	}

	public void setBlocREA(boolean BlocREA) {
		this.BlocREA = BlocREA;
	}
   
}
