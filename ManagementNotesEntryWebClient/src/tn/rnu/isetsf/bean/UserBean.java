package tn.rnu.isetsf.bean;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.axis2.AxisFault;

import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.AdministrateurDTO;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.FindAdministrateurByUserNamePassword;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.GetAdministrateurById;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.GetAdministrateurByUserNamePassword;
import tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.ModifierAdministrateur;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.EnseignantDTO;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.FindEnseignantByUserNamePassword;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetEnseignantById;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetEnseignantByUserNamePassword;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.ModifierEnseignant;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.EtudiantDTO;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantById;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.GetEtudiantByUserNamePassword;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.ModifierEtudiant;
import tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.NiveauDTO;
import tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionUtilisateurServiceStub.FindUtilisateurByUserNamePassword;

@SuppressWarnings("serial")
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {
	private Long idUser = (long) 0;
	private Date createdAtUser = null;
	private String createdAtStringUser = "";
	private String emailUser = "";
	private byte enabledUser = 0;
	private String lastNameUser = "";
	private String nameUser = "";
	private String passwordUser = "";
	private Date updatedAtUser = null;
	private String updatedAtStringUser = "";
	private String userNameUser = "";
	private tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.RoleDTO roleDtoAdminUser = null;
	private tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.RoleDTO roleDtoEnsUser = null;
	private tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.RoleDTO roleDtoEtudUser = null;
	private String posteAdminUser = "";
	private String titreEnsUser = "";
	private Long cinEtudUser = (long) 0;
	private Long numInscritEtudUser = (long) 0;
	private Date dateNaissEtudUser = null;
	private String dateNaissStringEtudUser = "";
	private NiveauDTO niveauDtoEtudUser = null;
	private String typeUser = "";

	public String signUser() {
		try {
			GestionUtilisateurServiceStub userStub = new GestionUtilisateurServiceStub();
			FindUtilisateurByUserNamePassword userByUserNamePassword = new FindUtilisateurByUserNamePassword();
			userByUserNamePassword.setArg0(userNameUser);
			userByUserNamePassword.setArg1(passwordUser);
			FacesContext fc = FacesContext.getCurrentInstance();
			SimpleDateFormat format1 = new SimpleDateFormat(
					"dd/MM/yyyy HH:mm:ss");
			SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
			if (userStub.findUtilisateurByUserNamePassword(
					userByUserNamePassword).get_return()) {
				GestionAdministrateurServiceStub adminStub = new GestionAdministrateurServiceStub();
				FindAdministrateurByUserNamePassword findAdminByUserNamePassword = new FindAdministrateurByUserNamePassword();
				findAdminByUserNamePassword.setArg0(userNameUser);
				findAdminByUserNamePassword.setArg1(passwordUser);
				if (adminStub.findAdministrateurByUserNamePassword(
						findAdminByUserNamePassword).get_return()) {
					GetAdministrateurByUserNamePassword adminByUserNamePassword = new GetAdministrateurByUserNamePassword();
					adminByUserNamePassword.setArg0(userNameUser);
					adminByUserNamePassword.setArg1(passwordUser);
					AdministrateurDTO adminDto = adminStub
							.getAdministrateurByUserNamePassword(
									adminByUserNamePassword).get_return();
					createdAtStringUser = adminDto.getCreatedAtString();
					try {
						createdAtUser = format1.parse(createdAtStringUser);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					idUser=adminDto.getId();
					emailUser = adminDto.getEmail();
					enabledUser = adminDto.getEnabled();
					lastNameUser = adminDto.getLastName();
					nameUser = adminDto.getName();
					passwordUser = adminDto.getPassword();
					posteAdminUser = adminDto.getPoste();
					roleDtoAdminUser = adminDto.getRoleDto();
					updatedAtStringUser = adminDto.getUpdatedAtString();
					try {
						updatedAtUser = format1.parse(updatedAtStringUser);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					userNameUser = adminDto.getUserName();
					typeUser = "Admin";
				} else {
					GestionEnseignantServiceStub ensStub = new GestionEnseignantServiceStub();
					FindEnseignantByUserNamePassword findEnsByUserNamePassword = new FindEnseignantByUserNamePassword();
					findEnsByUserNamePassword.setArg0(userNameUser);
					findEnsByUserNamePassword.setArg1(passwordUser);
					if (!ensStub.findEnseignantByUserNamePassword(
							findEnsByUserNamePassword).get_return()) {
						GetEnseignantByUserNamePassword ensByUserNamePassword = new GetEnseignantByUserNamePassword();
						ensByUserNamePassword.setArg0(userNameUser);
						ensByUserNamePassword.setArg1(passwordUser);
						EnseignantDTO ensDto = ensStub
								.getEnseignantByUserNamePassword(
										ensByUserNamePassword).get_return();
						createdAtStringUser = ensDto.getCreatedAtString();
						try {
							createdAtUser = format1.parse(createdAtStringUser);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						idUser=ensDto.getId();
						emailUser = ensDto.getEmail();
						enabledUser = ensDto.getEnabled();
						lastNameUser = ensDto.getLastName();
						nameUser = ensDto.getName();
						passwordUser = ensDto.getPassword();
						titreEnsUser = ensDto.getTitre();
						roleDtoEnsUser = ensDto.getRoleDto();
						updatedAtStringUser = ensDto.getUpdatedAtString();
						try {
							updatedAtUser = format1.parse(updatedAtStringUser);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						userNameUser = ensDto.getUserName();
						typeUser = "Ens";
					} else {
						GestionEtudiantServiceStub etudStub = new GestionEtudiantServiceStub();
						GetEtudiantByUserNamePassword etudByUserNamePassword = new GetEtudiantByUserNamePassword();
						etudByUserNamePassword.setArg0(userNameUser);
						etudByUserNamePassword.setArg1(passwordUser);
						EtudiantDTO etudDto = etudStub
								.getEtudiantByUserNamePassword(
										etudByUserNamePassword).get_return();
						createdAtStringUser = etudDto.getCreatedAtString();
						try {
							createdAtUser = format1.parse(createdAtStringUser);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						idUser=etudDto.getId();
						emailUser = etudDto.getEmail();
						enabledUser = etudDto.getEnabled();
						lastNameUser = etudDto.getLastName();
						nameUser = etudDto.getName();
						passwordUser = etudDto.getPassword();
						cinEtudUser = etudDto.getCin();
						numInscritEtudUser = etudDto.getNumInscrit();
						dateNaissStringEtudUser = etudDto
								.getDateNaissanceString();
						try {
							dateNaissEtudUser = format2
									.parse(dateNaissStringEtudUser);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						roleDtoEtudUser = etudDto.getRoleDto();
						niveauDtoEtudUser = etudDto.getNiveauDto();
						updatedAtStringUser = etudDto.getUpdatedAtString();
						try {
							updatedAtUser = format1.parse(updatedAtStringUser);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						userNameUser = etudDto.getUserName();
						typeUser = "Etud";
					}
				}
				return "doLogin";
			} else {
				fc.addMessage("userNameForm", new FacesMessage(
						"Username or password is incorrect"));
				userNameUser = "";
				passwordUser = "";
				return "";
			}
		} catch (RemoteException e) {

			e.printStackTrace();
		}
		return "";
	}

	public String modifierUser() {
		String direction = "";
		if (typeUser.equals("Admin"))
			direction = modifierAdmin();
		else if (typeUser.equals("Ens"))
			direction = modifierEns();
		else if (typeUser.equals("Etud"))
			direction = modifierEtud();
		return direction;
	}

	public String modifierEtud() {
		try {
			GestionEtudiantServiceStub etudStub = new GestionEtudiantServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetEtudiantById etudById = new GetEtudiantById();
			etudById.setArg0(idUser);
			EtudiantDTO etudDto = etudStub.getEtudiantById(etudById)
					.get_return();
			ModifierEtudiant etudDtoEditParam = new ModifierEtudiant();
			etudDto.setEmail(emailUser);
			// TODO etudDto.setEnabled(enabledEtud);
			etudDto.setLastName(lastNameUser);
			etudDto.setName(nameUser);
			etudDto.setPassword(passwordUser);
			etudDto.setCin(cinEtudUser);
			etudDto.setNumInscrit(numInscritEtudUser);
			etudDto.setUserName(userNameUser);
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			dateNaissStringEtudUser = format1.format(dateNaissEtudUser);
			etudDto.setDateNaissanceString(dateNaissStringEtudUser);
			// TODO etudDto.setNiveauDTO(NiveauEtud);
			etudDtoEditParam.setArg0(etudDto);
			etudStub.modifierEtudiant(etudDtoEditParam);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "profile";
	}

	public String modifierEns() {
		try {
			GestionEnseignantServiceStub ensStub = new GestionEnseignantServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetEnseignantById ensById = new GetEnseignantById();
			ensById.setArg0(idUser);
			EnseignantDTO ensDto = ensStub.getEnseignantById(ensById)
					.get_return();
			ModifierEnseignant ensDtoEditParam = new ModifierEnseignant();
			ensDto.setEmail(emailUser);
			// TODO etudDto.setEnabled(enabledEtud);
			ensDto.setLastName(lastNameUser);
			ensDto.setName(nameUser);
			ensDto.setPassword(passwordUser);
			ensDto.setTitre(titreEnsUser);
			ensDto.setUserName(userNameUser);
			ensDtoEditParam.setArg0(ensDto);
			ensStub.modifierEnseignant(ensDtoEditParam);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "profile";
	}

	public String modifierAdmin() {
		try {
			GestionAdministrateurServiceStub adminStub = new GestionAdministrateurServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetAdministrateurById adminById = new GetAdministrateurById();
			adminById.setArg0(idUser);
			AdministrateurDTO adminDto = adminStub.getAdministrateurById(
					adminById).get_return();
			ModifierAdministrateur adminDtoEditParam = new ModifierAdministrateur();
			adminDto.setEmail(emailUser);
			// TODO etudDto.setEnabled(enabledEtud);
			adminDto.setLastName(lastNameUser);
			adminDto.setName(nameUser);
			adminDto.setPassword(passwordUser);
			adminDto.setPoste(posteAdminUser);
			adminDto.setUserName(userNameUser);
			adminDtoEditParam.setArg0(adminDto);
			adminStub.modifierAdministrateur(adminDtoEditParam);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "profile";
	}

	public String disconnectUser() {
		idUser=(long)0;
		createdAtUser = null;
		createdAtStringUser = "";
		emailUser = "";
		enabledUser = 0;
		lastNameUser = "";
		nameUser = "";
		passwordUser = "";
		roleDtoAdminUser = null;
		updatedAtUser = null;
		updatedAtStringUser = "";
		userNameUser = "";
		posteAdminUser = "";
		titreEnsUser = "";
		roleDtoEnsUser = null;
		cinEtudUser = (long) 0;
		dateNaissEtudUser = null;
		dateNaissStringEtudUser = "";
		numInscritEtudUser = (long) 0;
		roleDtoEtudUser = null;
		niveauDtoEtudUser = null;
		typeUser = "";
		return "loggedout";
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Date getCreatedAtUser() {
		return createdAtUser;
	}

	public void setCreatedAtUser(Date createdAtUser) {
		this.createdAtUser = createdAtUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public byte getEnabledUser() {
		return enabledUser;
	}

	public void setEnabledUser(byte enabledUser) {
		this.enabledUser = enabledUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public Date getUpdatedAtUser() {
		return updatedAtUser;
	}

	public void setUpdatedAtUser(Date updatedAtUser) {
		this.updatedAtUser = updatedAtUser;
	}

	public String getUserNameUser() {
		return userNameUser;
	}

	public void setUserNameUser(String userNameUser) {
		this.userNameUser = userNameUser;
	}

	public tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.RoleDTO getRoleDtoAdminUser() {
		return roleDtoAdminUser;
	}

	public void setRoleDtoAdminUser(
			tn.rnu.isetsf.service.utilisateur.GestionAdministrateurServiceStub.RoleDTO roleDtoAdminUser) {
		this.roleDtoAdminUser = roleDtoAdminUser;
	}

	public tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.RoleDTO getRoleDtoEnsUser() {
		return roleDtoEnsUser;
	}

	public void setRoleDtoEnsUser(
			tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.RoleDTO roleDtoEnsUser) {
		this.roleDtoEnsUser = roleDtoEnsUser;
	}

	public tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.RoleDTO getRoleDtoEtudUser() {
		return roleDtoEtudUser;
	}

	public void setRoleDtoEtudUser(
			tn.rnu.isetsf.service.utilisateur.GestionEtudiantServiceStub.RoleDTO roleDtoEtudUser) {
		this.roleDtoEtudUser = roleDtoEtudUser;
	}

	public String getPosteAdminUser() {
		return posteAdminUser;
	}

	public void setPosteAdminUser(String posteAdminUser) {
		this.posteAdminUser = posteAdminUser;
	}

	public String getTitreEnsUser() {
		return titreEnsUser;
	}

	public void setTitreEnsUser(String titreEnsUser) {
		this.titreEnsUser = titreEnsUser;
	}

	public Long getCinEtudUser() {
		return cinEtudUser;
	}

	public void setCinEtudUser(Long cinEtudUser) {
		this.cinEtudUser = cinEtudUser;
	}

	public Long getNumInscritEtudUser() {
		return numInscritEtudUser;
	}

	public void setNumInscritEtudUser(Long numInscritEtudUser) {
		this.numInscritEtudUser = numInscritEtudUser;
	}

	public Date getDateNaissEtudUser() {
		return dateNaissEtudUser;
	}

	public void setDateNaissEtudUser(Date dateNaissEtudUser) {
		this.dateNaissEtudUser = dateNaissEtudUser;
	}

	public NiveauDTO getNiveauDtoEtudUser() {
		return niveauDtoEtudUser;
	}

	public void setNiveauDtoEtudUser(NiveauDTO niveauDtoEtudUser) {
		this.niveauDtoEtudUser = niveauDtoEtudUser;
	}

	public String getCreatedAtStringUser() {
		return createdAtStringUser;
	}

	public void setCreatedAtStringUser(String createdAtStringUser) {
		this.createdAtStringUser = createdAtStringUser;
	}

	public String getUpdatedAtStringUser() {
		return updatedAtStringUser;
	}

	public void setUpdatedAtStringUser(String updatedAtStringUser) {
		this.updatedAtStringUser = updatedAtStringUser;
	}

	public String getDateNaissStringEtudUser() {
		return dateNaissStringEtudUser;
	}

	public void setDateNaissStringEtudUser(String dateNaissStringEtudUser) {
		this.dateNaissStringEtudUser = dateNaissStringEtudUser;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
}