package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tn.rnu.isetsf.dto.FormationDTO;
import tn.rnu.isetsf.dto.NiveauDTO;
import tn.rnu.isetsf.model.Formation;
import tn.rnu.isetsf.model.Niveau;

@SuppressWarnings("serial")
public class FormationHelper implements Serializable {
	public static FormationDTO modelToDTO(Formation formation) {
		FormationDTO formationDto = new FormationDTO();
		if (formation.getDescription() != null)
			formationDto.setDescription(formation.getDescription());
		if (formation.getDesignation() != null)
			formationDto.setDesignation(formation.getDesignation());
		if (formation.getCreatedAt() != null)
			formationDto.setCreatedAt(formation.getCreatedAt());
		if (formation.getEnabled() != null)
			formationDto.setEnabled(formation.getEnabled());
		if (formation.getId() != null)
			formationDto.setId(formation.getId());
		if (formation.getUpdatedAt() != null)
			formationDto.setUpdatedAt(formation.getUpdatedAt());
		if (formation.getDepartement() != null)
			formationDto.setDepartementDto(DepartementHelper.modelToDTO(formation
					.getDepartement()));
		/*
		 * if (formation.getNiveaux() != null && formation.getNiveaux().size() >
		 * 0) { List<Niveau> niveaux = formation.getNiveaux(); List<NiveauDTO>
		 * niveauxDto = new ArrayList<NiveauDTO>(); for (Niveau niveau :
		 * niveaux) niveauxDto.add(NiveauHelper.modelToDTO(niveau));
		 * formationDto.setNiveauxDto(niveauxDto); }
		 */
		return formationDto;
	}

	public static Formation DTOToModel(FormationDTO formationDto) {
		Formation formation = new Formation();
		if (formationDto.getDescription() != null)
			formation.setDescription(formationDto.getDescription());
		if (formationDto.getDesignation() != null)
			formation.setDesignation(formationDto.getDesignation());
		if (formationDto.getCreatedAt() != null)
			formation.setCreatedAt(formationDto.getCreatedAt());
		if (formationDto.getEnabled() != null)
			formation.setEnabled(formationDto.getEnabled());
		if (formationDto.getId() != null)
			formation.setId(formationDto.getId());
		if (formationDto.getUpdatedAt() != null)
			formation.setUpdatedAt(formationDto.getUpdatedAt());
		if (formationDto.getDepartementDto() != null)
			formation.setDepartement(DepartementHelper.DTOToModel(formationDto
					.getDepartementDto()));
		/*
		 * if (formationDto.getNiveauxDto() != null &&
		 * formationDto.getNiveauxDto().size() > 0) { List<Niveau> niveaux = new
		 * ArrayList<Niveau>(); List<NiveauDTO> niveauxDto =
		 * formationDto.getNiveauxDto(); for (NiveauDTO niveauDto : niveauxDto)
		 * niveaux.add(NiveauHelper.DTOToModel(niveauDto));
		 * formation.setNiveaux(niveaux); }
		 */
		return formation;
	}
}
