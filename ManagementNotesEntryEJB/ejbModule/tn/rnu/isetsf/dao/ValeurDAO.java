package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Valeur;

/**
 * Session Bean implementation class ValeurDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class ValeurDAO implements ValeurDAORemote, ValeurDAOLocal, Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Valeur valeur) {
		em.persist(valeur);

	}

	public void delete(Valeur valeur) {
		em.remove(em.merge(valeur));

	}

	public Valeur getById(Long id) {

		return em.find(Valeur.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Valeur> getAll() {
		Query q = em.createQuery("SELECT OBJECT(valeur) FROM Valeur valeur");
		return (List<Valeur>) q.getResultList();
	}

	public void edit(Valeur valeur) {
		em.merge(valeur);
		em.flush();

	}
}
