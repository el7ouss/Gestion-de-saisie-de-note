package tn.rnu.isetsf.bean;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.axis2.AxisFault;

import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.CourDTO;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.CourDTOArray;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.EnseignantDTO;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.EnseignantDTOArray;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.CreerEnseignant;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.FindEnseignantByUserName;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetCoursOfEnseignantArray;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetEnseignantById;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetEnseignantsArray;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.ModifierEnseignant;
import tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub.GetRoleById;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.RoleDTO;

@SuppressWarnings("serial")
@ManagedBean(name = "enseignantsBean")
@SessionScoped
public class EnseignantsBean implements Serializable {
	private Long idEns = (long) 0;
	private Date createdAtEns = null;
	private String createdAtStringEns = "";
	private String emailEns = "";
	private byte enabledEns = 0;
	private String lastNameEns = "";
	private String nameEns = "";
	private String passwordEns = "";
	private Date updatedAtEns = null;
	private String updatedAtStringEns = "";
	private String userNameEns = "";
	private ArrayList<Long> selectedEnabledEns;
	private ArrayList<Long> selectedEnabledCour;
	private RoleDTO roleDtoEns;
	private String titreEns = "";
	private EnseignantDTO[] ensDTOArray = null;
	private CourDTO[] courDTOArray = null;

