package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Etudiant;
import tn.rnu.isetsf.model.Niveau;

/**
 * Session Bean implementation class NiveauDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class NiveauDAO implements NiveauDAORemote, NiveauDAOLocal, Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Niveau niveau) {
		em.persist(niveau);

	}

	public void delete(Niveau niveau) {
		em.remove(em.merge(niveau));

	}

	public Niveau getById(Long id) {

		return em.find(Niveau.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Niveau> getAll() {
		Query q = em.createQuery("SELECT OBJECT(niveau) FROM Niveau niveau");
		return (List<Niveau>) q.getResultList();
	}

	public void edit(Niveau niveau) {
		em.merge(niveau);
		em.flush();

	}

	@SuppressWarnings("unchecked")
	public List<Cour> getAllCour(Niveau niveau) {
		Query q = em
				.createQuery("SELECT OBJECT(cour) FROM Cour cour WHERE cour.niveau=:niveau_id");
		q.setParameter("niveau_id", niveau);
		return (List<Cour>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Etudiant> getAllEtudiant(Niveau niveau) {
		Query q = em
				.createQuery("SELECT OBJECT(etud) FROM Etudiant etud WHERE etud.niveau=:niveau_id");
		q.setParameter("niveau_id", niveau);
		return (List<Etudiant>) q.getResultList();
	}
}
