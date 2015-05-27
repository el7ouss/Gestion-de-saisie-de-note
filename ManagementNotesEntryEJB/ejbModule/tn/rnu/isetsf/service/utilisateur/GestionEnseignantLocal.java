package tn.rnu.isetsf.service.utilisateur;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.EnseignantDTO;

@Local
public interface GestionEnseignantLocal {
	public void creerEnseignant(EnseignantDTO ensDto);

	public EnseignantDTO getEnseignantById(Long id);

	public EnseignantDTO getEnseignantByUserNamePassword(String userName,
			String password);

	public EnseignantDTO getEnseignantByUserName(String userName);

	public Boolean findEnseignantByUserName(String userName);

	public List<EnseignantDTO> getEnseignants();

	public List<CourDTO> getCoursOfEnseignant(EnseignantDTO enseignantDto);

	public void modifierEnseignant(EnseignantDTO ensDto);

}
