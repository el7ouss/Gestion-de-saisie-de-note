package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import tn.rnu.isetsf.dto.AdministrateurDTO;
import tn.rnu.isetsf.model.Administrateur;

@SuppressWarnings("serial")
public class AdministrateurHelper implements Serializable {
	public static AdministrateurDTO modelToDTO(Administrateur admin) {
		AdministrateurDTO adminDto = new AdministrateurDTO();
		if (admin.getCreatedAt() != null)
			adminDto.setCreatedAt(admin.getCreatedAt());
		if (admin.getEmail() != null)
			adminDto.setEmail(admin.getEmail());
		if (admin.getEnabled() != null)
			adminDto.setEnabled(admin.getEnabled());
		if (admin.getId() != null)
			adminDto.setId(admin.getId());
		if (admin.getLastName() != null)
			adminDto.setLastName(admin.getLastName());
		if (admin.getName() != null)
			adminDto.setName(admin.getName());
		if (admin.getPassword() != null)
			adminDto.setPassword(admin.getPassword());
		if (admin.getUpdatedAt() != null)
			adminDto.setUpdatedAt(admin.getUpdatedAt());
		if (admin.getUserName() != null)
			adminDto.setUserName(admin.getUserName());
		if (admin.getPoste() != null)
			adminDto.setPoste(admin.getPoste());
		if (admin.getRole() != null)
			adminDto.setRoleDto(RoleHelper.modelToDTO(admin.getRole()));
		return adminDto;
	}

	public static Administrateur DTOToModel(AdministrateurDTO adminDto) {
		Administrateur admin = new Administrateur();
		if (adminDto.getCreatedAt() != null)
			admin.setCreatedAt(adminDto.getCreatedAt());
		if (adminDto.getEmail() != null)
			admin.setEmail(adminDto.getEmail());
		if (adminDto.getEnabled() != null)
			admin.setEnabled(adminDto.getEnabled());
		if (adminDto.getId() != null)
			admin.setId(adminDto.getId());
		if (adminDto.getLastName() != null)
			admin.setLastName(adminDto.getLastName());
		if (adminDto.getName() != null)
			admin.setName(adminDto.getName());
		if (adminDto.getPassword() != null)
			admin.setPassword(adminDto.getPassword());
		if (adminDto.getUpdatedAt() != null)
			admin.setUpdatedAt(adminDto.getUpdatedAt());
		if (adminDto.getUserName() != null)
			admin.setUserName(adminDto.getUserName());
		if (adminDto.getPoste() != null)
			admin.setPoste(adminDto.getPoste());
		if (adminDto.getRoleDto() != null)
			admin.setRole(RoleHelper.DTOToModel(adminDto.getRoleDto()));
		return admin;
	}
}
