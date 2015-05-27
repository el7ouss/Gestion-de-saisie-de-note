package tn.rnu.isetsf.service.parametres;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.DepartementHelper;
import tn.rnu.isetsf.common.helper.FormationHelper;
import tn.rnu.isetsf.dao.DepartementDAORemote;
import tn.rnu.isetsf.dto.DepartementDTO;
import tn.rnu.isetsf.dto.FormationDTO;
import tn.rnu.isetsf.model.Departement;
import tn.rnu.isetsf.model.Formation;

/**
 * Session Bean implementation class GestionDepartement
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.parametres.GestionDepartementWS")
@Stateless
// (mappedName = "gestiondepartement")
public class GestionDepartement implements GestionDepartementRemote,
		GestionDepartementLocal, Serializable {

	@EJB
	DepartementDAORemote departementDao;

	/**
	 * Default constructor.
	 */
	public GestionDepartement() {

	}

	public void creerDepartement(DepartementDTO departementDto) {
		Departement departement = DepartementHelper.DTOToModel(departementDto);
		departementDao.save(departement);
	}

	public DepartementDTO getDepartementById(Long id) {
		Departement departement = departementDao.getById(id);
		DepartementDTO departementDto = DepartementHelper
				.modelToDTO(departement);
		return departementDto;
	}

	public List<DepartementDTO> getDepartements() {
		List<Departement> departements = departementDao.getAll();
		List<DepartementDTO> departementsDto = new ArrayList<DepartementDTO>();
		for (Departement departement : departements) {
			departementsDto.add(DepartementHelper.modelToDTO(departement));
		}
		return departementsDto;
	}

	public DepartementDTO[] getDepartementsArray() {
		return getDepartements().toArray(
				new DepartementDTO[getDepartements().size()]);
	}

	public List<FormationDTO> getFormationsOfDepartement(
			DepartementDTO departementDto) {
		Departement departement = DepartementHelper.DTOToModel(departementDto);
		List<Formation> formationList = departementDao
				.getAllFormation(departement);
		List<FormationDTO> formationDtoList = new ArrayList<FormationDTO>();
		for (Formation formation : formationList) {
			FormationDTO formationDto = new FormationDTO();
			formationDto = FormationHelper.modelToDTO(formation);
			formationDtoList.add(formationDto);
		}
		return formationDtoList;
	}

	public FormationDTO[] getFormationsOfDepartementArray(DepartementDTO departementDto) {
		return getFormationsOfDepartement(departementDto).toArray(
				new FormationDTO[getFormationsOfDepartement(departementDto)
						.size()]);
	}

	public void modifierDepartement(DepartementDTO departementDto) {
		Departement departement = DepartementHelper.DTOToModel(departementDto);
		departementDao.edit(departement);
	}

}
