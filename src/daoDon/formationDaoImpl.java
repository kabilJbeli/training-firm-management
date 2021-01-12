package daoDon;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Don;
import entities.Formation;

public class formationDaoImpl implements formationDao {
	public formationDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	private entityManagerConexion em = new entityManagerConexion();

	@Override
	public Formation add(Formation form) {
		// TODO Auto-generated method stub
		Formation f = new Formation();
		try {
			EntityTransaction tx = em.getEntityManager().getTransaction();
			tx.begin();
			em.getEntityManager().persist(form);
			tx.commit();
			f = em.getEntityManager().find(Formation.class, form.getId());

		} catch (IllegalStateException e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return f;
	}

	@Override
	public void remove(int code) {
		// TODO Auto-generated method stub


		EntityTransaction tx = em.getEntityManager().getTransaction();
		try {
			tx.begin();
			Formation f = em.getEntityManager().find(Formation.class, code);
			if(f != null) {
		    em.getEntityManager().remove(f);
			}else {
				System.out.println("The requested Don entity with the following ID "+code+" Doesn't exist in the database");
			}
			tx.commit();

		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
	}

	@Override
	public List<Formation> findAll() {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		List<Formation> Forms = new ArrayList<Formation>();

		try {
			tx.begin();
			Query query = em.getEntityManager().createNativeQuery("SELECT * FROM center.Formation;");
			Forms = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return Forms;
	}

	@Override
	public Formation find(int code) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Formation f = new Formation();
		try {
			tx.begin();
			f = em.getEntityManager().find(Formation.class, code);
			tx.commit();
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return f;
	}

	@Override
	public boolean update(Formation form) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getEntityManager().getTransaction();
		Boolean isupdated = false;
		try {
			tx.begin();
			form = em.getEntityManager().merge(form);
			Formation searchedForm = em.getEntityManager().find(Formation.class, form.getId());
			tx.commit();
			isupdated = form.equals(searchedForm);
		} catch (Exception e) {
			em.getEntityManager().getTransaction().rollback();
			em.getEntityManager().close();
		}
		return isupdated;
	}

}
