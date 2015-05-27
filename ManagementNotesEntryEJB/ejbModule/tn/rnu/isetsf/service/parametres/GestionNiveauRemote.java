package tn.rnu.isetsf.service.parametres;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.EtudiantDTO;
import tn.rnu.isetsf.dto.NiveauDTO;

@Remote
public interface GestionNiveauRemote {
	public void creerNiveau(NiveauDTO niveauDto);

	public NiveauDTO getNiveauById(Long id);

	public List<NiveauDTO> getNiveaus();

	public List<CourDTO> getCoursOfNiveau(NiveauDTO niveauDto);

	public List<EtudiantDTO> getEtudiantsOfNiveau(NiveauDTO niveauDto);

	public void modifierNiveau(NiveauDTO niveauDto);

}
