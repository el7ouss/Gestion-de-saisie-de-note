package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tn.rnu.isetsf.dto.RoleDTO;
import tn.rnu.isetsf.dto.UtilisateurDTO;
import tn.rnu.isetsf.model.Role;
import tn.rnu.isetsf.model.Utilisateur;

@SuppressWarnings("serial")
public class RoleHelper implements Serializable {
	public static RoleDTO modelToDTO(Role role) {
		RoleDTO roleDto = new RoleDTO();
		if (role.getDescription() != null)
			roleDto.setDescription(role.getDescription());
		if (role.getDesignation() != null)
			roleDto.setDesignation(role.getDesignation());
		if (role.getCreatedAt() != null)
			roleDto.setCreatedAt(role.getCreatedAt());
		if (role.getEnabled() != null)
			roleDto.setEnabled(role.getEnabled());
		if (role.getId() != null)
			roleDto.setId(role.getId());
		if (role.getUpdatedAt() != null)
			roleDto.setUpdatedAt(role.getUpdatedAt());
		/*if (role.getUsers() != null && role.getUsers().size() > 0) {
			List<Utilisateur> users = role.getUsers();
			List<UtilisateurDTO> usersDto = new ArrayList<UtilisateurDTO>();
			for (Utilisateur user : users)
				usersDto.add(UtilisateurHelper.modelToDTO(user));
			roleDto.setUsersDto(usersDto);
		}*/
		return roleDto;
	}

	public static Role DTOToModel(RoleDTO roleDto) {
		Role role = new Role();
		if (roleDto.getDescription() != null)
			role.setDescription(roleDto.getDescription());
		if (roleDto.getDesignation() != null)
			role.setDesignation(roleDto.getDesignation());
		if (roleDto.getCreatedAt() != null)
			role.setCreatedAt(roleDto.getCreatedAt());
		if (roleDto.getEnabled() != null)
			role.setEnabled(roleDto.getEnabled());
		if (roleDto.getId() != null)
			role.setId(roleDto.getId());
		if (roleDto.getUpdatedAt() != null)
			role.setUpdatedAt(roleDto.getUpdatedAt());
		/*if (roleDto.getUsersDto() != null && roleDto.getUsersDto().size() > 0) {
			List<Utilisateur> users = new ArrayList<Utilisateur>();
			List<UtilisateurDTO> usersDto = roleDto.getUsersDto();
			for (UtilisateurDTO userDto : usersDto)
				users.add(UtilisateurHelper.DTOToModel(userDto));
			role.setUsers(users);
		}*/
		return role;
	}
}
