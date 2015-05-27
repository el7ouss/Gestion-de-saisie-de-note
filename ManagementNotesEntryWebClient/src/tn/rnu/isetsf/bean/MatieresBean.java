package tn.rnu.isetsf.bean;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.axis2.AxisFault;

import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.CourDTO;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.CourDTOArray;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.GetCoursOfMatiereArray;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.MatiereDTO;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.MatiereDTOArray;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.CreerMatiere;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.GetMatiereById;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.GetMatieresArray;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.ModifierMatiere;

@SuppressWarnings("serial")
@ManagedBean(name = "matieresBean")
@SessionScoped
public class MatieresBean implements Serializable {
	private Long idMatiere = (long) 0;
	private Date createdAtMatiere = null;
	private String createdAtStringMatiere = "";
	private String designationMatiere = "";
	private byte enabledMatiere = 0;
	private String descriptionMatiere = "";
	private Date updatedAtMatiere = null;
	private String updatedAtStringMatiere = "";
	private ArrayList<Long> selectedEnabledMatiere;
	private ArrayList<Long> selectedEnabledCour;
	private MatiereDTO[] matiereDTOArray = null;
	private CourDTO[] courDTOArray = null;

	public MatiereDTO[] listMatiere() {
		MatiereDTO[] matiereDTOArray = null;
		selectedEnabledMatiere = new ArrayList<Long>();
		try {
			GestionMatiereServiceStub matiereStub = new GestionMatiereServiceStub();
			GetMatieresArray matieresArray = new GetMatieresArray();
			MatiereDTOArray matiereDtoArray = matiereStub.getMatieresArray(
					matieresArray).get_return();
			matiereDTOArray = matiereDtoArray.getItem();
			for (MatiereDTO matiereDto : matiereDTOArray)
				if (matiereDto.getEnabled() == (byte) 1)
					selectedEnabledMatiere.add(matiereDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return matiereDTOArray;
	}

	private CourDTO[] listCour() {
		CourDTO[] courDTOArray = null;
		selectedEnabledCour = new ArrayList<Long>();
		try {
			GestionMatiereServiceStub matiereStub = new GestionMatiereServiceStub();
			GetMatiereById matiereById = new GetMatiereById();
			matiereById.setArg0(idMatiere);
			MatiereDTO matiereDto = matiereStub.getMatiereById(matiereById)
					.get_return();
			GetCoursOfMatiereArray coursArray = new GetCoursOfMatiereArray();
			coursArray.setArg0(matiereDto);
			CourDTOArray courDtoArray = matiereStub.getCoursOfMatiereArray(
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

	public String ajoutMatiere() {
		try {
			GestionMatiereServiceStub matiereStub = new GestionMatiereServiceStub();
			CreerMatiere matiere = new CreerMatiere();
			MatiereDTO matiereDto = new MatiereDTO();
			matiereDto.setDescription(descriptionMatiere);
			matiereDto.setDesignation(designationMatiere);
			matiere.setArg0(matiereDto);
			matiereStub.creerMatiere(matiere);
			initialAttributes();
			return "matieres";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String modifierMatiere() {
		try {
			GestionMatiereServiceStub matiereStub = new GestionMatiereServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetMatiereById matiereById = new GetMatiereById();
			matiereById.setArg0(idMatiere);
			MatiereDTO matiereDto = matiereStub.getMatiereById(matiereById)
					.get_return();
			ModifierMatiere matiereDtoEditParam = new ModifierMatiere();
			matiereDto.setDescription(descriptionMatiere);
			// TODO etudDto.setEnabled(enabledEtud);
			matiereDto.setDesignation(designationMatiere);
			matiereDtoEditParam.setArg0(matiereDto);
			matiereStub.modifierMatiere(matiereDtoEditParam);
			initialAttributes();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "matieres";
	}

	public void initialAttributes() {
		createdAtMatiere = null;
		createdAtStringMatiere = "";
		descriptionMatiere = "";
		enabledMatiere = (byte) 0;
		designationMatiere = "";
		updatedAtMatiere = null;
		updatedAtStringMatiere = "";
	}

	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}

	public Date getCreatedAtMatiere() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			createdAtMatiere = format1.parse(createdAtStringMatiere);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createdAtMatiere;
	}

	public Date getUpdatedAtMatiere() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			updatedAtMatiere = format1.parse(updatedAtStringMatiere);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updatedAtMatiere;
	}

	public String getCreatedAtStringMatiere() {
		return createdAtStringMatiere;
	}

	public void setCreatedAtStringMatiere(String createdAtStringMatiere) {
		this.createdAtStringMatiere = createdAtStringMatiere;
	}

	public String getDesignationMatiere() {
		return designationMatiere;
	}

	public void setDesignationMatiere(String designationMatiere) {
		this.designationMatiere = designationMatiere;
	}

	public byte getEnabledMatiere() {
		return enabledMatiere;
	}

	public void setEnabledMatiere(byte enabledMatiere) {
		this.enabledMatiere = enabledMatiere;
	}

	public String getDescriptionMatiere() {
		return descriptionMatiere;
	}

	public void setDescriptionMatiere(String descriptionMatiere) {
		this.descriptionMatiere = descriptionMatiere;
	}

	public String getUpdatedAtStringMatiere() {
		return updatedAtStringMatiere;
	}

	public void setUpdatedAtStringMatiere(String updatedAtStringMatiere) {
		this.updatedAtStringMatiere = updatedAtStringMatiere;
	}

	public ArrayList<Long> getSelectedEnabledMatiere() {
		return selectedEnabledMatiere;
	}

	public void setSelectedEnabledMatiere(ArrayList<Long> selectedEnabledMatiere) {
		this.selectedEnabledMatiere = selectedEnabledMatiere;
	}

	public MatiereDTO[] getMatiereDTOArray() {
		matiereDTOArray = listMatiere();
		return matiereDTOArray;
	}

	public void setMatiereDTOArray(MatiereDTO[] matiereDTOArray) {
		this.matiereDTOArray = matiereDTOArray;
	}

	public void setCreatedAtMatiere(Date createdAtMatiere) {
		this.createdAtMatiere = createdAtMatiere;
	}

	public void setUpdatedAtMatiere(Date updatedAtMatiere) {
		this.updatedAtMatiere = updatedAtMatiere;
	}

	public ArrayList<Long> getSelectedEnabledCour() {
		return selectedEnabledCour;
	}

	public void setSelectedEnabledCour(ArrayList<Long> selectedEnabledCour) {
		this.selectedEnabledCour = selectedEnabledCour;
	}

	public CourDTO[] getCourDTOArray() {
		courDTOArray = listCour();
		return courDTOArray;
	}

	public void setCourDTOArray(CourDTO[] courDTOArray) {
		this.courDTOArray = courDTOArray;
	}
}