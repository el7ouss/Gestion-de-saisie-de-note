package tn.rnu.isetsf.common.helper;

import java.io.Serializable;

import tn.rnu.isetsf.dto.UtilisateurDTO;
import tn.rnu.isetsf.model.Utilisateur;

@SuppressWarnings("serial")
public class UtilisateurHelper implements Serializable {
	public static UtilisateurDTO modelToDTO(Utilisateur user) {
		UtilisateurDTO userDto = new UtilisateurDTO();
		if (user.getCreatedAt() != null)
			userDto.setCreatedAt(user.getCreatedAt());
		if (user.getEmail() != null)
			userDto.setEmail(user.getEmail());
		if (user.getEnabled() != null)
			userDto.setEnabled(user.getEnabled());
		if (user.getId() != null)
			userDto.setId(user.getId());
		if (user.getLastName() != null)
			userDto.setLastName(user.getLastName());
		if (user.getName() != null)
			userDto.setName(user.getName());
		if (user.getPassword() != null)
			userDto.setPassword(user.getPassword());
		if (user.getUpdatedAt() != null)
			userDto.setUpdatedAt(user.getUpdatedAt());
		if (user.getUserName() != null)
			userDto.setUserName(user.getUserName());
		if (user.getRole() != null)
			userDto.setRoleDto(RoleHelper.modelToDTO(user.getRole()));
		return userDto;
	}

	public static Utilisateur DTOToModel(UtilisateurDTO userDto) {
		Utilisateur user = new Utilisateur();
		if (userDto.getCreatedAt() != null)
			user.setCreatedAt(userDto.getCreatedAt());
		if (userDto.getEmail() != null)
			user.setEmail(userDto.getEmail());
		if (userDto.getEnabled() != null)
			user.setEnabled(userDto.getEnabled());
		if (userDto.getId() != null)
			user.setId(userDto.getId());
		if (userDto.getLastName() != null)
			user.setLastName(userDto.getLastName());
		if (userDto.getName() != null)
			user.setName(userDto.getName());
		if (userDto.getPassword() != null)
			user.setPassword(userDto.getPassword());
		if (userDto.getUpdatedAt() != null)
			user.setUpdatedAt(userDto.getUpdatedAt());
		if (userDto.getUserName() != null)
			user.setUserName(userDto.getUserName());
		if (userDto.getRoleDto() != null)
			user.setRole(RoleHelper.DTOToModel(userDto.getRoleDto()));
		return user;
	}
}
