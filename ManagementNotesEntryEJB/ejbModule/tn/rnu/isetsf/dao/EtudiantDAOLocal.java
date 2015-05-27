package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.model.Etudiant;
import tn.rnu.isetsf.model.Valeur;

@Local
public interface EtudiantDAOLocal {
	public void save(Etudiant etud);

	public void delete(Etudiant etud);

	public List<Etudiant> getAll();

	public List<Etudiant> getByUserNamePassword(String userName, String password);

	public List<Etudiant> getByUserName(String userName);

	public List<Etudiant> getByCin(Long cin);

	public List<Etudiant> getByNumInscrit(Long numInscrit);

	public void edit(Etudiant etud);

	public List<Valeur> getAllValeur(Etudiant etud);

	public Etudiant getById(Long id);

}
