package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Etudiant;
import tn.rnu.isetsf.model.Niveau;

@Remote
public interface NiveauDAORemote {
	public void save(Niveau niveau);

	public Niveau getById(Long id);

	public void delete(Niveau niveau);

	public List<Niveau> getAll();

	public List<Cour> getAllCour(Niveau niveau);

	public List<Etudiant> getAllEtudiant(Niveau niveau);

	public void edit(Niveau niveau);

}
