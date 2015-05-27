package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Departement;
import tn.rnu.isetsf.model.Formation;

/**
 * Session Bean implementation class DepartementDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class DepartementDAO implements DepartementDAORemote,
		DepartementDAOLocal, Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Departement departement) {
		em.persist(departement);

	}

	public void delete(Departement departement) {
		em.remove(em.merge(departement));

	}

	public Departement getById(Long id) {

		return em.find(Departement.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Departement> getAll() {
		Query q = em
				.createQuery("SELECT OBJECT(departement) FROM Departement departement");
		return (List<Departement>) q.getResultList();
	}

	public void edit(Departement departement) {
		em.merge(departement);
		em.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Formation> getAllFormation(Departement departement) {
		Query q = em
				.createQuery("SELECT OBJECT(formation) FROM Formation formation WHERE formation.departement=:departement_id");
		q.setParameter("departement_id", departement);
		return (List<Formation>) q.getResultList();
	}
}
