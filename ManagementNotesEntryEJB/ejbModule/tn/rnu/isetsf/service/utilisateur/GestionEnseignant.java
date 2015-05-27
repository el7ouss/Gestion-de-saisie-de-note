package tn.rnu.isetsf.service.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.CourHelper;
import tn.rnu.isetsf.common.helper.EnseignantHelper;
import tn.rnu.isetsf.dao.EnseignantDAORemote;
import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.EnseignantDTO;
import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Enseignant;

/**
 * Session Bean implementation class GestionEnseignant
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.utilisateur.GestionEnseignantWS")
@Stateless
// (mappedName = "gestionuEnseignant")
public class GestionEnseignant implements GestionEnseignantRemote,
		GestionEnseignantLocal, Serializable {

	@EJB
	EnseignantDAORemote ensDao;

	/**
	 * Default constructor.
	 */
	public GestionEnseignant() {

	}

	public void creerEnseignant(EnseignantDTO ensDto) {
		Enseignant ens = EnseignantHelper.DTOToModel(ensDto);
		ensDao.save(ens);
	}

	public EnseignantDTO getEnseignantById(Long id) {
		Enseignant ens = ensDao.getById(id);
		EnseignantDTO ensDto = EnseignantHelper.modelToDTO(ens);
		return ensDto;
	}

	public EnseignantDTO getEnseignantByUserNamePassword(String userName,
			String password) {
		List<Enseignant> enss = (List<Enseignant>) ensDao
				.getByUserNamePassword(userName, password);
		EnseignantDTO ensDto = new EnseignantDTO();
		ensDto.setUserName("");
		if (enss.size() == 1)
			ensDto = EnseignantHelper.modelToDTO(enss.get(0));
		return ensDto;
	}

	public Boolean findEnseignantByUserNamePassword(String userName,
			String password) {
		List<Enseignant> enss = (List<Enseignant>) ensDao
				.getByUserNamePassword(userName, password);
		if (enss.size() == 1)
			return true;
		else
			return false;
	}

	public EnseignantDTO getEnseignantByUserName(String userName) {
		List<Enseignant> enss = (List<Enseignant>) ensDao
				.getByUserName(userName);
		EnseignantDTO ensDto = new EnseignantDTO();
		ensDto.setUserName("");
		if (enss.size() == 1)
			ensDto = EnseignantHelper.modelToDTO(enss.get(0));
		return ensDto;
	}

	public Boolean findEnseignantByUserName(String userName) {
		List<Enseignant> enss = (List<Enseignant>) ensDao
				.getByUserName(userName);
		if (enss.size() == 1)
			return true;
		else
			return false;
	}

	public List<EnseignantDTO> getEnseignants() {
		List<Enseignant> enss = ensDao.getAll();
		List<EnseignantDTO> enssDto = new ArrayList<EnseignantDTO>();
		for (Enseignant ens : enss) {
			enssDto.add(EnseignantHelper.modelToDTO(ens));
		}
		return enssDto;
	}

	public EnseignantDTO[] getEnseignantsArray() {
		return getEnseignants().toArray(
				new EnseignantDTO[getEnseignants().size()]);
	}

	public List<CourDTO> getCoursOfEnseignant(EnseignantDTO enseignantDto) {
		Enseignant enseignant = EnseignantHelper.DTOToModel(enseignantDto);
		List<Cour> courList = ensDao.getAllCour(enseignant);
		List<CourDTO> courDtoList = new ArrayList<CourDTO>();
		for (Cour cour : courList) {
			CourDTO courDto = new CourDTO();
			courDto = CourHelper.modelToDTO(cour);
			courDtoList.add(courDto);
		}
		return courDtoList;
	}

	public CourDTO[] getCoursOfEnseignantArray(EnseignantDTO enseignantDto) {
		return getCoursOfEnseignant(enseignantDto).toArray(
				new CourDTO[getCoursOfEnseignant(enseignantDto).size()]);
	}

	public void modifierEnseignant(EnseignantDTO ensDto) {
		Enseignant ens = EnseignantHelper.DTOToModel(ensDto);
		ensDao.edit(ens);
	}

}
