package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Formation;
import tn.rnu.isetsf.model.Niveau;

/**
 * Session Bean implementation class FormationDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class FormationDAO implements FormationDAORemote, FormationDAOLocal,
		Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Formation formation) {
		em.persist(formation);

	}

	public void delete(Formation formation) {
		em.remove(em.merge(formation));

	}

	public Formation getById(Long id) {

		return em.find(Formation.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Formation> getAll() {
		Query q = em
				.createQuery("SELECT OBJECT(formation) FROM Formation formation");
		return (List<Formation>) q.getResultList();
	}

	public void edit(Formation formation) {
		em.merge(formation);
		em.flush();

	}

	@SuppressWarnings("unchecked")
	public List<Niveau> getAllNiveau(Formation formation) {
		Query q = em
				.createQuery("SELECT OBJECT(niveau) FROM Niveau niveau WHERE niveau.formation=:formation_id");
		q.setParameter("formation_id", formation);
		return (List<Niveau>) q.getResultList();
	}
}
