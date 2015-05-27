package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.model.Valeur;

@Remote
public interface ValeurDAORemote {
	public void save(Valeur valeur);

	public Valeur getById(Long id);

	public void delete(Valeur valeur);

	public List<Valeur> getAll();

	public void edit(Valeur valeur);

}
