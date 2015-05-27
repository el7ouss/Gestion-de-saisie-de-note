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

import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.AdministrateurDTO;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.AdministrateurDTOArray;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.CreerAdministrateur;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.FindAdministrateurByUserName;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.GetAdministrateurById;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.GetAdministrateursArray;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.ModifierAdministrateur;
import tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub.GetRoleById;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.RoleDTO;

@SuppressWarnings("serial")
@ManagedBean(name = "administrateursBean")
@SessionScoped
public class AdministrateursBean implements Serializable {
	private Long idAdmin = (long) 0;
	private Date createdAtAdmin = null;
	private String createdAtStringAdmin = "";
	private String emailAdmin = "";
	private byte enabledAdmin = 0;
	private String lastNameAdmin = "";
	private String nameAdmin = "";
	private String passwordAdmin = "";
	private Date updatedAtAdmin = null;
	private String updatedAtStringAdmin = "";
	private String userNameAdmin = "";
	private ArrayList<Long> selectedEnabledAdmin;
	private RoleDTO roleDtoAdmin;
	private String posteAdmin = "";
	private AdministrateurDTO[] adminDTOArray = null;

	public AdministrateurDTO[] listAdmin() {
		AdministrateurDTO[] adminDTOArray = null;
		selectedEnabledAdmin = new ArrayList<Long>();
		try {
			GestionAdministrateurServiceStub adminStub = new GestionAdministrateurServiceStub();
			GetAdministrateursArray administrateursArray = new GetAdministrateursArray();
			AdministrateurDTOArray administrateurDTOArray = adminStub
					.getAdministrateursArray(administrateursArray).get_return();
			adminDTOArray = administrateurDTOArray.getItem();
			for (AdministrateurDTO adminDto : adminDTOArray)
				if (adminDto.getEnabled() == (byte) 1)
					selectedEnabledAdmin.add(adminDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return adminDTOArray;
	}

	public String ajoutAdmin() {
		try {
			GestionAdministrateurServiceStub adminStub = new GestionAdministrateurServiceStub();
			FacesContext fc = FacesContext.getCurrentInstance();
			FindAdministrateurByUserName adminByUserName = new FindAdministrateurByUserName();
			adminByUserName.setArg0(userNameAdmin);
			if (adminStub.findAdministrateurByUserName(adminByUserName)
					.get_return() == false) {
				CreerAdministrateur admin = new CreerAdministrateur();
				AdministrateurDTO adminDto = new AdministrateurDTO();
				adminDto.setEmail(emailAdmin);
				adminDto.setLastName(lastNameAdmin);
				adminDto.setName(nameAdmin);
				adminDto.setPassword(passwordAdmin);
				adminDto.setPoste(posteAdmin);
				adminDto.setUserName(userNameAdmin);
				GestionRoleServiceStub roleStub = new GestionRoleServiceStub();
				GetRoleById roleById = new GetRoleById();
				roleById.setArg0((long) 1);
				roleDtoAdmin = new RoleDTO();
				roleDtoAdmin.setCreatedAt(roleStub.getRoleById(roleById)
						.get_return().getCreatedAt());
				roleDtoAdmin.setDescription(roleStub.getRoleById(roleById)
						.get_return().getDescription());
				roleDtoAdmin.setDesignation(roleStub.getRoleById(roleById)
						.get_return().getDesignation());
				roleDtoAdmin.setEnabled(roleStub.getRoleById(roleById)
						.get_return().getEnabled());
				roleDtoAdmin.setId(roleStub.getRoleById(roleById).get_return()
						.getId());
				roleDtoAdmin.setUpdatedAt(roleStub.getRoleById(roleById)
						.get_return().getUpdatedAt());
				adminDto.setRoleDto(roleDtoAdmin);
				admin.setArg0(adminDto);
				adminStub.creerAdministrateur(admin);
				initialAttributes();
				return "administrateurs";
			} else {
				fc.addMessage("saveForm", new FacesMessage(
						"Utilisateur existe déjà"));
				initialAttributes();
				return "";
			}
		} catch (RemoteException e) {

			e.printStackTrace();
		}
		return "";
	}

	public String modifierAdmin() {
		try {
			GestionAdministrateurServiceStub adminStub = new GestionAdministrateurServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetAdministrateurById adminById = new GetAdministrateurById();
			adminById.setArg0(idAdmin);
			AdministrateurDTO adminDto = adminStub.getAdministrateurById(
					adminById).get_return();
			ModifierAdministrateur adminDtoEditParam = new ModifierAdministrateur();
			adminDto.setEmail(emailAdmin);
			// TODO etudDto.setEnabled(enabledEtud);
			adminDto.setLastName(lastNameAdmin);
			adminDto.setName(nameAdmin);
			adminDto.setPassword(passwordAdmin);
			adminDto.setPoste(posteAdmin);
			adminDto.setUserName(userNameAdmin);
			adminDtoEditParam.setArg0(adminDto);
			adminStub.modifierAdministrateur(adminDtoEditParam);
			initialAttributes();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "administrateurs";
	}

	public void initialAttributes() {
		createdAtAdmin = null;
		emailAdmin = "";
		enabledAdmin = (byte) 0;
		lastNameAdmin = "";
		nameAdmin = "";
		passwordAdmin = "";
		posteAdmin = "";
		roleDtoAdmin = null;
		updatedAtAdmin = null;
		userNameAdmin = "";
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Date getCreatedAtAdmin() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			createdAtAdmin = format1.parse(createdAtStringAdmin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createdAtAdmin;
	}

	public void setCreatedAtAdmin(Date createdAtAdmin) {
		this.createdAtAdmin = createdAtAdmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public byte getEnabledAdmin() {
		return enabledAdmin;
	}

	public void setEnabledAdmin(byte enabledAdmin) {
		this.enabledAdmin = enabledAdmin;
	}

	public String getLastNameAdmin() {
		return lastNameAdmin;
	}

	public void setLastNameAdmin(String lastNameAdmin) {
		this.lastNameAdmin = lastNameAdmin;
	}

	public String getNameAdmin() {
		return nameAdmin;
	}

	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	public Date getUpdatedAtAdmin() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			updatedAtAdmin = format1.parse(updatedAtStringAdmin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updatedAtAdmin;
	}

	public void setUpdatedAtAdmin(Date updatedAtAdmin) {
		this.updatedAtAdmin = updatedAtAdmin;
	}

	public String getUserNameAdmin() {
		return userNameAdmin;
	}

	public void setUserNameAdmin(String userNameAdmin) {
		this.userNameAdmin = userNameAdmin;
	}

	public ArrayList<Long> getSelectedEnabledAdmin() {
		return selectedEnabledAdmin;
	}

	public void setSelectedEnabledAdmin(ArrayList<Long> selectedEnabledAdmin) {
		this.selectedEnabledAdmin = selectedEnabledAdmin;
	}

	public RoleDTO getRoleDtoAdmin() {
		return roleDtoAdmin;
	}

	public void setRoleDtoAdmin(RoleDTO roleDtoAdmin) {
		this.roleDtoAdmin = roleDtoAdmin;
	}

	public String getPosteAdmin() {
		return posteAdmin;
	}

	public void setPosteAdmin(String posteAdmin) {
		this.posteAdmin = posteAdmin;
	}

	public AdministrateurDTO[] getAdminDTOArray() {
		adminDTOArray = listAdmin();
		return adminDTOArray;
	}

	public void setAdminDTOArray(AdministrateurDTO[] adminDTOArray) {
		this.adminDTOArray = adminDTOArray;
	}

	public String getCreatedAtStringAdmin() {
		return createdAtStringAdmin;
	}

	public void setCreatedAtStringAdmin(String createdAtStringAdmin) {
		this.createdAtStringAdmin = createdAtStringAdmin;
	}

	public String getUpdatedAtStringAdmin() {
		return updatedAtStringAdmin;
	}

	public void setUpdatedAtStringAdmin(String updatedAtStringAdmin) {
		this.updatedAtStringAdmin = updatedAtStringAdmin;
	}
}