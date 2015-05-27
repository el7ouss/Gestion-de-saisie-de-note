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

import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetNiveauById;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.EtudiantDTO;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.EtudiantDTOArray;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.CreerEtudiant;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.FindEtudiantByUserName;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantById;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantsArray;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.ModifierEtudiant;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.NiveauDTO;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.ValeurDTO;
import tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionRoleServiceStub.GetRoleById;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.RoleDTO;

@SuppressWarnings("serial")
@ManagedBean(name = "etudiantsBean")
@SessionScoped
public class EtudiantsBean implements Serializable {
	private Long idEtud = (long) 0;
	private Date createdAtEtud = null;
	private String createdAtStringEtud = "";
	private String emailEtud = "";
	private byte enabledEtud = 0;
	private String lastNameEtud = "";
	private String nameEtud = "";
	private String passwordEtud = "";
	private Date updatedAtEtud = null;
	private String updatedAtStringEtud = "";
	private String userNameEtud = "";
	private Date dateNaissEtud = null;
	private String dateNaissStringEtud = "";
	private NiveauDTO niveauDtoEtud = null;
	private Long idNiveau = (long) 0;
	private ArrayList<Long> selectedEnabledEtud;
	private ArrayList<Long> selectedEnabledValeur;
	private RoleDTO roleDtoEtud;
	private Long cinEtud = (long) 0;
	private Long numInscritEtud = (long) 0;
	private EtudiantDTO[] etudDTOArray = null;
	private ValeurDTO[] valeurDTOArray = null;

