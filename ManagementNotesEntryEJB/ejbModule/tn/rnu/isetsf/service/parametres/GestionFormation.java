package tn.rnu.isetsf.service.parametres;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.FormationHelper;
import tn.rnu.isetsf.common.helper.NiveauHelper;
import tn.rnu.isetsf.dao.FormationDAORemote;
import tn.rnu.isetsf.dto.FormationDTO;
import tn.rnu.isetsf.dto.NiveauDTO;
import tn.rnu.isetsf.model.Formation;
import tn.rnu.isetsf.model.Niveau;

/**
 * Session Bean implementation class GestionFormation
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.parametres.GestionFormationWS")
@Stateless
// (mappedName = "gestionformation")
public class GestionFormation implements GestionFormationRemote,
		GestionFormationLocal, Serializable {

	@EJB
	FormationDAORemote formationDao;

	/**
	 * Default constructor.
	 */
	public GestionFormation() {

	}

	public void creerFormation(FormationDTO formationDto) {
		Formation formation = FormationHelper.DTOToModel(formationDto);
		formationDao.save(formation);
	}

	public FormationDTO getFormationById(Long id) {
		Formation formation = formationDao.getById(id);
		FormationDTO formationDto = FormationHelper.modelToDTO(formation);
		return formationDto;
	}

	public List<FormationDTO> getFormations() {
		List<Formation> formations = formationDao.getAll();
		List<FormationDTO> formationsDto = new ArrayList<FormationDTO>();
		for (Formation formation : formations) {
			formationsDto.add(FormationHelper.modelToDTO(formation));
		}
		return formationsDto;
	}

	public FormationDTO[] getFormationsArray() {
		return getFormations()
				.toArray(new FormationDTO[getFormations().size()]);
	}

	public List<NiveauDTO> getNiveauxOfFormation(FormationDTO formationDto) {
		Formation formation = FormationHelper.DTOToModel(formationDto);
		List<Niveau> niveauList = formationDao.getAllNiveau(formation);
		List<NiveauDTO> niveauDtoList = new ArrayList<NiveauDTO>();
		for (Niveau niveau : niveauList) {
			NiveauDTO niveauDto = new NiveauDTO();
			niveauDto = NiveauHelper.modelToDTO(niveau);
			niveauDtoList.add(niveauDto);
		}
		return niveauDtoList;
	}

	public NiveauDTO[] getNiveauxOfFormationArray(FormationDTO formationDto) {
		return getNiveauxOfFormation(formationDto).toArray(
				new NiveauDTO[getNiveauxOfFormation(formationDto).size()]);
	}

	public void modifierFormation(FormationDTO formationDto) {
		Formation formation = FormationHelper.DTOToModel(formationDto);
		formationDao.edit(formation);
	}

}
