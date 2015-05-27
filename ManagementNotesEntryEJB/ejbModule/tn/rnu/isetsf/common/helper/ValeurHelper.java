package tn.rnu.isetsf.common.helper;

import java.io.Serializable;

import tn.rnu.isetsf.dto.ValeurDTO;
import tn.rnu.isetsf.model.Valeur;

@SuppressWarnings("serial")
public class ValeurHelper implements Serializable {
	public static ValeurDTO modelToDTO(Valeur valeur) {
		ValeurDTO valeurDto = new ValeurDTO();
		if (valeur.getCreatedAt() != null)
			valeurDto.setCreatedAt(valeur.getCreatedAt());
		if (valeur.getEnabled() != null)
			valeurDto.setEnabled(valeur.getEnabled());
		if (valeur.getId() != null)
			valeurDto.setId(valeur.getId());
		if (valeur.getNumCompostage() != null)
			valeurDto.setNumCompostage(valeur.getNumCompostage());
		if (valeur.getValeurNote() != null)
			valeurDto.setValeurNote(valeur.getValeurNote());
		if (valeur.getUpdatedAt() != null)
			valeurDto.setUpdatedAt(valeur.getUpdatedAt());
		if (valeur.getEtudiant() != null)
			valeurDto.setEtudiantDto(EtudiantHelper.modelToDTO(valeur
					.getEtudiant()));
		if (valeur.getNote() != null)
			valeurDto.setNoteDto(NoteHelper.modelToDTO(valeur.getNote()));
		return valeurDto;
	}

	public static Valeur DTOToModel(ValeurDTO valeurDto) {
		Valeur valeur = new Valeur();
		if (valeurDto.getCreatedAt() != null)
			valeur.setCreatedAt(valeurDto.getCreatedAt());
		if (valeurDto.getEnabled() != null)
			valeur.setEnabled(valeurDto.getEnabled());
		if (valeurDto.getId() != null)
			valeur.setId(valeurDto.getId());
		if (valeurDto.getNumCompostage() != null)
			valeur.setNumCompostage(valeurDto.getNumCompostage());
		if (valeurDto.getValeurNote() != null)
			valeur.setValeurNote(valeurDto.getValeurNote());
		if (valeurDto.getUpdatedAt() != null)
			valeur.setUpdatedAt(valeurDto.getUpdatedAt());
		if (valeurDto.getEtudiantDto() != null)
			valeur.setEtudiant(EtudiantHelper.DTOToModel(valeurDto
					.getEtudiantDto()));
		if (valeurDto.getNoteDto() != null)
			valeur.setNote(NoteHelper.DTOToModel(valeurDto.getNoteDto()));
		return valeur;
	}
}
