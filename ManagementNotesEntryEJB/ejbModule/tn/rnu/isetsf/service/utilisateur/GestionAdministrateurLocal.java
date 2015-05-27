package tn.rnu.isetsf.service.utilisateur;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.dto.AdministrateurDTO;

@Local
public interface GestionAdministrateurLocal {
	public void creerAdministrateur(AdministrateurDTO adminDto);

	public AdministrateurDTO getAdministrateurById(Long id);

	public AdministrateurDTO getAdministrateurByUserNamePassword(
			String userName, String password);

	public AdministrateurDTO getAdministrateurByUserName(String userName);

	public Boolean findAdministrateurByUserName(String userName);

	public List<AdministrateurDTO> getAdministrateurs();

	public void modifierAdministrateur(AdministrateurDTO adminDto);
}
