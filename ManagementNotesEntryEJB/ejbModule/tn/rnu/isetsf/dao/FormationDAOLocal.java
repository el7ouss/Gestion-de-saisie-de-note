package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.model.Formation;
import tn.rnu.isetsf.model.Niveau;

@Local
public interface FormationDAOLocal {
	public void save(Formation formation);

	public Formation getById(Long id);

	public void delete(Formation formation);

	public List<Formation> getAll();

	public List<Niveau> getAllNiveau(Formation formation);

	public void edit(Formation formation);

}
