package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.model.Formation;
import tn.rnu.isetsf.model.Niveau;

@Remote
public interface FormationDAORemote {
	public void save(Formation formation);

	public Formation getById(Long id);

	public void delete(Formation formation);

	public List<Formation> getAll();

	public List<Niveau> getAllNiveau(Formation formation);

	public void edit(Formation formation);

}
