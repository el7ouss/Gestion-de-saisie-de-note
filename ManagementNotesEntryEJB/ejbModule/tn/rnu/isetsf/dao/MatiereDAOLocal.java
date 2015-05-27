package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Matiere;

@Local
public interface MatiereDAOLocal {
	public void save(Matiere matiere);

	public Matiere getById(Long id);

	public void delete(Matiere matiere);

	public List<Matiere> getAll();

	public List<Cour> getAllCour(Matiere matiere);

	public void edit(Matiere matiere);

}
