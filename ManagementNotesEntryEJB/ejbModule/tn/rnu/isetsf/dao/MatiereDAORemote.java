package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Matiere;

@Remote
public interface MatiereDAORemote {
	public void save(Matiere matiere);

	public Matiere getById(Long id);

	public void delete(Matiere matiere);

	public List<Matiere> getAll();

	public List<Cour> getAllCour(Matiere matiere);

	public void edit(Matiere matiere);

}
