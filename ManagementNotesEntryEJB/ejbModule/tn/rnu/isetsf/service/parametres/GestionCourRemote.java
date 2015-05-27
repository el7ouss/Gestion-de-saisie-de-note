package tn.rnu.isetsf.service.parametres;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.NoteDTO;

@Remote
public interface GestionCourRemote {
	public void creerCour(CourDTO courDto);

	public CourDTO getCourById(Long id);

	public List<CourDTO> getCours();

	public List<NoteDTO> getNotesOfCour(CourDTO courDto);

	public void modifierCour(CourDTO etudDto);

}
