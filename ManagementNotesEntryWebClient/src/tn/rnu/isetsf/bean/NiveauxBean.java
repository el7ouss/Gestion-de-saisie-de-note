package tn.rnu.isetsf.bean;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.apache.axis2.AxisFault;

import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.GetFormationById;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.CourDTO;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.CourDTOArray;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.EtudiantDTO;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.EtudiantDTOArray;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.FormationDTO;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetCoursOfNiveauArray;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetEtudiantsOfNiveauArray;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.NiveauDTO;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.NiveauDTOArray;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.CreerNiveau;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetNiveauById;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetNiveausArray;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.ModifierNiveau;

@SuppressWarnings("serial")
@ManagedBean(name = "niveauxBean")
@SessionScoped
public class NiveauxBean implements Serializable {
	private Long idNiveau = (long) 0;
	private Date createdAtNiveau = null;
	private String createdAtStringNiveau = "";
	private String designationNiveau = "";
	private byte enabledNiveau = 0;
	private Date updatedAtNiveau = null;
	private String updatedAtStringNiveau = "";
	private FormationDTO formationDtoNiveau = null;
	private Long idFormation = (long) 0;
	private ArrayList<Long> selectedEnabledNiveau;
	private ArrayList<Long> selectedEnabledCour;
	private ArrayList<Long> selectedEnabledEtudiant;
	private NiveauDTO[] niveauDTOArray = null;
	private CourDTO[] courDTOArray = null;
	private EtudiantDTO[] etudiantDTOArray = null;

