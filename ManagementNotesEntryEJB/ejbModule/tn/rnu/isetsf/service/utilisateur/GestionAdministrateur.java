package tn.rnu.isetsf.service.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.AdministrateurHelper;
import tn.rnu.isetsf.dao.AdministrateurDAORemote;
import tn.rnu.isetsf.dto.AdministrateurDTO;
import tn.rnu.isetsf.model.Administrateur;

/**
 * Session Bean implementation class GestionAdministrateur
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.utilisateur.GestionAdministrateurWS")
@Stateless
// (mappedName = "gestionuAdministrateur")
public class GestionAdministrateur implements GestionAdministrateurRemote,
		GestionAdministrateurLocal, Serializable {

	@EJB
	AdministrateurDAORemote adminDao;

	/**
	 * Default constructor.
	 */
	public GestionAdministrateur() {

	}

	public void creerAdministrateur(AdministrateurDTO adminDto) {
		Administrateur admin = AdministrateurHelper.DTOToModel(adminDto);
		adminDao.save(admin);
	}

	public AdministrateurDTO getAdministrateurById(Long id) {
		Administrateur admin = adminDao.getById(id);
		AdministrateurDTO adminDto = AdministrateurHelper.modelToDTO(admin);
		return adminDto;
	}

	public AdministrateurDTO getAdministrateurByUserNamePassword(
			String userName, String password) {
		List<Administrateur> admins = (List<Administrateur>) adminDao
				.getByUserNamePassword(userName, password);
		AdministrateurDTO adminDto = new AdministrateurDTO();
		adminDto.setUserName("");
		if (admins.size() == 1)
			adminDto = AdministrateurHelper.modelToDTO(admins.get(0));
		return adminDto;
	}

	public Boolean findAdministrateurByUserNamePassword(String userName,
			String password) {
		List<Administrateur> admins = (List<Administrateur>) adminDao
				.getByUserNamePassword(userName, password);
		if (admins.size() == 1)
			return true;
		else
			return false;
	}

	public AdministrateurDTO getAdministrateurByUserName(String userName) {
		List<Administrateur> admins = (List<Administrateur>) adminDao
				.getByUserName(userName);
		AdministrateurDTO adminDto = new AdministrateurDTO();
		adminDto.setUserName("");
		if (admins.size() == 1)
			adminDto = AdministrateurHelper.modelToDTO(admins.get(0));
		return adminDto;
	}

	public Boolean findAdministrateurByUserName(String userName) {
		List<Administrateur> admins = (List<Administrateur>) adminDao
				.getByUserName(userName);
		if (admins.size() == 1)
			return true;
		else
			return false;
	}

	public List<AdministrateurDTO> getAdministrateurs() {
		List<Administrateur> admins = adminDao.getAll();
		List<AdministrateurDTO> adminsDto = new ArrayList<AdministrateurDTO>();
		for (Administrateur admin : admins) {
			adminsDto.add(AdministrateurHelper.modelToDTO(admin));
		}
		return adminsDto;
	}

	public AdministrateurDTO[] getAdministrateursArray() {
		return getAdministrateurs().toArray(
				new AdministrateurDTO[getAdministrateurs().size()]);
	}

	public void modifierAdministrateur(AdministrateurDTO adminDto) {
		Administrateur admin = AdministrateurHelper.DTOToModel(adminDto);
		adminDao.edit(admin);
	}

}
