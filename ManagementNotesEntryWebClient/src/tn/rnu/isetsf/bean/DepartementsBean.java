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
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.DepartementDTO;
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.DepartementDTOArray;
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.CreerDepartement;
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.FormationDTO;
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.FormationDTOArray;
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.GetDepartementById;
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.GetDepartementsArray;
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.GetFormationsOfDepartementArray;
import tn.rnu.isetsf.service.parametres.GestionDepartementServiceStub.ModifierDepartement;

@SuppressWarnings("serial")
@ManagedBean(name = "departementsBean")
@SessionScoped
public class DepartementsBean implements Serializable {
	private Long idDepartement = (long) 0;
	private Date createdAtDepartement = null;
	private String createdAtStringDepartement = "";
	private String designationDepartement = "";
	private byte enabledDepartement = 0;
	private String descriptionDepartement = "";
	private Date updatedAtDepartement = null;
	private String updatedAtStringDepartement = "";
	private ArrayList<Long> selectedEnabledDepartement;
	private ArrayList<Long> selectedEnabledFormation;
	private DepartementDTO[] departementDTOArray = null;
	private FormationDTO[] formationDTOArray = null;

	public DepartementDTO[] listDepartement() {
		DepartementDTO[] departementDTOArray = null;
		selectedEnabledDepartement = new ArrayList<Long>();
		try {
			GestionDepartementServiceStub departementStub = new GestionDepartementServiceStub();
			GetDepartementsArray departementsArray = new GetDepartementsArray();
			DepartementDTOArray departementDtoArray = departementStub
					.getDepartementsArray(departementsArray).get_return();
			departementDTOArray = departementDtoArray.getItem();
			for (DepartementDTO departementDto : departementDTOArray)
				if (departementDto.getEnabled() == (byte) 1)
					selectedEnabledDepartement.add(departementDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return departementDTOArray;
	}

	public FormationDTO[] listFormation() {
		FormationDTO[] formationDTOArray = null;
		selectedEnabledFormation = new ArrayList<Long>();
		try {
			GestionDepartementServiceStub departementStub = new GestionDepartementServiceStub();
			GetDepartementById departementById = new GetDepartementById();
			departementById.setArg0(idDepartement);
			DepartementDTO departementDto = departementStub.getDepartementById(
					departementById).get_return();
			GetFormationsOfDepartementArray formationsArray = new GetFormationsOfDepartementArray();
			formationsArray.setArg0(departementDto);
			FormationDTOArray formationDtoArray = departementStub
					.getFormationsOfDepartementArray(formationsArray)
					.get_return();
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

	public String ajoutDepartement() {
		try {
			GestionDepartementServiceStub departementStub = new GestionDepartementServiceStub();
			CreerDepartement departement = new CreerDepartement();
			DepartementDTO departementDto = new DepartementDTO();
			departementDto.setDescription(descriptionDepartement);
			departementDto.setDesignation(designationDepartement);
			departement.setArg0(departementDto);
			departementStub.creerDepartement(departement);
			initialAttributes();
			return "departements";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String modifierDepartement() {
		try {
			GestionDepartementServiceStub departementStub = new GestionDepartementServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetDepartementById departementById = new GetDepartementById();
			departementById.setArg0(idDepartement);
			DepartementDTO departementDto = departementStub.getDepartementById(
					departementById).get_return();
			ModifierDepartement departementDtoEditParam = new ModifierDepartement();
			departementDto.setDescription(descriptionDepartement);
			// TODO etudDto.setEnabled(enabledEtud);
			departementDto.setDesignation(designationDepartement);
			departementDtoEditParam.setArg0(departementDto);
			departementStub.modifierDepartement(departementDtoEditParam);
			initialAttributes();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "departements";
	}

	public void initialAttributes() {
		createdAtDepartement = null;
		createdAtStringDepartement = "";
		descriptionDepartement = "";
		enabledDepartement = (byte) 0;
		designationDepartement = "";
		updatedAtDepartement = null;
		updatedAtStringDepartement = "";
	}

	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public Date getCreatedAtDepartement() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			createdAtDepartement = format1.parse(createdAtStringDepartement);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createdAtDepartement;
	}

	public Date getUpdatedAtDepartement() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			updatedAtDepartement = format1.parse(updatedAtStringDepartement);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updatedAtDepartement;
	}

	public String getCreatedAtStringDepartement() {
		return createdAtStringDepartement;
	}

	public void setCreatedAtStringDepartement(String createdAtStringDepartement) {
		this.createdAtStringDepartement = createdAtStringDepartement;
	}

	public String getDesignationDepartement() {
		return designationDepartement;
	}

	public void setDesignationDepartement(String designationDepartement) {
		this.designationDepartement = designationDepartement;
	}

	public byte getEnabledDepartement() {
		return enabledDepartement;
	}

	public void setEnabledDepartement(byte enabledDepartement) {
		this.enabledDepartement = enabledDepartement;
	}

	public String getDescriptionDepartement() {
		return descriptionDepartement;
	}

	public void setDescriptionDepartement(String descriptionDepartement) {
		this.descriptionDepartement = descriptionDepartement;
	}

	public String getUpdatedAtStringDepartement() {
		return updatedAtStringDepartement;
	}

	public void setUpdatedAtStringDepartement(String updatedAtStringDepartement) {
		this.updatedAtStringDepartement = updatedAtStringDepartement;
	}

	public ArrayList<Long> getSelectedEnabledDepartement() {
		return selectedEnabledDepartement;
	}

	public void setSelectedEnabledDepartement(
			ArrayList<Long> selectedEnabledDepartement) {
		this.selectedEnabledDepartement = selectedEnabledDepartement;
	}

	public DepartementDTO[] getDepartementDTOArray() {
		departementDTOArray = listDepartement();
		return departementDTOArray;
	}

	public void setDepartementDTOArray(DepartementDTO[] departementDTOArray) {
		this.departementDTOArray = departementDTOArray;
	}

	public void setCreatedAtDepartement(Date createdAtDepartement) {
		this.createdAtDepartement = createdAtDepartement;
	}

	public void setUpdatedAtDepartement(Date updatedAtDepartement) {
		this.updatedAtDepartement = updatedAtDepartement;
	}

	public void loadFormationDTOArray(ValueChangeEvent e) {
		formationDTOArray = listFormation();
	}
	
	public void loadFormationDTOArray() {
		formationDTOArray = listFormation();
	}

	public FormationDTO[] getFormationDTOArray() {
		formationDTOArray = listFormation();
		return formationDTOArray;
	}

	public void setFormationDTOArray(FormationDTO[] formationDTOArray) {
		this.formationDTOArray = formationDTOArray;
	}

	public ArrayList<Long> getSelectedEnabledFormation() {
		return selectedEnabledFormation;
	}

	public void setSelectedEnabledFormation(
			ArrayList<Long> selectedEnabledFormation) {
		this.selectedEnabledFormation = selectedEnabledFormation;
	}
}