	public NiveauDTO[] listNiveau() {
		NiveauDTO[] niveauDTOArray = null;
		selectedEnabledNiveau = new ArrayList<Long>();
		try {
			GestionNiveauServiceStub niveauStub = new GestionNiveauServiceStub();
			GetNiveausArray niveauxArray = new GetNiveausArray();
			NiveauDTOArray niveauDtoArray = niveauStub.getNiveausArray(
					niveauxArray).get_return();
			niveauDTOArray = niveauDtoArray.getItem();
			for (NiveauDTO niveauDto : niveauDTOArray)
				if (niveauDto.getEnabled() == (byte) 1)
					selectedEnabledNiveau.add(niveauDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return niveauDTOArray;
	}

	private CourDTO[] listCour() {
		CourDTO[] courDTOArray = null;
		selectedEnabledCour = new ArrayList<Long>();
		try {
			GestionNiveauServiceStub niveauStub = new GestionNiveauServiceStub();
			GetNiveauById niveauById = new GetNiveauById();
			niveauById.setArg0(idNiveau);
			NiveauDTO niveauDto = niveauStub.getNiveauById(niveauById)
					.get_return();
			GetCoursOfNiveauArray coursArray = new GetCoursOfNiveauArray();
			coursArray.setArg0(niveauDto);
			CourDTOArray courDtoArray = niveauStub.getCoursOfNiveauArray(
					coursArray).get_return();
			courDTOArray = courDtoArray.getItem();
			for (CourDTO courDto : courDTOArray)
				if (courDto.getEnabled() == (byte) 1)
					selectedEnabledCour.add(courDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courDTOArray;
	}

	private EtudiantDTO[] lisEtudiant() {
		EtudiantDTO[] etudiantDTOArray = null;
		selectedEnabledEtudiant = new ArrayList<Long>();
		try {
			GestionNiveauServiceStub niveauStub = new GestionNiveauServiceStub();
			GetNiveauById niveauById = new GetNiveauById();
			niveauById.setArg0(idNiveau);
			NiveauDTO niveauDto = niveauStub.getNiveauById(niveauById)
					.get_return();
			GetEtudiantsOfNiveauArray etudiantsArray = new GetEtudiantsOfNiveauArray();
			etudiantsArray.setArg0(niveauDto);
			EtudiantDTOArray etudiantDtoArray = niveauStub
					.getEtudiantsOfNiveauArray(etudiantsArray).get_return();
			etudiantDTOArray = etudiantDtoArray.getItem();
			for (EtudiantDTO etudiantDto : etudiantDTOArray)
				if (etudiantDto.getEnabled() == (byte) 1)
					selectedEnabledEtudiant.add(etudiantDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return etudiantDTOArray;
	}

	public String ajoutNiveau() {
		try {
			GestionNiveauServiceStub niveauStub = new GestionNiveauServiceStub();
			CreerNiveau niveau = new CreerNiveau();
			NiveauDTO niveauDto = new NiveauDTO();
			GestionFormationServiceStub formationStub = new GestionFormationServiceStub();
			GetFormationById formationById = new GetFormationById();
			formationById.setArg0(idFormation);
			formationDtoNiveau = new FormationDTO();
			formationDtoNiveau.setCreatedAt(formationStub
					.getFormationById(formationById).get_return()
					.getCreatedAt());
			formationDtoNiveau.setDescription(formationStub
					.getFormationById(formationById).get_return()
					.getDescription());
			formationDtoNiveau.setDesignation(formationStub
					.getFormationById(formationById).get_return()
					.getDesignation());
			formationDtoNiveau.setEnabled(formationStub
					.getFormationById(formationById).get_return().getEnabled());
			formationDtoNiveau.setId(formationStub
					.getFormationById(formationById).get_return().getId());
			formationDtoNiveau.setUpdatedAt(formationStub
					.getFormationById(formationById).get_return()
					.getUpdatedAt());
			niveauDto.setFormationDto(formationDtoNiveau);
			niveauDto.setDesignation(designationNiveau);
			niveau.setArg0(niveauDto);
			niveauStub.creerNiveau(niveau);
			initialAttributes();
			return "niveaux";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String modifierNiveau() {
		try {
			GestionNiveauServiceStub niveauStub = new GestionNiveauServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetNiveauById niveauById = new GetNiveauById();
			niveauById.setArg0(idNiveau);
			NiveauDTO niveauDto = niveauStub.getNiveauById(niveauById)
					.get_return();
			ModifierNiveau niveauDtoEditParam = new ModifierNiveau();
			// TODO etudDto.setEnabled(enabledEtud);
			GestionFormationServiceStub formationStub = new GestionFormationServiceStub();
			GetFormationById formationById = new GetFormationById();
			formationById.setArg0(idFormation);
			formationDtoNiveau = new FormationDTO();
			formationDtoNiveau.setCreatedAt(formationStub
					.getFormationById(formationById).get_return()
					.getCreatedAt());
			formationDtoNiveau.setDescription(formationStub
					.getFormationById(formationById).get_return()
					.getDescription());
			formationDtoNiveau.setDesignation(formationStub
					.getFormationById(formationById).get_return()
					.getDesignation());
			formationDtoNiveau.setEnabled(formationStub
					.getFormationById(formationById).get_return().getEnabled());
			formationDtoNiveau.setId(formationStub
					.getFormationById(formationById).get_return().getId());
			formationDtoNiveau.setUpdatedAt(formationStub
					.getFormationById(formationById).get_return()
					.getUpdatedAt());
			niveauDto.setFormationDto(formationDtoNiveau);
			niveauDto.setDesignation(designationNiveau);
			niveauDtoEditParam.setArg0(niveauDto);
			niveauStub.modifierNiveau(niveauDtoEditParam);
			initialAttributes();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "niveaux";
	}

	public void initialAttributes() {
		createdAtNiveau = null;
		createdAtStringNiveau = "";
		enabledNiveau = (byte) 0;
		designationNiveau = "";
		updatedAtNiveau = null;
		updatedAtStringNiveau = "";
		formationDtoNiveau = null;
		idFormation = (long) 0;
	}

	public Long getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}

	public Date getCreatedAtNiveau() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			createdAtNiveau = format1.parse(createdAtStringNiveau);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createdAtNiveau;
	}

	public Date getUpdatedAtNiveau() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			updatedAtNiveau = format1.parse(updatedAtStringNiveau);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updatedAtNiveau;
	}

	public String getCreatedAtStringNiveau() {
		return createdAtStringNiveau;
	}

	public void setCreatedAtStringNiveau(String createdAtStringNiveau) {
		this.createdAtStringNiveau = createdAtStringNiveau;
	}

	public String getDesignationNiveau() {
		return designationNiveau;
	}

	public void setDesignationNiveau(String designationNiveau) {
		this.designationNiveau = designationNiveau;
	}

	public byte getEnabledNiveau() {
		return enabledNiveau;
	}

	public void setEnabledNiveau(byte enabledNiveau) {
		this.enabledNiveau = enabledNiveau;
	}

	public String getUpdatedAtStringNiveau() {
		return updatedAtStringNiveau;
	}

	public void setUpdatedAtStringNiveau(String updatedAtStringNiveau) {
		this.updatedAtStringNiveau = updatedAtStringNiveau;
	}

	public ArrayList<Long> getSelectedEnabledNiveau() {
		return selectedEnabledNiveau;
	}

	public void setSelectedEnabledNiveau(ArrayList<Long> selectedEnabledNiveau) {
		this.selectedEnabledNiveau = selectedEnabledNiveau;
	}

	public NiveauDTO[] getNiveauDTOArray() {
		niveauDTOArray = listNiveau();
		return niveauDTOArray;
	}

	public void setNiveauDTOArray(NiveauDTO[] niveauDTOArray) {
		this.niveauDTOArray = niveauDTOArray;
	}

	public void setCreatedAtNiveau(Date createdAtNiveau) {
		this.createdAtNiveau = createdAtNiveau;
	}

	public void setUpdatedAtNiveau(Date updatedAtNiveau) {
		this.updatedAtNiveau = updatedAtNiveau;
	}

	public FormationDTO getFormationDtoNiveau() {
		return formationDtoNiveau;
	}

	public void setFormationDtoNiveau(FormationDTO formationDtoNiveau) {
		this.formationDtoNiveau = formationDtoNiveau;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public ArrayList<Long> getSelectedEnabledCour() {
		return selectedEnabledCour;
	}

	public void setSelectedEnabledCour(ArrayList<Long> selectedEnabledCour) {
		this.selectedEnabledCour = selectedEnabledCour;
	}

	public ArrayList<Long> getSelectedEnabledEtudiant() {
		return selectedEnabledEtudiant;
	}

	public void setSelectedEnabledEtudiant(
			ArrayList<Long> selectedEnabledEtudiant) {
		this.selectedEnabledEtudiant = selectedEnabledEtudiant;
	}

	public void loadCourDTOArray(ValueChangeEvent e) {
		courDTOArray = listCour();
		etudiantDTOArray = lisEtudiant();
	}

	public CourDTO[] getCourDTOArray() {
		courDTOArray = listCour();
		return courDTOArray;
	}

	public void setCourDTOArray(CourDTO[] courDTOArray) {
		this.courDTOArray = courDTOArray;
	}

	public EtudiantDTO[] getEtudiantDTOArray() {
		etudiantDTOArray = lisEtudiant();
		return etudiantDTOArray;
	}

	public void setEtudiantDTOArray(EtudiantDTO[] etudiantDTOArray) {
		this.etudiantDTOArray = etudiantDTOArray;
	}
}