	public EnseignantDTO[] listEns() {
		EnseignantDTO[] ensDTOArray = null;
		selectedEnabledEns = new ArrayList<Long>();
		try {
			GestionEnseignantServiceStub ensStub = new GestionEnseignantServiceStub();
			GetEnseignantsArray enseignantsArray = new GetEnseignantsArray();
			EnseignantDTOArray enseignantDTOArray = ensStub
					.getEnseignantsArray(enseignantsArray).get_return();
			ensDTOArray = enseignantDTOArray.getItem();
			for (EnseignantDTO ensDto : ensDTOArray)
				if (ensDto.getEnabled() == (byte) 1)
					selectedEnabledEns.add(ensDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ensDTOArray;
	}

	private CourDTO[] listCour() {
		CourDTO[] courDTOArray = null;
		selectedEnabledCour = new ArrayList<Long>();
		try {
			GestionEnseignantServiceStub enseignantStub = new GestionEnseignantServiceStub();
			GetEnseignantById enseignantById = new GetEnseignantById();
			enseignantById.setArg0(idEns);
			EnseignantDTO enseignantDto = enseignantStub.getEnseignantById(
					enseignantById).get_return();
			GetCoursOfEnseignantArray coursArray = new GetCoursOfEnseignantArray();
			coursArray.setArg0(enseignantDto);
			CourDTOArray courDtoArray = enseignantStub
					.getCoursOfEnseignantArray(coursArray).get_return();
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

	public String ajoutEns() {
		try {
			GestionEnseignantServiceStub ensStub = new GestionEnseignantServiceStub();
			FacesContext fc = FacesContext.getCurrentInstance();
			FindEnseignantByUserName ensByUserName = new FindEnseignantByUserName();
			ensByUserName.setArg0(userNameEns);
			if (ensStub.findEnseignantByUserName(ensByUserName).get_return() == false) {
				CreerEnseignant ens = new CreerEnseignant();
				EnseignantDTO ensDto = new EnseignantDTO();
				ensDto.setEmail(emailEns);
				ensDto.setLastName(lastNameEns);
				ensDto.setName(nameEns);
				ensDto.setPassword(passwordEns);
				ensDto.setTitre(titreEns);
				ensDto.setUserName(userNameEns);
				GestionRoleServiceStub roleStub = new GestionRoleServiceStub();
				GetRoleById roleById = new GetRoleById();
				roleById.setArg0((long) 2);
				roleDtoEns = new RoleDTO();
				roleDtoEns.setCreatedAt(roleStub.getRoleById(roleById)
						.get_return().getCreatedAt());
				roleDtoEns.setDescription(roleStub.getRoleById(roleById)
						.get_return().getDescription());
				roleDtoEns.setDesignation(roleStub.getRoleById(roleById)
						.get_return().getDesignation());
				roleDtoEns.setEnabled(roleStub.getRoleById(roleById)
						.get_return().getEnabled());
				roleDtoEns.setId(roleStub.getRoleById(roleById).get_return()
						.getId());
				roleDtoEns.setUpdatedAt(roleStub.getRoleById(roleById)
						.get_return().getUpdatedAt());
				ensDto.setRoleDto(roleDtoEns);
				ens.setArg0(ensDto);
				ensStub.creerEnseignant(ens);
				initialAttributes();
				return "enseignants";
			} else {
				fc.addMessage("saveForm", new FacesMessage(
						"Utilisateur existe déjà"));
				initialAttributes();
				return null;
			}
		} catch (RemoteException e) {

			e.printStackTrace();
		}
		return "";
	}

	public String modifierEns() {
		try {
			GestionEnseignantServiceStub ensStub = new GestionEnseignantServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetEnseignantById ensById = new GetEnseignantById();
			ensById.setArg0(idEns);
			EnseignantDTO ensDto = ensStub.getEnseignantById(ensById)
					.get_return();
			ModifierEnseignant ensDtoEditParam = new ModifierEnseignant();
			ensDto.setEmail(emailEns);
			// TODO etudDto.setEnabled(enabledEtud);
			ensDto.setLastName(lastNameEns);
			ensDto.setName(nameEns);
			ensDto.setPassword(passwordEns);
			ensDto.setTitre(titreEns);
			ensDto.setUserName(userNameEns);
			ensDtoEditParam.setArg0(ensDto);
			ensStub.modifierEnseignant(ensDtoEditParam);
			initialAttributes();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "enseignants";
	}

	public void initialAttributes() {
		createdAtEns = null;
		createdAtStringEns = "";
		emailEns = "";
		enabledEns = (byte) 0;
		lastNameEns = "";
		nameEns = "";
		passwordEns = "";
		titreEns = "";
		roleDtoEns = null;
		updatedAtEns = null;
		updatedAtStringEns = "";
		userNameEns = "";
	}

	public Long getIdEns() {
		return idEns;
	}

	public void setIdEns(Long idEns) {
		this.idEns = idEns;
	}

	public Date getCreatedAtEns() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			createdAtEns = format1.parse(createdAtStringEns);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createdAtEns;
	}

	public void setCreatedAtEns(Date createdAtEns) {
		this.createdAtEns = createdAtEns;
	}

	public String getEmailEns() {
		return emailEns;
	}

	public void setEmailEns(String emailEns) {
		this.emailEns = emailEns;
	}

	public byte getEnabledEns() {
		return enabledEns;
	}

	public void setEnabledEns(byte enabledEns) {
		this.enabledEns = enabledEns;
	}

	public String getLastNameEns() {
		return lastNameEns;
	}

	public void setLastNameEns(String lastNameEns) {
		this.lastNameEns = lastNameEns;
	}

	public String getNameEns() {
		return nameEns;
	}

	public void setNameEns(String nameEns) {
		this.nameEns = nameEns;
	}

	public String getPasswordEns() {
		return passwordEns;
	}

	public void setPasswordEns(String passwordEns) {
		this.passwordEns = passwordEns;
	}

	public Date getUpdatedAtEns() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			updatedAtEns = format1.parse(updatedAtStringEns);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updatedAtEns;
	}

	public void setUpdatedAtEns(Date updatedAtEns) {
		this.updatedAtEns = updatedAtEns;
	}

	public String getUserNameEns() {
		return userNameEns;
	}

	public void setUserNameEns(String userNameEns) {
		this.userNameEns = userNameEns;
	}

	public ArrayList<Long> getSelectedEnabledEns() {
		return selectedEnabledEns;
	}

	public void setSelectedEnabledEns(ArrayList<Long> selectedEnabledEns) {
		this.selectedEnabledEns = selectedEnabledEns;
	}

	public RoleDTO getRoleDtoEns() {
		return roleDtoEns;
	}

	public void setRoleDtoEns(RoleDTO roleDtoEns) {
		this.roleDtoEns = roleDtoEns;
	}

	public String getTitreEns() {
		return titreEns;
	}

	public void setTitreEns(String titreEns) {
		this.titreEns = titreEns;
	}

	public EnseignantDTO[] getEnsDTOArray() {
		ensDTOArray = listEns();
		return ensDTOArray;
	}

	public void setEnsDTOArray(EnseignantDTO[] ensDTOArray) {
		this.ensDTOArray = ensDTOArray;
	}

	public String getCreatedAtStringEns() {
		return createdAtStringEns;
	}

	public void setCreatedAtStringEns(String createdAtStringEns) {
		this.createdAtStringEns = createdAtStringEns;
	}

	public String getUpdatedAtStringEns() {
		return updatedAtStringEns;
	}

	public void setUpdatedAtStringEns(String updatedAtStringEns) {
		this.updatedAtStringEns = updatedAtStringEns;
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
