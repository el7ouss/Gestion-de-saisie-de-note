package tn.rnu.isetsf.service.compostage;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.dto.NoteDTO;
import tn.rnu.isetsf.dto.ValeurDTO;

@Local
public interface GestionNoteLocal {
	public void creerNote(NoteDTO noteDto);

	public NoteDTO getNoteById(Long id);

	public List<NoteDTO> getNotes();

	public List<ValeurDTO> getValeursOfNote(NoteDTO noteDto);

	public void modifierNote(NoteDTO etudDto);

}
