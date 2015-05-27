package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.model.Role;
import tn.rnu.isetsf.model.Utilisateur;

@Local
public interface RoleDAOLocal {
	public void save(Role role);

	public Role getById(Long id);

	public void delete(Role role);

	public List<Role> getAll();

	public List<Utilisateur> getAllUtilisateur(Role role);

	public void edit(Role role);

}
