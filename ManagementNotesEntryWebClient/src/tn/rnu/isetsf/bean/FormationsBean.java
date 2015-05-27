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

import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub;
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.GetDepartementById;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.DepartementDTO;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.FormationDTO;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.FormationDTOArray;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.CreerFormation;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.GetFormationById;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.GetFormationsArray;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.GetNiveauxOfFormationArray;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.ModifierFormation;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.NiveauDTO;
import tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.NiveauDTOArray;

@SuppressWarnings("serial")
@ManagedBean(name = "formationsBean")
@SessionScoped
public class FormationsBean implements Serializable {
	private Long idFormation = (long) 0;
	private Date createdAtFormation = null;
	private String createdAtStringFormation = "";
	private String designationFormation = "";
	private byte enabledFormation = 0;
	private String descriptionFormation = "";
	private Date updatedAtFormation = null;
	private String updatedAtStringFormation = "";
	private DepartementDTO departementDtoFormation = null;
	private Long idDepartement = (long) 0;
	private ArrayList<Long> selectedEnabledFormation;
	private ArrayList<Long> selectedEnabledNiveau;
	private FormationDTO[] formationDTOArray = null;
	private NiveauDTO[] niveauDTOArray = null;

	public FormationDTO[] listFormation() {
		FormationDTO[] formationDTOArray = null;
		selectedEnabledFormation = new ArrayList<Long>();
		try {
			GestionFormationServiceStub formationStub = new GestionFormationServiceStub();
			GetFormationsArray formationsArray = new GetFormationsArray();
			FormationDTOArray formationDtoArray = formationStub
					.getFormationsArray(formationsArray).get_return();
			formationDTOArray = formationDtoArray.getItem();
			for (FormationDTO formationDto : formationDTOArray)
				if (formationDto.getEnabled() == (byte) 1)
					selectedEnabledFormation.add(formationDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return formationDTOArray;
	}

	private NiveauDTO[] listNiveau() {
		NiveauDTO[] niveauDTOArray = null;
		selectedEnabledNiveau = new ArrayList<Long>();
		try {
			GestionFormationServiceStub formationStub = new GestionFormationServiceStub();
			GetFormationById formationById = new GetFormationById();
			formationById.setArg0(idFormation);
			FormationDTO formationDto = formationStub.getFormationById(
					formationById).get_return();
			GetNiveauxOfFormationArray niveauxArray = new GetNiveauxOfFormationArray();
			niveauxArray.setArg0(formationDto);
			NiveauDTOArray niveauDtoArray = formationStub
					.getNiveauxOfFormationArray(niveauxArray).get_return();
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

	public String ajoutFormation() {
		try {
			GestionFormationServiceStub formationStub = new GestionFormationServiceStub();
			CreerFormation formation = new CreerFormation();
			FormationDTO formationDto = new FormationDTO();
			formationDto.setDescription(descriptionFormation);
			formationDto.setDesignation(designationFormation);
			if (idDepartement != 0) {
				GestionDepartementServiceStub departementStub = new GestionDepartementServiceStub();
				GetDepartementById departementById = new GetDepartementById();
				departementById.setArg0(idDepartement);
				departementDtoFormation = new DepartementDTO();
				departementDtoFormation.setCreatedAt(departementStub
						.getDepartementById(departementById).get_return()
						.getCreatedAt());
				departementDtoFormation.setDescription(departementStub
						.getDepartementById(departementById).get_return()
						.getDescription());
				departementDtoFormation.setDesignation(departementStub
						.getDepartementById(departementById).get_return()
						.getDesignation());
				departementDtoFormation.setEnabled(departementStub
						.getDepartementById(departementById).get_return()
						.getEnabled());
				departementDtoFormation.setId(departementStub
						.getDepartementById(departementById).get_return()
						.getId());
				departementDtoFormation.setUpdatedAt(departementStub
						.getDepartementById(departementById).get_return()
						.getUpdatedAt());
				formationDto.setDepartementDto(departementDtoFormation);
			}
			formation.setArg0(formationDto);
			formationStub.creerFormation(formation);
			initialAttributes();
			return "formations";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String modifierFormation() {
		try {
			GestionFormationServiceStub formationStub = new GestionFormationServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetFormationById formationById = new GetFormationById();
			formationById.setArg0(idFormation);
			FormationDTO formationDto = formationStub.getFormationById(
					formationById).get_return();
			ModifierFormation formationDtoEditParam = new ModifierFormation();
			formationDto.setDescription(descriptionFormation);
			// TODO etudDto.setEnabled(enabledEtud);
			formationDto.setDesignation(designationFormation);
			if (idDepartement != 0) {
				GestionDepartementServiceStub departementStub = new GestionDepartementServiceStub();
				GetDepartementById departementById = new GetDepartementById();
				departementById.setArg0(idDepartement);
				departementDtoFormation = new DepartementDTO();
				departementDtoFormation.setCreatedAt(departementStub
						.getDepartementById(departementById).get_return()
						.getCreatedAt());
				departementDtoFormation.setDescription(departementStub
						.getDepartementById(departementById).get_return()
						.getDescription());
				departementDtoFormation.setDesignation(departementStub
						.getDepartementById(departementById).get_return()
						.getDesignation());
				departementDtoFormation.setEnabled(departementStub
						.getDepartementById(departementById).get_return()
						.getEnabled());
				departementDtoFormation.setId(departementStub
						.getDepartementById(departementById).get_return()
						.getId());
				departementDtoFormation.setUpdatedAt(departementStub
						.getDepartementById(departementById).get_return()
						.getUpdatedAt());
				formationDto.setDepartementDto(departementDtoFormation);
			}
			formationDtoEditParam.setArg0(formationDto);
			formationStub.modifierFormation(formationDtoEditParam);
			initialAttributes();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "formations";
	}

	public void initialAttributes() {
		createdAtFormation = null;
		createdAtStringFormation = "";
		descriptionFormation = "";
		enabledFormation = (byte) 0;
		designationFormation = "";
		updatedAtFormation = null;
		updatedAtStringFormation = "";
		departementDtoFormation = null;
		idDepartement = (long) 0;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public Date getCreatedAtFormation() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			createdAtFormation = format1.parse(createdAtStringFormation);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createdAtFormation;
	}

	public Date getUpdatedAtFormation() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			updatedAtFormation = format1.parse(updatedAtStringFormation);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updatedAtFormation;
	}

	public String getCreatedAtStringFormation() {
		return createdAtStringFormation;
	}

	public void setCreatedAtStringFormation(String createdAtStringFormation) {
		this.createdAtStringFormation = createdAtStringFormation;
	}

	public String getDesignationFormation() {
		return designationFormation;
	}

	public void setDesignationFormation(String designationFormation) {
		this.designationFormation = designationFormation;
	}

	public byte getEnabledFormation() {
		return enabledFormation;
	}

	public void setEnabledFormation(byte enabledFormation) {
		this.enabledFormation = enabledFormation;
	}

	public String getDescriptionFormation() {
		return descriptionFormation;
	}

	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}

	public String getUpdatedAtStringFormation() {
		return updatedAtStringFormation;
	}

	public void setUpdatedAtStringFormation(String updatedAtStringFormation) {
		this.updatedAtStringFormation = updatedAtStringFormation;
	}

	public ArrayList<Long> getSelectedEnabledFormation() {
		return selectedEnabledFormation;
	}

	public void setSelectedEnabledFormation(
			ArrayList<Long> selectedEnabledFormation) {
		this.selectedEnabledFormation = selectedEnabledFormation;
	}

	public FormationDTO[] getFormationDTOArray() {
		formationDTOArray = listFormation();
		return formationDTOArray;
	}

	public void setFormationDTOArray(FormationDTO[] formationDTOArray) {
		this.formationDTOArray = formationDTOArray;
	}

	public void setCreatedAtFormation(Date createdAtFormation) {
		this.createdAtFormation = createdAtFormation;
	}

	public void setUpdatedAtFormation(Date updatedAtFormation) {
		this.updatedAtFormation = updatedAtFormation;
	}

	public DepartementDTO getDepartementDtoFormation() {
		return departementDtoFormation;
	}

	public void setDepartementDtoFormation(
			DepartementDTO departementDtoFormation) {
		this.departementDtoFormation = departementDtoFormation;
	}

	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public ArrayList<Long> getSelectedEnabledNiveau() {
		return selectedEnabledNiveau;
	}

	public void setSelectedEnabledNiveau(ArrayList<Long> selectedEnabledNiveau) {
		this.selectedEnabledNiveau = selectedEnabledNiveau;
	}

	public void loadNiveauDTOArray(ValueChangeEvent e) {
		niveauDTOArray = listNiveau();
	}

	public NiveauDTO[] getNiveauDTOArray() {
		niveauDTOArray = listNiveau();
		return niveauDTOArray;
	}

	public void setNiveauDTOArray(NiveauDTO[] niveauDTOArray) {
		this.niveauDTOArray = niveauDTOArray;
	}
}