package tn.rnu.isetsf.service.utilisateur;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.AdministrateurDTO;

@Remote
public interface GestionAdministrateurRemote {
	public void creerAdministrateur(AdministrateurDTO adminDto);

	public AdministrateurDTO getAdministrateurById(Long id);

	public AdministrateurDTO getAdministrateurByUserNamePassword(
			String userName, String password);

	public AdministrateurDTO getAdministrateurByUserName(String userName);

	public Boolean findAdministrateurByUserName(String userName);

	public List<AdministrateurDTO> getAdministrateurs();

	public void modifierAdministrateur(AdministrateurDTO adminDto);
}
