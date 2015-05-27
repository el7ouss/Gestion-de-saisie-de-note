package tn.rnu.isetsf.service.compostage;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.NoteDTO;
import tn.rnu.isetsf.dto.ValeurDTO;

@Remote
public interface GestionNoteRemote {
	public void creerNote(NoteDTO noteDto);

	public NoteDTO getNoteById(Long id);

	public List<NoteDTO> getNotes();

	public List<ValeurDTO> getValeursOfNote(NoteDTO noteDto);

	public void modifierNote(NoteDTO etudDto);

}
