package services;

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

import entities.Don;

public class serviceDonImpl implements serviceDon {

	private entityManagerConexion em = new entityManagerConexion();

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

	public int quantiteAjouté(int codeTyoe) {
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Don don = new Don();
		try {
			tx.begin();
			int quantite = em.getEntityManager().createNativeQuery("select sum(quantity) from don where type=?")
					.setParameter("type", codeTyoe).getFirstResult();
			tx.commit();
			return quantite;
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
			return 0;
		}
	}
	
	public int quantitedesire(int codeTyoe) {
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Don don = new Don();
		try {
			tx.begin();
			int quantite = em.getEntityManager().createNativeQuery("select quantite from type where id=?")
					.setParameter("id", codeTyoe).getFirstResult();
			tx.commit();
			return quantite;
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
			return 0;
		}
	}

	@Override
	public void remove(int code) {

		EntityTransaction tx = em.getEntityManager().getTransaction();
		Don don = new Don();
		try {
			tx.begin();
			don = em.getEntityManager().find(Don.class, code);
			em.getEntityManager().remove(don);
			tx.commit();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
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
		return false;
	}

}
