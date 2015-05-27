package tn.rnu.isetsf.service.parametres;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.MatiereDTO;

@Remote
public interface GestionMatiereRemote {
	public void creerMatiere(MatiereDTO matiereDto);

	public MatiereDTO getMatiereById(Long id);

	public List<MatiereDTO> getMatieres();

	public List<CourDTO> getCoursOfMatiere(MatiereDTO matiereDto);

	public void modifierMatiere(MatiereDTO matiereDto);

}