	public EtudiantDTO[] listEtud() {
		EtudiantDTO[] etudDTOArray = null;
		selectedEnabledEtud = new ArrayList<Long>();
		try {
			GestionEtudiantServiceStub etudStub = new GestionEtudiantServiceStub();
			GetEtudiantsArray etudiantsArray = new GetEtudiantsArray();
			EtudiantDTOArray etudiantDTOArray = etudStub.getEtudiantsArray(
					etudiantsArray).get_return();
			etudDTOArray = etudiantDTOArray.getItem();
			for (EtudiantDTO etudDto : etudDTOArray)
				if (etudDto.getEnabled() == (byte) 1)
					selectedEnabledEtud.add(etudDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return etudDTOArray;
	}

	public String ajoutEtud() {
		try {
			GestionEtudiantServiceStub etudStub = new GestionEtudiantServiceStub();
			FacesContext fc = FacesContext.getCurrentInstance();
			FindEtudiantByUserName etudByUserName = new FindEtudiantByUserName();
			etudByUserName.setArg0(userNameEtud);
			if (etudStub.findEtudiantByUserName(etudByUserName).get_return() == false) {
				CreerEtudiant etud = new CreerEtudiant();
				EtudiantDTO etudDto = new EtudiantDTO();
				etudDto.setEmail(emailEtud);
				etudDto.setLastName(lastNameEtud);
				etudDto.setName(nameEtud);
				etudDto.setPassword(passwordEtud);
				etudDto.setCin(cinEtud);
				etudDto.setNumInscrit(numInscritEtud);
				etudDto.setUserName(userNameEtud);
				SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
				dateNaissStringEtud = format1.format(dateNaissEtud);
				etudDto.setDateNaissanceString(dateNaissStringEtud);
				GestionRoleServiceStub roleStub = new GestionRoleServiceStub();
				GetRoleById roleById = new GetRoleById();
				roleById.setArg0((long) 3);
				roleDtoEtud = new RoleDTO();
				roleDtoEtud.setCreatedAt(roleStub.getRoleById(roleById)
						.get_return().getCreatedAt());
				roleDtoEtud.setDescription(roleStub.getRoleById(roleById)
						.get_return().getDescription());
				roleDtoEtud.setDesignation(roleStub.getRoleById(roleById)
						.get_return().getDesignation());
				roleDtoEtud.setEnabled(roleStub.getRoleById(roleById)
						.get_return().getEnabled());
				roleDtoEtud.setId(roleStub.getRoleById(roleById).get_return()
						.getId());
				roleDtoEtud.setUpdatedAt(roleStub.getRoleById(roleById)
						.get_return().getUpdatedAt());
				etudDto.setRoleDto(roleDtoEtud);
				if (idNiveau != 0) {
					GestionNiveauServiceStub niveauStub = new GestionNiveauServiceStub();
					GetNiveauById niveauById = new GetNiveauById();
					niveauById.setArg0(idNiveau);
					niveauDtoEtud = new NiveauDTO();
					niveauDtoEtud.setCreatedAt(niveauStub
							.getNiveauById(niveauById).get_return()
							.getCreatedAt());
					niveauDtoEtud.setDesignation(niveauStub
							.getNiveauById(niveauById).get_return()
							.getDesignation());
					niveauDtoEtud.setEnabled(niveauStub
							.getNiveauById(niveauById).get_return()
							.getEnabled());
					niveauDtoEtud.setId(niveauStub.getNiveauById(niveauById)
							.get_return().getId());
					niveauDtoEtud.setUpdatedAt(niveauStub
							.getNiveauById(niveauById).get_return()
							.getUpdatedAt());
					etudDto.setNiveauDto(niveauDtoEtud);
				}
				etud.setArg0(etudDto);
				etudStub.creerEtudiant(etud);
				initialAttributes();
				return "etudiants";
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

	public String modifierEtud() {
		try {
			GestionEtudiantServiceStub etudStub = new GestionEtudiantServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetEtudiantById etudById = new GetEtudiantById();
			etudById.setArg0(idEtud);
			EtudiantDTO etudDto = etudStub.getEtudiantById(etudById)
					.get_return();
			ModifierEtudiant etudDtoEditParam = new ModifierEtudiant();
			etudDto.setEmail(emailEtud);
			// TODO etudDto.setEnabled(enabledEtud);
			etudDto.setLastName(lastNameEtud);
			etudDto.setName(nameEtud);
			etudDto.setPassword(passwordEtud);
			etudDto.setCin(cinEtud);
			etudDto.setNumInscrit(numInscritEtud);
			etudDto.setUserName(userNameEtud);
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			dateNaissStringEtud = format1.format(dateNaissEtud);
			etudDto.setDateNaissanceString(dateNaissStringEtud);
			if (idNiveau != 0) {
				GestionNiveauServiceStub niveauStub = new GestionNiveauServiceStub();
				GetNiveauById niveauById = new GetNiveauById();
				niveauById.setArg0(idNiveau);
				niveauDtoEtud = new NiveauDTO();
				niveauDtoEtud.setCreatedAt(niveauStub.getNiveauById(niveauById)
						.get_return().getCreatedAt());
				niveauDtoEtud.setDesignation(niveauStub
						.getNiveauById(niveauById).get_return()
						.getDesignation());
				niveauDtoEtud.setEnabled(niveauStub.getNiveauById(niveauById)
						.get_return().getEnabled());
				niveauDtoEtud.setId(niveauStub.getNiveauById(niveauById)
						.get_return().getId());
				niveauDtoEtud.setUpdatedAt(niveauStub.getNiveauById(niveauById)
						.get_return().getUpdatedAt());
				etudDto.setNiveauDto(niveauDtoEtud);
			}
			etudDtoEditParam.setArg0(etudDto);
			etudStub.modifierEtudiant(etudDtoEditParam);
			initialAttributes();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "etudiants";
	}

	public void initialAttributes() {
		createdAtEtud = null;
		createdAtStringEtud = "";
		emailEtud = "";
		enabledEtud = (byte) 0;
		lastNameEtud = "";
		nameEtud = "";
		passwordEtud = "";
		cinEtud = (long) 0;
		numInscritEtud = (long) 0;
		dateNaissStringEtud = "";
		dateNaissEtud = null;
		roleDtoEtud = null;
		updatedAtEtud = null;
		updatedAtStringEtud = "";
		userNameEtud = "";
		niveauDtoEtud = null;
		idNiveau = (long) 0;
	}

	public Long getIdEtud() {
		return idEtud;
	}

	public void setIdEtud(Long idEtud) {
		this.idEtud = idEtud;
	}

	public Date getCreatedAtEtud() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			createdAtEtud = format1.parse(createdAtStringEtud);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createdAtEtud;
	}

	public void setCreatedAtEtud(Date createdAtEtud) {
		this.createdAtEtud = createdAtEtud;
	}

	public String getEmailEtud() {
		return emailEtud;
	}

	public void setEmailEtud(String emailEtud) {
		this.emailEtud = emailEtud;
	}

	public byte getEnabledEtud() {
		return enabledEtud;
	}

	public void setEnabledEtud(byte enabledEtud) {
		this.enabledEtud = enabledEtud;
	}

	public String getLastNameEtud() {
		return lastNameEtud;
	}

	public void setLastNameEtud(String lastNameEtud) {
		this.lastNameEtud = lastNameEtud;
	}

	public String getNameEtud() {
		return nameEtud;
	}

	public void setNameEtud(String nameEtud) {
		this.nameEtud = nameEtud;
	}

	public String getPasswordEtud() {
		return passwordEtud;
	}

	public void setPasswordEtud(String passwordEtud) {
		this.passwordEtud = passwordEtud;
	}

	public Date getUpdatedAtEtud() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			updatedAtEtud = format1.parse(updatedAtStringEtud);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updatedAtEtud;
	}

	public void setUpdatedAtEtud(Date updatedAtEtud) {
		this.updatedAtEtud = updatedAtEtud;
	}

	public String getUserNameEtud() {
		return userNameEtud;
	}

	public void setUserNameEtud(String userNameEtud) {
		this.userNameEtud = userNameEtud;
	}

	public ArrayList<Long> getSelectedEnabledEtud() {
		return selectedEnabledEtud;
	}

	public void setSelectedEnabledEtud(ArrayList<Long> selectedEnabledEtud) {
		this.selectedEnabledEtud = selectedEnabledEtud;
	}

	public RoleDTO getRoleDtoEtud() {
		return roleDtoEtud;
	}

	public void setRoleDtoEtud(RoleDTO roleDtoEtud) {
		this.roleDtoEtud = roleDtoEtud;
	}

	public Long getCinEtud() {
		return cinEtud;
	}

	public void setCinEtud(Long cinEtud) {
		this.cinEtud = cinEtud;
	}

	public EtudiantDTO[] getEtudDTOArray() {
		etudDTOArray = listEtud();
		return etudDTOArray;
	}

	public void setEtudDTOArray(EtudiantDTO[] etudDTOArray) {
		this.etudDTOArray = etudDTOArray;
	}

	public Long getNumInscritEtud() {
		return numInscritEtud;
	}

	public void setNumInscritEtud(Long numInscritEtud) {
		this.numInscritEtud = numInscritEtud;
	}

	public Date getDateNaissEtud() {
		if (!dateNaissStringEtud.equals("")) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dateNaissEtud = format1.parse(dateNaissStringEtud);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dateNaissEtud;
	}

	public void setDateNaissEtud(Date dateNaissEtud) {
		this.dateNaissEtud = dateNaissEtud;
	}

	public String getDateNaissStringEtud() {
		return dateNaissStringEtud;
	}

	public void setDateNaissStringEtud(String dateNaissStringEtud) {
		this.dateNaissStringEtud = dateNaissStringEtud;
	}

	public String getCreatedAtStringEtud() {
		return createdAtStringEtud;
	}

	public void setCreatedAtStringEtud(String createdAtStringEtud) {
		this.createdAtStringEtud = createdAtStringEtud;
	}

	public String getUpdatedAtStringEtud() {
		return updatedAtStringEtud;
	}

	public void setUpdatedAtStringEtud(String updatedAtStringEtud) {
		this.updatedAtStringEtud = updatedAtStringEtud;
	}

	public NiveauDTO getNiveauDtoEtud() {
		return niveauDtoEtud;
	}

	public void setNiveauDtoEtud(NiveauDTO niveauDtoEtud) {
		this.niveauDtoEtud = niveauDtoEtud;
	}

	public Long getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}

	public ArrayList<Long> getSelectedEnabledValeur() {
		return selectedEnabledValeur;
	}

	public void setSelectedEnabledValeur(ArrayList<Long> selectedEnabledValeur) {
		this.selectedEnabledValeur = selectedEnabledValeur;
	}

	public ValeurDTO[] getValeurDTOArray() {
		valeurDTOArray = listValeur();
		return valeurDTOArray;
	}

	private ValeurDTO[]  listValeur() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setValeurDTOArray(ValeurDTO[] valeurDTOArray) {
		this.valeurDTOArray = valeurDTOArray;
	}

}
