package tn.rnu.isetsf.service.utilisateur;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.dto.RoleDTO;
import tn.rnu.isetsf.dto.UtilisateurDTO;

@Local
public interface GestionRoleLocal {
	public void creerRole(RoleDTO roleDto);

	public RoleDTO getRoleById(Long id);

	public List<RoleDTO> getRoles();

	public List<UtilisateurDTO> getUtilisateursOfRole(RoleDTO roleDto);

	public void modifierRole(RoleDTO roleDto);

}
