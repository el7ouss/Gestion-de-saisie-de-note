package tn.rnu.isetsf.service.utilisateur;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.dto.UtilisateurDTO;

@Local
public interface GestionUtilisateurLocal {
	public void creerUtilisateur(UtilisateurDTO userDto);

	public UtilisateurDTO getUtilisateurById(Long id);

	public UtilisateurDTO getUtilisateurByUserNamePassword(String userName,
			String password);

	public UtilisateurDTO getUtilisateurByUserName(String userName);

	public Boolean findUtilisateurByUserName(String userName);

	public List<UtilisateurDTO> getUtilisateurs();

	public void modifierUtilisateur(UtilisateurDTO etudDto);
}