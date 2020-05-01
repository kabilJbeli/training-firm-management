package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class entityManagerConexion {
	public entityManagerConexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("donManagement");
	EntityManager em = emf.createEntityManager();
    
    public EntityManager getEntityManager() {    	
    	return em;
    }
}
