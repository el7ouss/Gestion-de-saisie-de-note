package tn.rnu.isetsf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

import tn.rnu.isetsf.model.Role;
import tn.rnu.isetsf.model.Utilisateur;

/**
 * Session Bean implementation class RoleDAO
 */
@SuppressWarnings("serial")
// @LocalBean
@Stateless
public class RoleDAO implements RoleDAORemote, RoleDAOLocal, Serializable {

	@PersistenceContext
	EntityManager em;

	public void save(Role role) {
		em.persist(role);

	}

	public void delete(Role role) {
		em.remove(em.merge(role));

	}

	public Role getById(Long id) {

		return em.find(Role.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Role> getAll() {
		Query q = em.createQuery("SELECT OBJECT(role) FROM Role role");
		return (List<Role>) q.getResultList();
	}

	public void edit(Role role) {
		em.merge(role);
		em.flush();

	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAllUtilisateur(Role role) {
		Query q = em
				.createQuery("SELECT OBJECT(user) FROM Utilisateur user WHERE user.role=:role_id");
		q.setParameter("role_id", role);
		return (List<Utilisateur>) q.getResultList();
	}
}
