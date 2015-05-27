package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.NoteDTO;
import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Note;

@SuppressWarnings("serial")
public class CourHelper implements Serializable {
	public static CourDTO modelToDTO(Cour cour) {
		CourDTO courDto = new CourDTO();
		if (cour.getCreatedAt() != null)
			courDto.setCreatedAt(cour.getCreatedAt());
		if (cour.getEnabled() != null)
			courDto.setEnabled(cour.getEnabled());
		if (cour.getId() != null)
			courDto.setId(cour.getId());
		if (cour.getAnneeUniversitaire() != null)
			courDto.setAnneeUniversitaire(cour.getAnneeUniversitaire());
		if (cour.getUpdatedAt() != null)
			courDto.setUpdatedAt(cour.getUpdatedAt());
		if (cour.getEnseignant() != null)
			courDto.setEnseignantDto(EnseignantHelper.modelToDTO(cour
					.getEnseignant()));
		if (cour.getMatiere() != null)
			courDto.setMatiereDto(MatiereHelper.modelToDTO(cour.getMatiere()));
		if (cour.getNiveau() != null)
			courDto.setNiveauDto(NiveauHelper.modelToDTO(cour.getNiveau()));
		/*if (cour.getNotes() != null && cour.getNotes().size() > 0) {
			List<Note> notes = cour.getNotes();
			List<NoteDTO> notesDto = new ArrayList<NoteDTO>();
			for (Note note : notes)
				notesDto.add(NoteHelper.modelToDTO(note));
			courDto.setNotesDto(notesDto);
		}*/
		return courDto;
	}

	public static Cour DTOToModel(CourDTO courDto) {
		Cour cour = new Cour();
		if (courDto.getCreatedAt() != null)
			cour.setCreatedAt(courDto.getCreatedAt());
		if (courDto.getEnabled() != null)
			cour.setEnabled(courDto.getEnabled());
		if (courDto.getId() != null)
			cour.setId(courDto.getId());
		if (courDto.getAnneeUniversitaire() != null)
			cour.setAnneeUniversitaire(courDto.getAnneeUniversitaire());
		if (courDto.getUpdatedAt() != null)
			cour.setUpdatedAt(courDto.getUpdatedAt());
		if (courDto.getEnseignantDto() != null)
			cour.setEnseignant(EnseignantHelper.DTOToModel(courDto
					.getEnseignantDto()));
		if (courDto.getMatiereDto() != null)
			cour.setMatiere(MatiereHelper.DTOToModel(courDto.getMatiereDto()));
		if (courDto.getNiveauDto() != null)
			cour.setNiveau(NiveauHelper.DTOToModel(courDto.getNiveauDto()));
		/*if (courDto.getNotesDto() != null && courDto.getNotesDto().size() > 0) {
			List<Note> notes = new ArrayList<Note>();
			List<NoteDTO> notesDto = courDto.getNotesDto();
			for (NoteDTO noteDto : notesDto)
				notes.add(NoteHelper.DTOToModel(noteDto));
			cour.setNotes(notes);
		}*/
		return cour;
	}
}
