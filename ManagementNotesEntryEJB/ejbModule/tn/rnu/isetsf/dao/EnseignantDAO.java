package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Enseignant;

/**
 * Session Bean implementation class EnseignantDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class EnseignantDAO implements EnseignantDAORemote, EnseignantDAOLocal,
		Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Enseignant ens) {
		em.persist(ens);

	}

	public void delete(Enseignant ens) {
		em.remove(em.merge(ens));

	}

	public Enseignant getById(Long id) {

		return em.find(Enseignant.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Enseignant> getByUserNamePassword(String userName,
			String password) {
		Query q = em
				.createQuery("SELECT OBJECT(ens) FROM Enseignant ens WHERE ens.userName = :login AND ens.password = :password");
		q.setParameter("login", userName);
		q.setParameter("password", password);
		return (List<Enseignant>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Enseignant> getByUserName(String userName) {
		Query q = em
				.createQuery("SELECT OBJECT(ens) FROM Enseignant ens WHERE ens.userName = :login");
		q.setParameter("login", userName);
		return (List<Enseignant>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Enseignant> getAll() {
		Query q = em.createQuery("SELECT OBJECT(ens) FROM Enseignant ens");
		return (List<Enseignant>) q.getResultList();
	}

	public void edit(Enseignant ens) {
		em.merge(ens);
		em.flush();

	}

	@SuppressWarnings("unchecked")
	public List<Cour> getAllCour(Enseignant ens) {
		Query q = em
				.createQuery("SELECT OBJECT(cour) FROM Cour cour WHERE cour.enseignant=:ens_id");
		q.setParameter("ens_id", ens);
		return (List<Cour>) q.getResultList();
	}
}
