package tn.rnu.isetsf.service.parametres;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.FormationDTO;
import tn.rnu.isetsf.dto.NiveauDTO;

@Remote
public interface GestionFormationRemote {
	public void creerFormation(FormationDTO formationDto);

	public FormationDTO getFormationById(Long id);

	public List<FormationDTO> getFormations();

	public List<NiveauDTO> getNiveauxOfFormation(FormationDTO formationDto);

	public void modifierFormation(FormationDTO formationDto);

}
