package tn.rnu.isetsf.service.parametres;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.CourHelper;
import tn.rnu.isetsf.common.helper.NoteHelper;
import tn.rnu.isetsf.dao.CourDAORemote;
import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.NoteDTO;
import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Note;

/**
 * Session Bean implementation class GestionCour
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.parametres.GestionCourWS")
@Stateless
// (mappedName = "gestioncour")
public class GestionCour implements GestionCourRemote, GestionCourLocal,
		Serializable {

	@EJB
	CourDAORemote courDao;

	/**
	 * Default constructor.
	 */
	public GestionCour() {

	}

	public void creerCour(CourDTO courDto) {
		Cour cour = CourHelper.DTOToModel(courDto);
		courDao.save(cour);
	}

	public CourDTO getCourById(Long id) {
		Cour cour = courDao.getById(id);
		CourDTO courDto = CourHelper.modelToDTO(cour);
		return courDto;
	}

	public List<CourDTO> getCours() {
		List<Cour> cours = courDao.getAll();
		List<CourDTO> coursDto = new ArrayList<CourDTO>();
		for (Cour cour : cours) {
			coursDto.add(CourHelper.modelToDTO(cour));
		}
		return coursDto;
	}

	public CourDTO[] getCoursArray() {
		return getCours().toArray(new CourDTO[getCours().size()]);
	}

	public List<NoteDTO> getNotesOfCour(CourDTO courDto) {
		Cour cour = CourHelper.DTOToModel(courDto);
		List<Note> noteList = courDao.getAllNote(cour);
		List<NoteDTO> noteDtoList = new ArrayList<NoteDTO>();
		for (Note note : noteList) {
			NoteDTO noteDto = new NoteDTO();
			noteDto = NoteHelper.modelToDTO(note);
			noteDtoList.add(noteDto);
		}
		return noteDtoList;
	}

	public NoteDTO[] getNotesOfCourArray(CourDTO courDto) {
		return getNotesOfCour(courDto).toArray(
				new NoteDTO[getNotesOfCour(courDto).size()]);
	}

	public void modifierCour(CourDTO courDto) {
		Cour cour = CourHelper.DTOToModel(courDto);
		courDao.edit(cour);
	}

}
