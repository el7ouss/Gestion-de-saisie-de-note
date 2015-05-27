package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Note;

/**
 * Session Bean implementation class CourDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class CourDAO implements CourDAORemote, CourDAOLocal, Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Cour cour) {
		em.persist(cour);

	}

	public void delete(Cour cour) {
		em.remove(em.merge(cour));

	}

	public Cour getById(Long id) {

		return em.find(Cour.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Cour> getAll() {
		Query q = em.createQuery("SELECT OBJECT(cour) FROM Cour cour");
		return (List<Cour>) q.getResultList();
	}

	public void edit(Cour cour) {
		em.merge(cour);
		em.flush();

	}

	@SuppressWarnings("unchecked")
	public List<Note> getAllNote(Cour cour) {
		Query q = em
				.createQuery("SELECT OBJECT(note) FROM Note note WHERE note.cour=:cour_id");
		q.setParameter("cour_id", cour);
		return (List<Note>) q.getResultList();
	}
}
