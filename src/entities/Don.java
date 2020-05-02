package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the don database table.
 * 
 */
@Entity
@NamedQuery(name="Don.findAll", query="SELECT d FROM Don d")
public class Don implements Serializable {
	
	public Don(Don d) {
		super();
		this.id =  d.getId();
		this.Description = d.getDonType();
		this.doncol = d.getDoncol();
		this.quantity = d.getQuantity();
	}

	
	public Don(int id, int donType, String doncol, int quantity) {
		super();
		this.id = id;
		this.Description = donType;
		this.doncol = doncol;
		this.quantity = quantity;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int Description;
	private String doncol;
	private int quantity;
	@OneToOne
	private Type type;
	private String affectation;

	public String getAffectation() {
		return affectation;
	}


	public void setAffectation(String affectation) {
		this.affectation = affectation;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Don() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDonType() {
		return this.Description;
	}

	public void setDonType(int donType) {
		this.Description = donType;
	}

	public String getDoncol() {
		return this.doncol;
	}

	public void setDoncol(String doncol) {
		this.doncol = doncol;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}