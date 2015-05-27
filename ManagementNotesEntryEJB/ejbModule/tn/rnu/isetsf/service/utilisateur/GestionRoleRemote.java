package tn.rnu.isetsf.service.utilisateur;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.RoleDTO;
import tn.rnu.isetsf.dto.UtilisateurDTO;

@Remote
public interface GestionRoleRemote {
	public void creerRole(RoleDTO roleDto);

	public RoleDTO getRoleById(Long id);

	public List<RoleDTO> getRoles();

	public List<UtilisateurDTO> getUtilisateursOfRole(RoleDTO roleDto);

	public void modifierRole(RoleDTO roleDto);

}
