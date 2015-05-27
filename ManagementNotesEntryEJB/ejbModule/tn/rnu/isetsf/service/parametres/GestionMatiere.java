package tn.rnu.isetsf.service.parametres;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.CourHelper;
import tn.rnu.isetsf.common.helper.MatiereHelper;
import tn.rnu.isetsf.dao.MatiereDAORemote;
import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.MatiereDTO;
import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Matiere;

/**
 * Session Bean implementation class GestionMatiere
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.parametres.GestionMatiereWS")
@Stateless
// (mappedName = "gestionmatiere")
public class GestionMatiere implements GestionMatiereRemote,
		GestionMatiereLocal, Serializable {

	@EJB
	MatiereDAORemote matiereDao;

	/**
	 * Default constructor.
	 */
	public GestionMatiere() {

	}

	public void creerMatiere(MatiereDTO matiereDto) {
		Matiere matiere = MatiereHelper.DTOToModel(matiereDto);
		matiereDao.save(matiere);
	}

	public MatiereDTO getMatiereById(Long id) {
		Matiere matiere = matiereDao.getById(id);
		MatiereDTO matiereDto = MatiereHelper.modelToDTO(matiere);
		return matiereDto;
	}

	public List<MatiereDTO> getMatieres() {
		List<Matiere> matieres = matiereDao.getAll();
		List<MatiereDTO> matieresDto = new ArrayList<MatiereDTO>();
		for (Matiere matiere : matieres) {
			matieresDto.add(MatiereHelper.modelToDTO(matiere));
		}
		return matieresDto;
	}

	public MatiereDTO[] getMatieresArray() {
		return getMatieres().toArray(new MatiereDTO[getMatieres().size()]);
	}

	public List<CourDTO> getCoursOfMatiere(MatiereDTO matiereDto) {
		Matiere matiere = MatiereHelper.DTOToModel(matiereDto);
		List<Cour> courList = matiereDao.getAllCour(matiere);
		List<CourDTO> courDtoList = new ArrayList<CourDTO>();
		for (Cour cour : courList) {
			CourDTO courDto = new CourDTO();
			courDto = CourHelper.modelToDTO(cour);
			courDtoList.add(courDto);
		}
		return courDtoList;
	}

	public CourDTO[] getCoursOfMatiereArray(MatiereDTO matiereDto) {
		return getCoursOfMatiere(matiereDto).toArray(
				new CourDTO[getCoursOfMatiere(matiereDto).size()]);
	}

	public void modifierMatiere(MatiereDTO matiereDto) {
		Matiere matiere = MatiereHelper.DTOToModel(matiereDto);
		matiereDao.edit(matiere);
	}

}
