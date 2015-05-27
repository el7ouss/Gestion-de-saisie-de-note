package tn.rnu.isetsf.service.parametres;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.CourHelper;
import tn.rnu.isetsf.common.helper.EtudiantHelper;
import tn.rnu.isetsf.common.helper.NiveauHelper;
import tn.rnu.isetsf.dao.NiveauDAORemote;
import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.EtudiantDTO;
import tn.rnu.isetsf.dto.NiveauDTO;
import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Etudiant;
import tn.rnu.isetsf.model.Niveau;

/**
 * Session Bean implementation class GestionNiveau
 */
@SuppressWarnings("serial")
// @LocalBean
@WebService(endpointInterface = "tn.rnu.isetsf.service.parametres.GestionNiveauWS")
@Stateless
// (mappedName = "gestionniveau")
public class GestionNiveau implements GestionNiveauRemote, GestionNiveauLocal,
		Serializable {

	@EJB
	NiveauDAORemote niveauDao;

	/**
	 * Default constructor.
	 */
	public GestionNiveau() {

	}

	public void creerNiveau(NiveauDTO niveauDto) {
		Niveau niveau = NiveauHelper.DTOToModel(niveauDto);
		niveauDao.save(niveau);
	}

	public NiveauDTO getNiveauById(Long id) {
		Niveau niveau = niveauDao.getById(id);
		NiveauDTO niveauDto = NiveauHelper.modelToDTO(niveau);
		return niveauDto;
	}

	public List<NiveauDTO> getNiveaus() {
		List<Niveau> niveaus = niveauDao.getAll();
		List<NiveauDTO> niveausDto = new ArrayList<NiveauDTO>();
		for (Niveau niveau : niveaus) {
			niveausDto.add(NiveauHelper.modelToDTO(niveau));
		}
		return niveausDto;
	}

	public NiveauDTO[] getNiveausArray() {
		return getNiveaus().toArray(new NiveauDTO[getNiveaus().size()]);
	}

	public List<CourDTO> getCoursOfNiveau(NiveauDTO niveauDto) {
		Niveau niveau = NiveauHelper.DTOToModel(niveauDto);
		List<Cour> courList = niveauDao.getAllCour(niveau);
		List<CourDTO> courDtoList = new ArrayList<CourDTO>();
		for (Cour cour : courList) {
			CourDTO courDto = new CourDTO();
			courDto = CourHelper.modelToDTO(cour);
			courDtoList.add(courDto);
		}
		return courDtoList;
	}

	public CourDTO[] getCoursOfNiveauArray(NiveauDTO niveauDto) {
		return getCoursOfNiveau(niveauDto).toArray(
				new CourDTO[getCoursOfNiveau(niveauDto).size()]);
	}

	public List<EtudiantDTO> getEtudiantsOfNiveau(NiveauDTO niveauDto) {
		Niveau niveau = NiveauHelper.DTOToModel(niveauDto);
		List<Etudiant> etudiantList = niveauDao.getAllEtudiant(niveau);
		List<EtudiantDTO> etudiantDtoList = new ArrayList<EtudiantDTO>();
		for (Etudiant etudiant : etudiantList) {
			EtudiantDTO etudiantDto = new EtudiantDTO();
			etudiantDto = EtudiantHelper.modelToDTO(etudiant);
			etudiantDtoList.add(etudiantDto);
		}
		return etudiantDtoList;
	}

	public EtudiantDTO[] getEtudiantsOfNiveauArray(NiveauDTO niveauDto) {
		return getEtudiantsOfNiveau(niveauDto).toArray(
				new EtudiantDTO[getEtudiantsOfNiveau(niveauDto).size()]);
	}

	public void modifierNiveau(NiveauDTO niveauDto) {
		Niveau niveau = NiveauHelper.DTOToModel(niveauDto);
		niveauDao.edit(niveau);
	}

}
