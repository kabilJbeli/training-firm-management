package com.don.entities;

import com.don.entities.Type;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: NeedBenificiere
 *
 */
@Entity

public class NeedBenificiere implements Serializable {

	   
	@Id
	private int IDNEED;
	@ManyToOne
	private Type IDTYPE;
	private int Quantity;
	private static final long serialVersionUID = 1L;

	public NeedBenificiere() {
		super();
	}   
	public int getIDNEED() {
		return this.IDNEED;
	}

	public void setIDNEED(int IDNEED) {
		this.IDNEED = IDNEED;
	}   
	public Type getIDTYPE() {
		return this.IDTYPE;
	}

	public void setIDTYPE(Type IDTYPE) {
		this.IDTYPE = IDTYPE;
	}   
	public int getQuantity() {
		return this.Quantity;
	}

	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}
   
}
