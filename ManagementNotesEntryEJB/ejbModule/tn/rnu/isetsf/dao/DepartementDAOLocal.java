package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.model.Departement;
import tn.rnu.isetsf.model.Formation;

@Local
public interface DepartementDAOLocal {
	public void save(Departement departement);

	public Departement getById(Long id);

	public void delete(Departement departement);

	public List<Departement> getAll();

	public List<Formation> getAllFormation(Departement departement);

	public void edit(Departement departement);

}
