package tn.rnu.isetsf.service.parametres;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.MatiereDTO;

@Local
public interface GestionMatiereLocal {
	public void creerMatiere(MatiereDTO matiereDto);

	public MatiereDTO getMatiereById(Long id);

	public List<MatiereDTO> getMatieres();

	public List<CourDTO> getCoursOfMatiere(MatiereDTO matiereDto);

	public void modifierMatiere(MatiereDTO matiereDto);

}
