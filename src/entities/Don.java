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
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="DON_TYPE")
	private int donType;

	private String doncol;

	private int quantity;

	public Don() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDonType() {
		return this.donType;
	}

	public void setDonType(int donType) {
		this.donType = donType;
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