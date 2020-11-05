package com.don.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.don.entities.Don;
import com.don.entities.Type;

public class serviceDonImpl implements serviceDon {

	private entityManagerConexion em = new entityManagerConexion();

	public String removeType(int code) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		String returnContent;
		try {
			tx.begin();
			Query query = em.getEntityManager().createNativeQuery("select * from don.don where TYPE_ID="+code);
			int	NumberOfUsedType = query.getResultList().size();
			System.out.println(NumberOfUsedType+" "+code);
			Type type = em.getEntityManager().find(Type.class, code);
			if(NumberOfUsedType == 0  && type != null) {
		    em.getEntityManager().remove(type);
		    returnContent = "the requested type has been removed with success";
			}else {				 
		    returnContent= "It's impossible to delete this type as it's being used in an existing donation";
			}
			tx.commit();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
			returnContent ="An exception has occured";
		}
	    return returnContent;

	}
	
	
	public Type addType(Type type) {
		// TODO Auto-generated method stub
		Type T = new Type();
		try {
			EntityTransaction tx = em.getEntityManager().getTransaction();
			tx.begin();
			em.getEntityManager().persist(type);
			tx.commit();
			T = em.getEntityManager().find(Type.class, type.getId());

		} catch (IllegalStateException e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return T;

	}
	
	
	@Override
	public Don add(Don don) {
		// TODO Auto-generated method stub
		Don d = new Don();
		try {
			EntityTransaction tx = em.getEntityManager().getTransaction();
			tx.begin();
			em.getEntityManager().persist(don);
			tx.commit();
			d = em.getEntityManager().find(Don.class, don.getId());

		} catch (IllegalStateException e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return d;

	}

	public serviceDonImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int quantiteAjouté(int  codeType) {
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Don don = new Don();
		try {
			tx.begin();
			int quantite = em.getEntityManager().createNativeQuery("select sum(quantity) from don.don where type=?")
					.setParameter("type", codeType).getFirstResult();
			tx.commit();
			return quantite;
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
			return 0;
		}
	}
	
	public int quantitedesire(int codeType) {
		EntityTransaction tx = em.getEntityManager().getTransaction();
		List<Type> t = new ArrayList<Type>();
		Don don = new Don();
		try {
			tx.begin();
			Query  query =  em.getEntityManager().createNativeQuery("select * from type where id="+codeType);
			t =  query.getResultList();
			tx.commit();
			return t.get(0).getQuantite();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
			return 0;
		}
	}

	@Override
	public void remove(int code) {

		EntityTransaction tx = em.getEntityManager().getTransaction();
		try {
			tx.begin();
			Don don = em.getEntityManager().find(Don.class, code);
			if(don != null) {
		    em.getEntityManager().remove(don);
			}else {
				System.out.println("The requested Don entity with the following ID "+code+" Doesn't exist in the database");
			}
			tx.commit();

		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}

	}
	
	

	public List<Type> findAllTypes() {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		List<Type> typeList = new ArrayList<Type>();

		try {
			tx.begin();
			Query query = em.getEntityManager().createNativeQuery("SELECT * FROM don.type;");
			typeList = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return typeList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Don> findAll() {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		List<Don> donsList = new ArrayList<Don>();

		try {
			tx.begin();
			Query query = em.getEntityManager().createNativeQuery("SELECT * FROM don.don;");
			donsList = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return donsList;
	}

	
	
	public Type findType(int code) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Type type = new Type();
		try {
			tx.begin();
			type = em.getEntityManager().find(Type.class, code);
			tx.commit();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return type;
	}
	
	@Override
	public Don find(int code) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Don don = new Don();
		try {
			tx.begin();
			don = em.getEntityManager().find(Don.class, code);
			tx.commit();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return don;
	}

	@Override
	public boolean update(Don don) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Boolean isupdated = false;
		try {
			tx.begin();
			don = em.getEntityManager().merge(don);
			Don searchedDon = em.getEntityManager().find(Don.class, don.getId());
			tx.commit();
			isupdated = don.equals(searchedDon);
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return isupdated;
	}

}
