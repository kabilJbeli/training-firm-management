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
	

	public Don() {
		super();
	}
	
	public Don(int description, String doncol, int quantity, Type type, String affectation) {
		super();
		Description = description;
		this.doncol = doncol;
		this.type = type;
		this.affectation = affectation;
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
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getDescription() {
		return Description;
	}




	public void setDescription(int description) {
		Description = description;
	}




	public String getDoncol() {
		return doncol;
	}




	public void setDoncol(String doncol) {
		this.doncol = doncol;
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