package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Matiere;

/**
 * Session Bean implementation class MatiereDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class MatiereDAO implements MatiereDAORemote, MatiereDAOLocal,
		Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Matiere matiere) {
		em.persist(matiere);

	}

	public void delete(Matiere matiere) {
		em.remove(em.merge(matiere));

	}

	public Matiere getById(Long id) {

		return em.find(Matiere.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Matiere> getAll() {
		Query q = em.createQuery("SELECT OBJECT(matiere) FROM Matiere matiere");
		return (List<Matiere>) q.getResultList();
	}

	public void edit(Matiere matiere) {
		em.merge(matiere);
		em.flush();

	}

	@SuppressWarnings("unchecked")
	public List<Cour> getAllCour(Matiere matiere) {
		Query q = em
				.createQuery("SELECT OBJECT(cour) FROM Cour cour WHERE cour.matiere=:matiere_id");
		q.setParameter("matiere_id", matiere);
		return (List<Cour>) q.getResultList();
	}
}
