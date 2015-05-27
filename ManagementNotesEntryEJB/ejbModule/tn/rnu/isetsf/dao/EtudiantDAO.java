package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Etudiant;
import tn.rnu.isetsf.model.Valeur;

/**
 * Session Bean implementation class EtudiantDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class EtudiantDAO implements EtudiantDAORemote, EtudiantDAOLocal,
		Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Etudiant ens) {
		em.persist(ens);

	}

	public void delete(Etudiant ens) {
		em.remove(em.merge(ens));

	}

	public Etudiant getById(Long id) {

		return em.find(Etudiant.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Etudiant> getByUserNamePassword(String userName, String password) {
		Query q = em
				.createQuery("SELECT OBJECT(etud) FROM Etudiant etud WHERE etud.userName = :login AND etud.password = :password");
		q.setParameter("login", userName);
		q.setParameter("password", password);
		return (List<Etudiant>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Etudiant> getByUserName(String userName) {
		Query q = em
				.createQuery("SELECT OBJECT(etud) FROM Etudiant etud WHERE etud.userName = :login");
		q.setParameter("login", userName);
		return (List<Etudiant>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Etudiant> getByCin(Long cin) {
		Query q = em
				.createQuery("SELECT OBJECT(etud) FROM Etudiant etud WHERE etud.cin = :cin");
		q.setParameter("cin", cin);
		return (List<Etudiant>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Etudiant> getByNumInscrit(Long numInscrit) {
		Query q = em
				.createQuery("SELECT OBJECT(etud) FROM Etudiant etud WHERE etud.numIscrit = :num_iscrit");
		q.setParameter("num_iscrit", numInscrit);
		return (List<Etudiant>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Etudiant> getAll() {
		Query q = em.createQuery("SELECT OBJECT(ens) FROM Etudiant ens");
		return (List<Etudiant>) q.getResultList();
	}

	public void edit(Etudiant ens) {
		em.merge(ens);
		em.flush();

	}

	@SuppressWarnings("unchecked")
	public List<Valeur> getAllValeur(Etudiant etud) {
		Query q = em
				.createQuery("SELECT OBJECT(valeur) FROM Valeur valeur WHERE valeur.etudiant=:etud_id");
		q.setParameter("etud_id", etud);
		return (List<Valeur>) q.getResultList();
	}
}
