package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Utilisateur;

/**
 * Session Bean implementation class UtilisateurDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class UtilisateurDAO implements UtilisateurDAORemote,
		UtilisateurDAOLocal, Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Utilisateur user) {
		em.persist(user);

	}

	public void delete(Utilisateur user) {
		em.remove(em.merge(user));

	}

	public Utilisateur getById(Long id) {

		return em.find(Utilisateur.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> getByUserNamePassword(String userName,
			String password) {
		Query q = em
				.createQuery("SELECT OBJECT(user) FROM Utilisateur user WHERE user.userName = :login AND user.password = :password");
		q.setParameter("login", userName);
		q.setParameter("password", password);
		return (List<Utilisateur>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> getByUserName(String userName) {
		Query q = em
				.createQuery("SELECT OBJECT(user) FROM Utilisateur user WHERE user.userName = :login");
		q.setParameter("login", userName);
		return (List<Utilisateur>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAll() {
		Query q = em.createQuery("SELECT OBJECT(user) FROM Utilisateur user");
		return (List<Utilisateur>) q.getResultList();
	}

	public void edit(Utilisateur user) {
		em.merge(user);
		em.flush();

	}
}
