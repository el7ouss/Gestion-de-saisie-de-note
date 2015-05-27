package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Note;
import tn.rnu.isetsf.model.Valeur;

/**
 * Session Bean implementation class NoteDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class NoteDAO implements NoteDAORemote, NoteDAOLocal, Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Note note) {
		em.persist(note);

	}

	public void delete(Note note) {
		em.remove(em.merge(note));

	}

	public Note getById(Long id) {

		return em.find(Note.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Note> getAll() {
		Query q = em.createQuery("SELECT OBJECT(note) FROM Note note");
		return (List<Note>) q.getResultList();
	}

	public void edit(Note note) {
		em.merge(note);
		em.flush();

	}

	@SuppressWarnings("unchecked")
	public List<Valeur> getAllValeur(Note note) {
		Query q = em
				.createQuery("SELECT OBJECT(valeur) FROM Valeur valeur WHERE valeur.note=:note_id");
		q.setParameter("note_id", note);
		return (List<Valeur>) q.getResultList();
	}
}
