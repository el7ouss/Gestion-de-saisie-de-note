package tn.rnu.isetsf.service.compostage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.ValeurHelper;
import tn.rnu.isetsf.dao.ValeurDAORemote;
import tn.rnu.isetsf.dto.ValeurDTO;
import tn.rnu.isetsf.model.Valeur;

/**
 * Session Bean implementation class GestionValeur
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.compostage.GestionValeurWS")
@Stateless
// (mappedName = "gestionvaleur")
public class GestionValeur implements GestionValeurRemote, GestionValeurLocal,
		Serializable {

	@EJB
	ValeurDAORemote valeurDao;

	/**
	 * Default constructor.
	 */
	public GestionValeur() {

	}

	public void creerValeur(ValeurDTO valeurDto) {
		Valeur valeur = ValeurHelper.DTOToModel(valeurDto);
		valeurDao.save(valeur);
	}

	public ValeurDTO getValeurById(Long id) {
		Valeur valeur = valeurDao.getById(id);
		ValeurDTO valeurDto = ValeurHelper.modelToDTO(valeur);
		return valeurDto;
	}

	public List<ValeurDTO> getValeurs() {
		List<Valeur> valeurs = valeurDao.getAll();
		List<ValeurDTO> valeursDto = new ArrayList<ValeurDTO>();
		for (Valeur valeur : valeurs) {
			valeursDto.add(ValeurHelper.modelToDTO(valeur));
		}
		return valeursDto;
	}

	public ValeurDTO[] getValeursArray() {
		return getValeurs().toArray(new ValeurDTO[getValeurs().size()]);
	}

	public void modifierValeur(ValeurDTO valeurDto) {
		Valeur valeur = ValeurHelper.DTOToModel(valeurDto);
		valeurDao.edit(valeur);
	}

}
