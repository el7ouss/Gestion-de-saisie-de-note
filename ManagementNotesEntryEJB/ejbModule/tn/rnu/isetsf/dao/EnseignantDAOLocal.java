package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Enseignant;

@Local
public interface EnseignantDAOLocal {
	public void save(Enseignant ens);

	public Enseignant getById(Long id);

	public List<Enseignant> getByUserNamePassword(String userName,
			String password);

	public List<Enseignant> getByUserName(String userName);

	public void delete(Enseignant ens);

	public List<Enseignant> getAll();

	public List<Cour> getAllCour(Enseignant ens);

	public void edit(Enseignant ens);

}
