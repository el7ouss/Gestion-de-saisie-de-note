package tn.rnu.isetsf.service.parametres;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.NoteDTO;

@Local
public interface GestionCourLocal {
	public void creerCour(CourDTO courDto);

	public CourDTO getCourById(Long id);

	public List<CourDTO> getCours();

	public List<NoteDTO> getNotesOfCour(CourDTO courDto);

	public void modifierCour(CourDTO etudDto);

}
