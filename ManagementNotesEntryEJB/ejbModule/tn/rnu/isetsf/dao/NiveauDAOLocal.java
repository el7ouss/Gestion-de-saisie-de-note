package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Etudiant;
import tn.rnu.isetsf.model.Niveau;

@Local
public interface NiveauDAOLocal {
	public void save(Niveau niveau);

	public Niveau getById(Long id);

	public void delete(Niveau niveau);

	public List<Niveau> getAll();

	public List<Cour> getAllCour(Niveau niveau);

	public List<Etudiant> getAllEtudiant(Niveau niveau);

	public void edit(Niveau niveau);

}
