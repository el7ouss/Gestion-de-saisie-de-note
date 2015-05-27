package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.model.Role;
import tn.rnu.isetsf.model.Utilisateur;

@Remote
public interface RoleDAORemote {
	public void save(Role role);

	public Role getById(Long id);

	public void delete(Role role);

	public List<Role> getAll();

	public List<Utilisateur> getAllUtilisateur(Role role);

	public void edit(Role role);

}
