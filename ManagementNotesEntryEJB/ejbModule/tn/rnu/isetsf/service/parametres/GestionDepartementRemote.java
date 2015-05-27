package tn.rnu.isetsf.service.parametres;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.DepartementDTO;
import tn.rnu.isetsf.dto.FormationDTO;

@Remote
public interface GestionDepartementRemote {
	public void creerDepartement(DepartementDTO departementDto);

	public DepartementDTO getDepartementById(Long id);

	public List<DepartementDTO> getDepartements();

	public List<FormationDTO> getFormationsOfDepartement(
			DepartementDTO departementDto);

	public void modifierDepartement(DepartementDTO departementDto);

}
