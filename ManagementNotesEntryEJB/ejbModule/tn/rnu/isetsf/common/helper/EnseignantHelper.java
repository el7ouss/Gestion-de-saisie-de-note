package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.EnseignantDTO;
import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Enseignant;

@SuppressWarnings("serial")
public class EnseignantHelper implements Serializable {

	public static EnseignantDTO modelToDTO(Enseignant ens) {
		EnseignantDTO ensDto = new EnseignantDTO();
		if (ens.getCreatedAt() != null)
			ensDto.setCreatedAt(ens.getCreatedAt());
		if (ens.getEmail() != null)
			ensDto.setEmail(ens.getEmail());
		if (ens.getEnabled() != null)
			ensDto.setEnabled(ens.getEnabled());
		if (ens.getId() != null)
			ensDto.setId(ens.getId());
		if (ens.getLastName() != null)
			ensDto.setLastName(ens.getLastName());
		if (ens.getName() != null)
			ensDto.setName(ens.getName());
		if (ens.getPassword() != null)
			ensDto.setPassword(ens.getPassword());
		if (ens.getUpdatedAt() != null)
			ensDto.setUpdatedAt(ens.getUpdatedAt());
		if (ens.getUserName() != null)
			ensDto.setUserName(ens.getUserName());
		if (ens.getTitre() != null)
			ensDto.setTitre(ens.getTitre());
		if (ens.getRole() != null)
			ensDto.setRoleDto(RoleHelper.modelToDTO(ens.getRole()));
		/*if (ens.getCours() != null && ens.getCours().size() > 0) {
			List<Cour> cours = ens.getCours();
			List<CourDTO> coursDto = new ArrayList<CourDTO>();
			for (Cour cour : cours)
				coursDto.add(CourHelper.modelToDTO(cour));
			ensDto.setCoursDto(coursDto);
		}*/
		return ensDto;
	}

	public static Enseignant DTOToModel(EnseignantDTO ensDto) {
		Enseignant ens = new Enseignant();
		if (ensDto.getCreatedAt() != null)
			ens.setCreatedAt(ensDto.getCreatedAt());
		if (ensDto.getEmail() != null)
			ens.setEmail(ensDto.getEmail());
		if (ensDto.getEnabled() != null)
			ens.setEnabled(ensDto.getEnabled());
		if (ensDto.getId() != null)
			ens.setId(ensDto.getId());
		if (ensDto.getLastName() != null)
			ens.setLastName(ensDto.getLastName());
		if (ensDto.getName() != null)
			ens.setName(ensDto.getName());
		if (ensDto.getPassword() != null)
			ens.setPassword(ensDto.getPassword());
		if (ensDto.getUpdatedAt() != null)
			ens.setUpdatedAt(ensDto.getUpdatedAt());
		if (ensDto.getUserName() != null)
			ens.setUserName(ensDto.getUserName());
		if (ensDto.getTitre() != null)
			ens.setTitre(ensDto.getTitre());
		if (ensDto.getRoleDto() != null)
			ens.setRole(RoleHelper.DTOToModel(ensDto.getRoleDto()));
		/*if (ensDto.getCoursDto() != null && ensDto.getCoursDto().size() > 0) {
			List<Cour> cours = new ArrayList<Cour>();
			List<CourDTO> coursDto = ensDto.getCoursDto();
			for (CourDTO courDto : coursDto)
				cours.add(CourHelper.DTOToModel(courDto));
			ens.setCours(cours);
		}*/
		return ens;
	}
}
