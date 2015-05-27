package tn.rnu.isetsf.service.utilisateur;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.EtudiantDTO;
import tn.rnu.isetsf.dto.ValeurDTO;

@Remote
public interface GestionEtudiantRemote {
	public void creerEtudiant(EtudiantDTO etudDto);

	public EtudiantDTO getEtudiantById(Long id);

	public EtudiantDTO getEtudiantByUserNamePassword(String userName,
			String password);

	public EtudiantDTO getEtudiantByUserName(String userName);

	public Boolean findEtudiantByUserName(String userName);

	public EtudiantDTO getEtudiantByCin(Long cin);

	public EtudiantDTO getEtudiantByNumInscrit(Long numInscrit);

	public List<EtudiantDTO> getEtudiants();

	public List<ValeurDTO> getValeursOfEtudiant(EtudiantDTO etudiantDto);

	public void modifierEtudiant(EtudiantDTO etudDto);

}
