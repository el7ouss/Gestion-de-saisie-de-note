package tn.rnu.isetsf.service.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.EtudiantHelper;
import tn.rnu.isetsf.common.helper.ValeurHelper;
import tn.rnu.isetsf.dao.EtudiantDAORemote;
import tn.rnu.isetsf.dto.EtudiantDTO;
import tn.rnu.isetsf.dto.ValeurDTO;
import tn.rnu.isetsf.model.Etudiant;
import tn.rnu.isetsf.model.Valeur;

/**
 * Session Bean implementation class GestionEtudiant
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.utilisateur.GestionEtudiantWS")
@Stateless
// (mappedName = "gestionuEtudiant")
public class GestionEtudiant implements GestionEtudiantRemote,
		GestionEtudiantLocal, Serializable {

	@EJB
	EtudiantDAORemote etudDao;

	/**
	 * Default constructor.
	 */
	public GestionEtudiant() {

	}

	public void creerEtudiant(EtudiantDTO etudDto) {
		Etudiant etud = EtudiantHelper.DTOToModel(etudDto);
		etudDao.save(etud);
	}

	public EtudiantDTO getEtudiantById(Long id) {
		Etudiant etud = etudDao.getById(id);
		EtudiantDTO etudDto = EtudiantHelper.modelToDTO(etud);
		return etudDto;
	}

	public EtudiantDTO getEtudiantByUserNamePassword(String userName,
			String password) {
		List<Etudiant> etuds = (List<Etudiant>) etudDao.getByUserNamePassword(
				userName, password);
		EtudiantDTO etudDto = new EtudiantDTO();
		etudDto.setUserName("");
		if (etuds.size() == 1)
			etudDto = EtudiantHelper.modelToDTO(etuds.get(0));
		return etudDto;
	}

	public Boolean findEtudiantByUserNamePassword(String userName,
			String password) {
		List<Etudiant> etuds = (List<Etudiant>) etudDao.getByUserNamePassword(
				userName, password);
		if (etuds.size() == 1)
			return true;
		else
			return false;
	}

	public EtudiantDTO getEtudiantByUserName(String userName) {
		List<Etudiant> etuds = (List<Etudiant>) etudDao.getByUserName(userName);
		EtudiantDTO etudDto = new EtudiantDTO();
		etudDto.setUserName("");
		if (etuds.size() == 1)
			etudDto = EtudiantHelper.modelToDTO(etuds.get(0));
		return etudDto;
	}

	public Boolean findEtudiantByUserName(String userName) {
		List<Etudiant> etuds = (List<Etudiant>) etudDao.getByUserName(userName);
		if (etuds.size() == 1)
			return true;
		else
			return false;
	}

	public EtudiantDTO getEtudiantByCin(Long cin) {
		List<Etudiant> etuds = (List<Etudiant>) etudDao.getByCin(cin);
		EtudiantDTO etudDto = new EtudiantDTO();
		etudDto.setUserName("");
		if (etuds.size() == 1)
			etudDto = EtudiantHelper.modelToDTO(etuds.get(0));
		return etudDto;
	}

	public EtudiantDTO getEtudiantByNumInscrit(Long numInscrit) {
		List<Etudiant> etuds = (List<Etudiant>) etudDao
				.getByNumInscrit(numInscrit);
		EtudiantDTO etudDto = new EtudiantDTO();
		etudDto.setUserName("");
		if (etuds.size() == 1)
			etudDto = EtudiantHelper.modelToDTO(etuds.get(0));
		return etudDto;
	}

	public List<EtudiantDTO> getEtudiants() {
		List<Etudiant> etuds = etudDao.getAll();
		List<EtudiantDTO> etudsDto = new ArrayList<EtudiantDTO>();
		for (Etudiant etud : etuds) {
			etudsDto.add(EtudiantHelper.modelToDTO(etud));
		}
		return etudsDto;
	}

	public EtudiantDTO[] getEtudiantsArray() {
		return getEtudiants().toArray(new EtudiantDTO[getEtudiants().size()]);
	}

	public List<ValeurDTO> getValeursOfEtudiant(EtudiantDTO etudiantDto) {
		Etudiant etudiant = EtudiantHelper.DTOToModel(etudiantDto);
		List<Valeur> valeurList = etudDao.getAllValeur(etudiant);
		List<ValeurDTO> valeurDtoList = new ArrayList<ValeurDTO>();
		for (Valeur valeur : valeurList) {
			ValeurDTO valeurDto = new ValeurDTO();
			valeurDto = ValeurHelper.modelToDTO(valeur);
			valeurDtoList.add(valeurDto);
		}
		return valeurDtoList;
	}

	public ValeurDTO[] getValeursOfEtudiantArray(EtudiantDTO etudiantDto) {
		return getValeursOfEtudiant(etudiantDto).toArray(
				new ValeurDTO[getValeursOfEtudiant(etudiantDto).size()]);
	}

	public void modifierEtudiant(EtudiantDTO etudDto) {
		Etudiant etud = EtudiantHelper.DTOToModel(etudDto);
		etudDao.edit(etud);
	}
}
