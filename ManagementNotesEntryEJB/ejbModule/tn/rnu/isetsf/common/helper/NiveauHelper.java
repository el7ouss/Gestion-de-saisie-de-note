package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.EtudiantDTO;
import tn.rnu.isetsf.dto.NiveauDTO;
import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Etudiant;
import tn.rnu.isetsf.model.Niveau;

@SuppressWarnings("serial")
public class NiveauHelper implements Serializable {
	public static NiveauDTO modelToDTO(Niveau niveau) {
		NiveauDTO niveauDto = new NiveauDTO();
		if (niveau.getCreatedAt() != null)
			niveauDto.setCreatedAt(niveau.getCreatedAt());
		if (niveau.getDesignation() != null)
			niveauDto.setDesignation(niveau.getDesignation());
		if (niveau.getUpdatedAt() != null)
			niveauDto.setUpdatedAt(niveau.getUpdatedAt());
		if (niveau.getEnabled() != null)
			niveauDto.setEnabled(niveau.getEnabled());
		if (niveau.getId() != null)
			niveauDto.setId(niveau.getId());
		if (niveau.getFormation() != null)
			niveauDto.setFormationDto(FormationHelper.modelToDTO(niveau
					.getFormation()));
		/*if (niveau.getCours() != null && niveau.getCours().size() > 0) {
			List<Cour> cours = niveau.getCours();
			List<CourDTO> coursDto = new ArrayList<CourDTO>();
			for (Cour cour : cours)
				coursDto.add(CourHelper.modelToDTO(cour));
			niveauDto.setCoursDto(coursDto);
		}*/
		/*if (niveau.getEtudiants() != null && niveau.getEtudiants().size() > 0) {
			List<Etudiant> etudiants = niveau.getEtudiants();
			List<EtudiantDTO> etudiantsDto = new ArrayList<EtudiantDTO>();
			for (Etudiant etudiant : etudiants)
				etudiantsDto.add(EtudiantHelper.modelToDTO(etudiant));
			niveauDto.setEtudiantsDto(etudiantsDto);
		}*/
		return niveauDto;
	}

	public static Niveau DTOToModel(NiveauDTO niveauDto) {
		Niveau niveau = new Niveau();
		if (niveauDto.getCreatedAt() != null)
			niveau.setCreatedAt(niveauDto.getCreatedAt());
		if (niveauDto.getDesignation() != null)
			niveau.setDesignation(niveauDto.getDesignation());
		if (niveauDto.getUpdatedAt() != null)
			niveau.setUpdatedAt(niveauDto.getUpdatedAt());
		if (niveauDto.getEnabled() != null)
			niveau.setEnabled(niveauDto.getEnabled());
		if (niveauDto.getId() != null)
			niveau.setId(niveauDto.getId());
		if (niveauDto.getFormationDto() != null)
			niveau.setFormation(FormationHelper.DTOToModel(niveauDto
					.getFormationDto()));
		/*if (niveauDto.getCoursDto() != null
				&& niveauDto.getCoursDto().size() > 0) {
			List<Cour> cours = new ArrayList<Cour>();
			List<CourDTO> coursDto = niveauDto.getCoursDto();
			for (CourDTO courDto : coursDto)
				cours.add(CourHelper.DTOToModel(courDto));
			niveau.setCours(cours);
		}*/
		/*if (niveauDto.getEtudiantsDto() != null
				&& niveauDto.getEtudiantsDto().size() > 0) {
			List<Etudiant> etudiants = new ArrayList<Etudiant>();
			List<EtudiantDTO> etudiantsDto = niveauDto.getEtudiantsDto();
			for (EtudiantDTO etudiantDto : etudiantsDto)
				etudiants.add(EtudiantHelper.DTOToModel(etudiantDto));
			niveau.setEtudiants(etudiants);
		}*/
		return niveau;
	}
}
