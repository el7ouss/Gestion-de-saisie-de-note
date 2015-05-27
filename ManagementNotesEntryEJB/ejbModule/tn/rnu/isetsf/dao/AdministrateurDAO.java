package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Administrateur;

/**
 * Session Bean implementation class AdministrateurDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class AdministrateurDAO /* extends UtilisateurDAO */implements
		AdministrateurDAORemote, AdministrateurDAOLocal, Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Administrateur admin) {
		em.persist(admin);

	}

	public void delete(Administrateur admin) {
		em.remove(em.merge(admin));

	}

	public Administrateur getById(Long id) {

		return em.find(Administrateur.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Administrateur> getByUserNamePassword(String userName,
			String password) {
		Query q = em
				.createQuery("SELECT OBJECT(admin) FROM Administrateur admin WHERE admin.userName = :login AND admin.password = :password");
		q.setParameter("login", userName);
		q.setParameter("password", password);
		return (List<Administrateur>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Administrateur> getByUserName(String userName) {
		Query q = em
				.createQuery("SELECT OBJECT(admin) FROM Administrateur admin WHERE admin.userName = :login");
		q.setParameter("login", userName);
		return (List<Administrateur>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Administrateur> getAll() {
		Query q = em
				.createQuery("SELECT OBJECT(admin) FROM Administrateur admin");
		return (List<Administrateur>) q.getResultList();
	}

	public void edit(Administrateur admin) {
		em.merge(admin);
		// em.flush();

	}
}
