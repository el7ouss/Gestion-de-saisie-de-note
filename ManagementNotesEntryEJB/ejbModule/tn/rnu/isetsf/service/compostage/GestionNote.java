package tn.rnu.isetsf.service.compostage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.NoteHelper;
import tn.rnu.isetsf.common.helper.ValeurHelper;
import tn.rnu.isetsf.dao.NoteDAORemote;
import tn.rnu.isetsf.dto.NoteDTO;
import tn.rnu.isetsf.dto.ValeurDTO;
import tn.rnu.isetsf.model.Note;
import tn.rnu.isetsf.model.Valeur;

/**
 * Session Bean implementation class GestionNote
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.compostage.GestionNoteWS")
@Stateless
// (mappedName = "gestionniveaucour")
public class GestionNote implements GestionNoteRemote, GestionNoteLocal,
		Serializable {

	@EJB
	NoteDAORemote noteDao;

	/**
	 * Default constructor.
	 */
	public GestionNote() {

	}

	public void creerNote(NoteDTO noteDto) {
		Note note = NoteHelper.DTOToModel(noteDto);
		noteDao.save(note);
	}

	public NoteDTO getNoteById(Long id) {
		Note note = noteDao.getById(id);
		NoteDTO noteDto = NoteHelper.modelToDTO(note);
		return noteDto;
	}

	public List<NoteDTO> getNotes() {
		List<Note> notes = noteDao.getAll();
		List<NoteDTO> notesDto = new ArrayList<NoteDTO>();
		for (Note note : notes) {
			notesDto.add(NoteHelper.modelToDTO(note));
		}
		return notesDto;
	}

	public NoteDTO[] getNotesArray() {
		return getNotes().toArray(new NoteDTO[getNotes().size()]);
	}

	public List<ValeurDTO> getValeursOfNote(NoteDTO noteDto) {
		Note note = NoteHelper.DTOToModel(noteDto);
		List<Valeur> valeurList = noteDao.getAllValeur(note);
		List<ValeurDTO> valeurDtoList = new ArrayList<ValeurDTO>();
		for (Valeur valeur : valeurList) {
			ValeurDTO valeurDto = new ValeurDTO();
			valeurDto = ValeurHelper.modelToDTO(valeur);
			valeurDtoList.add(valeurDto);
		}
		return valeurDtoList;
	}

	public ValeurDTO[] getValeursOfNoteArray(NoteDTO noteDto) {
		return getValeursOfNote(noteDto).toArray(
				new ValeurDTO[getValeursOfNote(noteDto).size()]);
	}

	public void modifierNote(NoteDTO noteDto) {
		Note note = NoteHelper.DTOToModel(noteDto);
		noteDao.edit(note);
	}

}
