package com.management.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.managament.entities.Personnel;
import com.managament.entities.Type;

public class PersonnelDao implements PersonnelInterface {

	private entityManagerConexion em = new entityManagerConexion();

	public String removeType(int code) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		String returnContent;
		try {
			tx.begin();
			Query query = em.getEntityManager().createNativeQuery("select * from center.don where TYPE_ID="+code);
			int	NumberOfUsedType = query.getResultList().size();
			System.out.println(NumberOfUsedType+" "+code);
			Type type = em.getEntityManager().find(Type.class, code);
			if(NumberOfUsedType == 0  && type != null) {
		    em.getEntityManager().remove(type);
		    returnContent = "the requested type has been removed with success";
			}else {				 
		    returnContent= "IT's impossible to delete this type as it's being used in an existing donation";
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
	public Personnel add(Personnel personnel) {
		Personnel personne = new Personnel();
		try {
			EntityTransaction tx = em.getEntityManager().getTransaction();
			tx.begin();
			em.getEntityManager().persist(personnel);
			tx.commit();
			personne = em.getEntityManager().find(Personnel.class, personnel.getId());

		} catch (IllegalStateException e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return personne;

	}

	public PersonnelDao() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void remove(int code) {

		EntityTransaction tx = em.getEntityManager().getTransaction();
		try {
			tx.begin();
			Personnel don = em.getEntityManager().find(Personnel.class, code);
			if(don != null) {
		    em.getEntityManager().remove(don);
			}else {
				System.out.println("The requested entity with the following ID "+code+" Doesn't exist in the database");
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
			Query query = em.getEntityManager().createNativeQuery("SELECT * FROM center.type;");
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
	public List<Personnel> findAll() {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		List<Personnel> donsList = new ArrayList<Personnel>();

		try {
			tx.begin();
			Query query = em.getEntityManager().createNativeQuery("SELECT * FROM center.don;");
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
	public Personnel find(int code) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Personnel personnel = new Personnel();
		try {
			tx.begin();
			personnel = em.getEntityManager().find(Personnel.class, code);
			tx.commit();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return personnel;
	}

	@Override
	public boolean update(Personnel perso) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Boolean isupdated = false;
		try {
			tx.begin();
			perso = em.getEntityManager().merge(perso);
			Personnel searchedDon = em.getEntityManager().find(Personnel.class, perso.getId());
			tx.commit();
			isupdated = perso.equals(searchedDon);
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return isupdated;
	}

}
