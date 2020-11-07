package daoDon;

import java.util.List;

import com.don.entities.Don;

public interface serviceDon {

	public Don add(Don don);
	public void remove(int code);
	public List<Don> findAll();
	public Don find(int code);
	public boolean update(Don don);

	
}
