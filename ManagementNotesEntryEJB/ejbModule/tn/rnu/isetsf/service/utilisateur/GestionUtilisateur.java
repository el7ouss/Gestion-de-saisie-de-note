package tn.rnu.isetsf.service.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.UtilisateurHelper;
import tn.rnu.isetsf.dao.UtilisateurDAORemote;
import tn.rnu.isetsf.dto.UtilisateurDTO;
import tn.rnu.isetsf.model.Utilisateur;

/**
 * Session Bean implementation class GestionUtilisateur
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.utilisateur.GestionUtilisateurWS")
@Stateless
// (mappedName = "gestionutilisateur")
public class GestionUtilisateur implements GestionUtilisateurRemote,
		GestionUtilisateurLocal, Serializable {

	@EJB
	UtilisateurDAORemote userDao;

	/**
	 * Default constructor.
	 */
	public GestionUtilisateur() {

	}

	public void creerUtilisateur(UtilisateurDTO userDto) {
		Utilisateur user = UtilisateurHelper.DTOToModel(userDto);
		userDao.save(user);
	}

	public UtilisateurDTO getUtilisateurById(Long id) {
		Utilisateur user = userDao.getById(id);
		UtilisateurDTO userDto = UtilisateurHelper.modelToDTO(user);
		return userDto;
	}

	public UtilisateurDTO getUtilisateurByUserNamePassword(String userName,
			String password) {
		List<Utilisateur> users = (List<Utilisateur>) userDao
				.getByUserNamePassword(userName, password);
		UtilisateurDTO userDto = new UtilisateurDTO();
		userDto.setUserName("");
		if (users.size() == 1)
			userDto = UtilisateurHelper.modelToDTO(users.get(0));
		return userDto;
	}

	public Boolean findUtilisateurByUserNamePassword(String userName,
			String password) {
		List<Utilisateur> users = (List<Utilisateur>) userDao
				.getByUserNamePassword(userName, password);
		if (users.size() == 1)
			return true;
		return false;
	}

	public UtilisateurDTO getUtilisateurByUserName(String userName) {
		List<Utilisateur> users = (List<Utilisateur>) userDao
				.getByUserName(userName);
		UtilisateurDTO userDto = new UtilisateurDTO();
		userDto.setUserName("");
		if (users.size() == 1)
			userDto = UtilisateurHelper.modelToDTO(users.get(0));
		return userDto;
	}

	public Boolean findUtilisateurByUserName(String userName) {
		List<Utilisateur> users = (List<Utilisateur>) userDao
				.getByUserName(userName);
		if (users.size() == 1)
			return true;
		return false;
	}

	public List<UtilisateurDTO> getUtilisateurs() {
		List<Utilisateur> users = userDao.getAll();
		List<UtilisateurDTO> usersDto = new ArrayList<UtilisateurDTO>();
		for (Utilisateur user : users) {
			usersDto.add(UtilisateurHelper.modelToDTO(user));
		}
		return usersDto;
	}

	public UtilisateurDTO[] getUtilisateursArray() {
		return getUtilisateurs().toArray(
				new UtilisateurDTO[getUtilisateurs().size()]);
	}

	public void modifierUtilisateur(UtilisateurDTO userDto) {
		Utilisateur user = UtilisateurHelper.DTOToModel(userDto);
		userDao.edit(user);
	}

}
