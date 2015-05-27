package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tn.rnu.isetsf.dto.DepartementDTO;
import tn.rnu.isetsf.dto.FormationDTO;
import tn.rnu.isetsf.model.Departement;
import tn.rnu.isetsf.model.Formation;

@SuppressWarnings("serial")
public class DepartementHelper implements Serializable {
	public static DepartementDTO modelToDTO(Departement departement) {
		DepartementDTO departementDto = new DepartementDTO();
		if (departement.getDescription() != null)
			departementDto.setDescription(departement.getDescription());
		if (departement.getDesignation() != null)
			departementDto.setDesignation(departement.getDesignation());
		if (departement.getCreatedAt() != null)
			departementDto.setCreatedAt(departement.getCreatedAt());
		if (departement.getEnabled() != null)
			departementDto.setEnabled(departement.getEnabled());
		if (departement.getId() != null)
			departementDto.setId(departement.getId());
		if (departement.getUpdatedAt() != null)
			departementDto.setUpdatedAt(departement.getUpdatedAt());
		/*if (departement.getFormations() != null
				&& departement.getFormations().size() > 0) {
			List<Formation> formations = departement.getFormations();
			List<FormationDTO> formationsDto = new ArrayList<FormationDTO>();
			for (Formation formation : formations)
				formationsDto.add(FormationHelper.modelToDTO(formation));
			departementDto.setFormationsDto(formationsDto);
		}*/
		return departementDto;
	}

	public static Departement DTOToModel(DepartementDTO departementDto) {
		Departement departement = new Departement();
		if (departementDto.getDescription() != null)
			departement.setDescription(departementDto.getDescription());
		if (departementDto.getDesignation() != null)
			departement.setDesignation(departementDto.getDesignation());
		if (departementDto.getCreatedAt() != null)
			departement.setCreatedAt(departementDto.getCreatedAt());
		if (departementDto.getEnabled() != null)
			departement.setEnabled(departementDto.getEnabled());
		if (departementDto.getId() != null)
			departement.setId(departementDto.getId());
		if (departementDto.getUpdatedAt() != null)
			departement.setUpdatedAt(departementDto.getUpdatedAt());
		/*if (departementDto.getFormationsDto() != null
				&& departementDto.getFormationsDto().size() > 0) {
			List<Formation> formations = new ArrayList<Formation>();
			List<FormationDTO> formationsDto = departementDto
					.getFormationsDto();
			for (FormationDTO formationDto : formationsDto)
				formations.add(FormationHelper.DTOToModel(formationDto));
			departement.setFormations(formations);
		}*/
		return departement;
	}
}
