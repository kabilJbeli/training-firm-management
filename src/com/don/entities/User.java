package com.don.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IDUSER;
	private String Name;
	private String SURNAME;
	private String CIN;
	private Date BirthDate;
	@Enumerated(EnumType.STRING)
    @Column(length = 20)
	private UserRole UserRole;
	
	public UserRole getUserRole() {
		return UserRole;
	}
	public void setUserRole(UserRole userRole) {
		UserRole = userRole;
	}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public int getIDUSER() {
		return this.IDUSER;
	}

	public void setIDUSER(int IDUSER) {
		this.IDUSER = IDUSER;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	public String getSURNAME() {
		return this.SURNAME;
	}

	public void setSURNAME(String SURNAME) {
		this.SURNAME = SURNAME;
	}   
	public String getCIN() {
		return this.CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}   
	public Date getBirthDate() {
		return this.BirthDate;
	}

	public void setBirthDate(Date BirthDate) {
		this.BirthDate = BirthDate;
	}   

	

   
}
