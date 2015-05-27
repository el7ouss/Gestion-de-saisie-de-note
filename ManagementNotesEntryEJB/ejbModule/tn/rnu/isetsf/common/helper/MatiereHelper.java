package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.MatiereDTO;
import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Matiere;

@SuppressWarnings("serial")
public class MatiereHelper implements Serializable {
	public static MatiereDTO modelToDTO(Matiere matiere) {
		MatiereDTO matiereDto = new MatiereDTO();
		if (matiere.getDescription() != null)
			matiereDto.setDescription(matiere.getDescription());
		if (matiere.getDesignation() != null)
			matiereDto.setDesignation(matiere.getDesignation());
		if (matiere.getCreatedAt() != null)
			matiereDto.setCreatedAt(matiere.getCreatedAt());
		if (matiere.getEnabled() != null)
			matiereDto.setEnabled(matiere.getEnabled());
		if (matiere.getId() != null)
			matiereDto.setId(matiere.getId());
		if (matiere.getUpdatedAt() != null)
			matiereDto.setUpdatedAt(matiere.getUpdatedAt());
		/*if (matiere.getCours() != null && matiere.getCours().size() > 0) {
			List<Cour> cours = matiere.getCours();
			List<CourDTO> coursDto = new ArrayList<CourDTO>();
			for (Cour cour : cours)
				coursDto.add(CourHelper.modelToDTO(cour));
			matiereDto.setCoursDto(coursDto);
		}*/
		return matiereDto;
	}

	public static Matiere DTOToModel(MatiereDTO matiereDto) {
		Matiere matiere = new Matiere();
		if (matiereDto.getDescription() != null)
			matiere.setDescription(matiereDto.getDescription());
		if (matiereDto.getDesignation() != null)
			matiere.setDesignation(matiereDto.getDesignation());
		if (matiereDto.getCreatedAt() != null)
			matiere.setCreatedAt(matiereDto.getCreatedAt());
		if (matiereDto.getEnabled() != null)
			matiere.setEnabled(matiereDto.getEnabled());
		if (matiereDto.getId() != null)
			matiere.setId(matiereDto.getId());
		if (matiereDto.getUpdatedAt() != null)
			matiere.setUpdatedAt(matiereDto.getUpdatedAt());
		/*if (matiereDto.getCoursDto() != null
				&& matiereDto.getCoursDto().size() > 0) {
			List<Cour> cours = new ArrayList<Cour>();
			List<CourDTO> coursDto = matiereDto.getCoursDto();
			for (CourDTO courDto : coursDto)
				cours.add(CourHelper.DTOToModel(courDto));
			matiere.setCours(cours);
		}*/
		return matiere;
	}
}
