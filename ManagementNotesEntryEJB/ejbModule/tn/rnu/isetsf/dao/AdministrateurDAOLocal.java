package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.model.Administrateur;

@Local
public interface AdministrateurDAOLocal {
	public void save(Administrateur admin);

	public Administrateur getById(Long id);

	public List<Administrateur> getByUserNamePassword(String userName,
			String password);

	public List<Administrateur> getByUserName(String userName);

	public void delete(Administrateur admin);

	public List<Administrateur> getAll();

	public void edit(Administrateur admin);

}
