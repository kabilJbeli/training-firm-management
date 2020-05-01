package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the type database table.
 * 
 */
@Entity
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	public Type() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}