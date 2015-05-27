package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tn.rnu.isetsf.dto.NoteDTO;
import tn.rnu.isetsf.dto.ValeurDTO;
import tn.rnu.isetsf.model.Note;
import tn.rnu.isetsf.model.Valeur;

@SuppressWarnings("serial")
public class NoteHelper implements Serializable {
	public static NoteDTO modelToDTO(Note note) {
		NoteDTO noteDto = new NoteDTO();
		if (note.getCreatedAt() != null)
			noteDto.setCreatedAt(note.getCreatedAt());
		if (note.getEnabled() != null)
			noteDto.setEnabled(note.getEnabled());
		if (note.getId() != null)
			noteDto.setId(note.getId());
		if (note.getDesignation() != null)
			noteDto.setDesignation(note.getDesignation());
		if (note.getCoefficient() != null)
			noteDto.setCoefficient(note.getCoefficient());
		if (note.getSession() != null)
			noteDto.setSession(note.getSession());
		if (note.getUpdatedAt() != null)
			noteDto.setUpdatedAt(note.getUpdatedAt());
		if (note.getCour() != null)
			noteDto.setCourDto(CourHelper.modelToDTO(note.getCour()));
		/*if (note.getValeurs() != null && note.getValeurs().size() > 0) {
			List<Valeur> valeurs = note.getValeurs();
			List<ValeurDTO> valeursDto = new ArrayList<ValeurDTO>();
			for (Valeur valeur : valeurs)
				valeursDto.add(ValeurHelper.modelToDTO(valeur));
			noteDto.setValeursDto(valeursDto);
		}*/
		return noteDto;
	}

	public static Note DTOToModel(NoteDTO noteDto) {
		Note note = new Note();
		if (noteDto.getCreatedAt() != null)
			note.setCreatedAt(noteDto.getCreatedAt());
		if (noteDto.getEnabled() != null)
			note.setEnabled(noteDto.getEnabled());
		if (noteDto.getId() != null)
			note.setId(noteDto.getId());
		if (noteDto.getDesignation() != null)
			note.setDesignation(noteDto.getDesignation());
		if (noteDto.getCoefficient() != null)
			note.setCoefficient(noteDto.getCoefficient());
		if (noteDto.getSession() != null)
			note.setSession(noteDto.getSession());
		if (noteDto.getUpdatedAt() != null)
			note.setUpdatedAt(noteDto.getUpdatedAt());
		if (noteDto.getCourDto() != null)
			note.setCour(CourHelper.DTOToModel(noteDto.getCourDto()));
		/*if (noteDto.getValeursDto() != null
				&& noteDto.getValeursDto().size() > 0) {
			List<Valeur> valeurs = new ArrayList<Valeur>();
			List<ValeurDTO> valeursDto = noteDto.getValeursDto();
			for (ValeurDTO valeurDto : valeursDto)
				valeurs.add(ValeurHelper.DTOToModel(valeurDto));
			note.setValeurs(valeurs);
		}*/
		return note;
	}
}
