package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.model.Utilisateur;

@Remote
public interface UtilisateurDAORemote {
	public void save(Utilisateur user);

	public Utilisateur getById(Long id);

	public List<Utilisateur> getByUserNamePassword(String userName,
			String password);

	public List<Utilisateur> getByUserName(String userName);

	public void delete(Utilisateur user);

	public List<Utilisateur> getAll();

	public void edit(Utilisateur user);

}
