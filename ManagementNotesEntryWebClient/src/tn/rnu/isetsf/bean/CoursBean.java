package tn.rnu.isetsf.bean;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.apache.axis2.AxisFault;

import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.EnseignantDTO;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.GetNotesOfCourArray;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.MatiereDTO;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.NoteDTO;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.NoteDTOArray;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub;
import tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.GetMatiereById;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub;
import tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetNiveauById;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.NiveauDTO;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.CourDTO;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.CourDTOArray;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.CreerCour;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.GetCourById;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.GetCoursArray;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.ModifierCour;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub;
import tn.rnu.isetsf.service.utilisateur.GestionEnseignantServiceStub.GetEnseignantById;

@SuppressWarnings("serial")
@ManagedBean(name = "coursBean")
@SessionScoped
public class CoursBean implements Serializable {
	private Long idCour = (long) 0;
	private String anneeUniversitaireCour = "";
	private Date createdAtCour = null;
	private String createdAtStringCour = "";
	private byte enabledCour = 0;
	private Date updatedAtCour = null;
	private String updatedAtStringCour = "";
	private MatiereDTO matiereDtoCour = null;
	private Long idMatiere = (long) 0;
	private EnseignantDTO enseignantDtoCour = null;
	private Long idEnseignant = (long) 0;
	private NiveauDTO niveauDtoCour = null;
	private Long idNiveau = (long) 0;
	private ArrayList<Long> selectedEnabledCour;
	private ArrayList<Long> selectedEnabledNote;
	private CourDTO[] courDTOArray = null;
	private NoteDTO[] noteDTOArray = null;
	private boolean hasTP = true;
	private boolean hasTD = true;
	private boolean hasExamP = true;
	private boolean hasExamR = true;
	@ManagedProperty(value = "#{notesBean}")
	private NotesBean notesBean;
	private Double coefficientTP = (double) 0.1;
	private Double coefficientTD = (double) 0.2;
	private Double coefficientExamP = (double) 0.7;
	private Double coefficientExamR = (double) 0.7;
	private short changedTP = 2;
	private short changedTD = 2;
	private short changedExamP = 2;
	private short changedExamR = 2;

	public void ifTPChanged(ValueChangeEvent e) {
		if (hasTP)
			changedTP = 1;
		else
			changedTP = 0;
	}

	public void ifTDChanged(ValueChangeEvent e) {
		if (hasTD)
			changedTD = 1;
		else
			changedTD = 0;
	}

	public void ifExamPChanged(ValueChangeEvent e) {
		if (hasExamP)
			changedExamP = 1;
		else
			changedExamP = 0;
	}

	public void ifExamRChanged(ValueChangeEvent e) {
		if (hasExamR)
			changedExamR = 1;
		else
			changedExamR = 0;
	}

	public CourDTO[] listCour() {
		CourDTO[] courDTOArray = null;
		selectedEnabledCour = new ArrayList<Long>();
		try {
			GestionCourServiceStub courStub = new GestionCourServiceStub();
			GetCoursArray coursArray = new GetCoursArray();
			CourDTOArray courDtoArray = courStub.getCoursArray(coursArray)
					.get_return();
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

	private NoteDTO[] listNote() {
		NoteDTO[] noteDTOArray = null;
		selectedEnabledNote = new ArrayList<Long>();
		try {
			GestionCourServiceStub courStub = new GestionCourServiceStub();
			GetCourById courById = new GetCourById();
			courById.setArg0(idCour);
			CourDTO courDto = courStub.getCourById(courById).get_return();
			GetNotesOfCourArray notesArray = new GetNotesOfCourArray();
			notesArray.setArg0(courDto);
			NoteDTOArray noteDtoArray = courStub
					.getNotesOfCourArray(notesArray).get_return();
			noteDTOArray = noteDtoArray.getItem();
			for (NoteDTO noteDto : noteDTOArray)
				if (noteDto.getEnabled() == (byte) 1)
					selectedEnabledNote.add(noteDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return noteDTOArray;
	}

	public String ajoutCour() {
		try {
			GestionCourServiceStub courStub = new GestionCourServiceStub();
			CreerCour cour = new CreerCour();
			CourDTO courDto = new CourDTO();
			courDto.setAnneeUniversitaire(anneeUniversitaireCour);
			if (idMatiere != 0) {
				GestionMatiereServiceStub matiereStub = new GestionMatiereServiceStub();
				GetMatiereById matiereById = new GetMatiereById();
				matiereById.setArg0(idMatiere);
				matiereDtoCour = new MatiereDTO();
				matiereDtoCour.setCreatedAt(matiereStub
						.getMatiereById(matiereById).get_return()
						.getCreatedAt());
				matiereDtoCour.setDesignation(matiereStub
						.getMatiereById(matiereById).get_return()
						.getDesignation());
				matiereDtoCour.setEnabled(matiereStub
						.getMatiereById(matiereById).get_return().getEnabled());
				matiereDtoCour.setId(matiereStub.getMatiereById(matiereById)
						.get_return().getId());
				matiereDtoCour.setUpdatedAt(matiereStub
						.getMatiereById(matiereById).get_return()
						.getUpdatedAt());
				courDto.setMatiereDto(matiereDtoCour);
			}
			if (idEnseignant != 0) {
				GestionEnseignantServiceStub enseignantStub = new GestionEnseignantServiceStub();
				GetEnseignantById enseignantById = new GetEnseignantById();
				enseignantById.setArg0(idEnseignant);
				enseignantDtoCour = new EnseignantDTO();
				enseignantDtoCour.setCreatedAt(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getCreatedAt());
				enseignantDtoCour.setTitre(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getTitre());
				enseignantDtoCour.setEnabled(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getEnabled());
				enseignantDtoCour
						.setId(enseignantStub.getEnseignantById(enseignantById)
								.get_return().getId());
				enseignantDtoCour.setUpdatedAt(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getUpdatedAt());
				enseignantDtoCour.setName(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getName());
				enseignantDtoCour.setLastName(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getLastName());
				enseignantDtoCour.setUserName(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getUserName());
				enseignantDtoCour.setEmail(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getEmail());
				enseignantDtoCour.setPassword(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getPassword());
				courDto.setEnseignantDto(enseignantDtoCour);
			}
			if (idNiveau != 0) {
				GestionNiveauServiceStub niveauStub = new GestionNiveauServiceStub();
				GetNiveauById niveauById = new GetNiveauById();
				niveauById.setArg0(idNiveau);
				niveauDtoCour = new NiveauDTO();
				niveauDtoCour.setCreatedAt(niveauStub.getNiveauById(niveauById)
						.get_return().getCreatedAt());
				niveauDtoCour.setDesignation(niveauStub
						.getNiveauById(niveauById).get_return()
						.getDesignation());
				niveauDtoCour.setEnabled(niveauStub.getNiveauById(niveauById)
						.get_return().getEnabled());
				niveauDtoCour.setId(niveauStub.getNiveauById(niveauById)
						.get_return().getId());
				niveauDtoCour.setUpdatedAt(niveauStub.getNiveauById(niveauById)
						.get_return().getUpdatedAt());
				courDto.setNiveauDto(niveauDtoCour);
			}
			cour.setArg0(courDto);
			courStub.creerCour(cour);
			initialAttributes();
			return "cours";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getLastAdded() {
		String result = ajoutCour();
		if (result.equals("cours")) {
			loadCourDTOArray();
			for (CourDTO courDto : courDTOArray) {
				idCour = courDto.getId();
			}
			if (hasTP) {
				notesBean.setIdCour(idCour);
				notesBean.setDesignationNote("TP");
				notesBean.setCoefficientNote(coefficientTP);
				notesBean.setSessionNote("Principale");
				result = notesBean.ajoutNote();
			}
			if (hasTD) {
				notesBean.setIdCour(idCour);
				notesBean.setDesignationNote("TD");
				notesBean.setCoefficientNote(coefficientTD);
				notesBean.setSessionNote("Principale");
				result = notesBean.ajoutNote();
			}
			if (hasExamP) {
				notesBean.setIdCour(idCour);
				notesBean.setDesignationNote("Examen");
				notesBean.setCoefficientNote(coefficientExamP);
				notesBean.setSessionNote("Principale");
				result = notesBean.ajoutNote();
			}
			if (hasExamR) {
				notesBean.setIdCour(idCour);
				notesBean.setDesignationNote("Examen");
				notesBean.setCoefficientNote(coefficientExamR);
				notesBean.setSessionNote("Rattrappage");
				result = notesBean.ajoutNote();
			}
		}
		return result;
	}

	public String toSetting() {
		for (NoteDTO noteDto : getNoteDTOArray()) {
			if (noteDto.getDesignation().equals("TP")) {
				hasTP = true;
				coefficientTP = noteDto.getCoefficient();
			} else {
				hasTP = false;
				coefficientTP = (double) 0;
			}
			if (noteDto.getDesignation().equals("TD")) {
				hasTD = true;
				coefficientTD = noteDto.getCoefficient();
			} else {
				hasTD = false;
				coefficientTD = (double) 0;
			}
			if (noteDto.getDesignation().equals("Examen")
					&& noteDto.getSession().equals("Principale")) {
				hasExamP = true;
				coefficientExamP = noteDto.getCoefficient();
			} else {
				hasExamP = false;
				coefficientExamP = (double) 0;
			}
			if (noteDto.getDesignation().equals("Examen")
					&& noteDto.getSession().equals("Rattrappage")) {
				hasExamR = true;
				coefficientExamR = noteDto.getCoefficient();
			} else {
				hasExamR = false;
				coefficientExamR = (double) 0;
			}
		}
		return "settingcour";
	}

	public String getEdited() {
		// TODO remove note
		String result = modifierCour();
		if (changedTP == 1) {
			notesBean.setIdCour(idCour);
			notesBean.setDesignationNote("TP");
			notesBean.setCoefficientNote(coefficientTP);
			notesBean.setSessionNote("Principale");
			result = notesBean.ajoutNote();
		}
		if (changedTD == 1) {
			notesBean.setIdCour(idCour);
			notesBean.setDesignationNote("TD");
			notesBean.setCoefficientNote(coefficientTD);
			notesBean.setSessionNote("Principale");
			result = notesBean.ajoutNote();
		}
		if (changedExamP == 1) {
			notesBean.setIdCour(idCour);
			notesBean.setDesignationNote("Examen");
			notesBean.setCoefficientNote(coefficientExamP);
			notesBean.setSessionNote("Principale");
			result = notesBean.ajoutNote();
		}
		if (changedExamR == 1) {
			notesBean.setIdCour(idCour);
			notesBean.setDesignationNote("Examen");
			notesBean.setCoefficientNote(coefficientExamR);
			notesBean.setSessionNote("Rattrappage");
			result = notesBean.ajoutNote();
		}
		return result;
	}

	public String modifierCour() {
		try {
			GestionCourServiceStub courStub = new GestionCourServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetCourById courById = new GetCourById();
			courById.setArg0(idCour);
			CourDTO courDto = courStub.getCourById(courById).get_return();
			ModifierCour courDtoEditParam = new ModifierCour();
			// TODO etudDto.setEnabled(enabledEtud);
			courDto.setAnneeUniversitaire(anneeUniversitaireCour);
			if (idMatiere != 0) {
				GestionMatiereServiceStub matiereStub = new GestionMatiereServiceStub();
				GetMatiereById matiereById = new GetMatiereById();
				matiereById.setArg0(idMatiere);
				matiereDtoCour = new MatiereDTO();
				matiereDtoCour.setCreatedAt(matiereStub
						.getMatiereById(matiereById).get_return()
						.getCreatedAt());
				matiereDtoCour.setDesignation(matiereStub
						.getMatiereById(matiereById).get_return()
						.getDesignation());
				matiereDtoCour.setEnabled(matiereStub
						.getMatiereById(matiereById).get_return().getEnabled());
				matiereDtoCour.setId(matiereStub.getMatiereById(matiereById)
						.get_return().getId());
				matiereDtoCour.setUpdatedAt(matiereStub
						.getMatiereById(matiereById).get_return()
						.getUpdatedAt());
				courDto.setMatiereDto(matiereDtoCour);
			}
			if (idEnseignant != 0) {
				GestionEnseignantServiceStub enseignantStub = new GestionEnseignantServiceStub();
				GetEnseignantById enseignantById = new GetEnseignantById();
				enseignantById.setArg0(idEnseignant);
				enseignantDtoCour = new EnseignantDTO();
				enseignantDtoCour.setCreatedAt(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getCreatedAt());
				enseignantDtoCour.setTitre(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getTitre());
				enseignantDtoCour.setEnabled(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getEnabled());
				enseignantDtoCour
						.setId(enseignantStub.getEnseignantById(enseignantById)
								.get_return().getId());
				enseignantDtoCour.setUpdatedAt(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getUpdatedAt());
				enseignantDtoCour.setName(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getName());
				enseignantDtoCour.setLastName(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getLastName());
				enseignantDtoCour.setUserName(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getUserName());
				enseignantDtoCour.setEmail(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getEmail());
				enseignantDtoCour.setPassword(enseignantStub
						.getEnseignantById(enseignantById).get_return()
						.getPassword());
				courDto.setEnseignantDto(enseignantDtoCour);
			}
			if (idNiveau != 0) {
				GestionNiveauServiceStub niveauStub = new GestionNiveauServiceStub();
				GetNiveauById niveauById = new GetNiveauById();
				niveauById.setArg0(idNiveau);
				niveauDtoCour = new NiveauDTO();
				niveauDtoCour.setCreatedAt(niveauStub.getNiveauById(niveauById)
						.get_return().getCreatedAt());
				niveauDtoCour.setDesignation(niveauStub
						.getNiveauById(niveauById).get_return()
						.getDesignation());
				niveauDtoCour.setEnabled(niveauStub.getNiveauById(niveauById)
						.get_return().getEnabled());
				niveauDtoCour.setId(niveauStub.getNiveauById(niveauById)
						.get_return().getId());
				niveauDtoCour.setUpdatedAt(niveauStub.getNiveauById(niveauById)
						.get_return().getUpdatedAt());
				courDto.setNiveauDto(niveauDtoCour);
			}
			courDtoEditParam.setArg0(courDto);
			courStub.modifierCour(courDtoEditParam);
			initialAttributes();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "cours";
	}

	public void initialAttributes() {
		createdAtCour = null;
		createdAtStringCour = "";
		enabledCour = (byte) 0;
		updatedAtCour = null;
		updatedAtStringCour = "";
		anneeUniversitaireCour = "";
		matiereDtoCour = null;
		idMatiere = (long) 0;
		enseignantDtoCour = null;
		idEnseignant = (long) 0;
		niveauDtoCour = null;
		idNiveau = (long) 0;
		hasTP = true;
		hasTD = true;
		hasExamP = true;
		hasExamR = true;
		coefficientTP = (double) 0.1;
		coefficientTD = (double) 0.2;
		coefficientExamP = (double) 0.7;
		coefficientExamR = (double) 0.7;
		changedTP = 2;
		changedTD = 2;
		changedExamP = 2;
		changedExamR = 2;
	}

	public Long getIdCour() {
		return idCour;
	}

	public void setIdCour(Long idCour) {
		this.idCour = idCour;
	}

	public Date getCreatedAtCour() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			createdAtCour = format1.parse(createdAtStringCour);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createdAtCour;
	}

	public Date getUpdatedAtCour() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			updatedAtCour = format1.parse(updatedAtStringCour);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updatedAtCour;
	}

	public String getCreatedAtStringCour() {
		return createdAtStringCour;
	}

	public void setCreatedAtStringCour(String createdAtStringCour) {
		this.createdAtStringCour = createdAtStringCour;
	}

	public byte getEnabledCour() {
		return enabledCour;
	}

	public void setEnabledCour(byte enabledCour) {
		this.enabledCour = enabledCour;
	}

	public String getUpdatedAtStringCour() {
		return updatedAtStringCour;
	}

	public void setUpdatedAtStringCour(String updatedAtStringCour) {
		this.updatedAtStringCour = updatedAtStringCour;
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

	public void setCreatedAtCour(Date createdAtCour) {
		this.createdAtCour = createdAtCour;
	}

	public void setUpdatedAtCour(Date updatedAtCour) {
		this.updatedAtCour = updatedAtCour;
	}

	public NiveauDTO getNiveauDtoCour() {
		return niveauDtoCour;
	}

	public void setNiveauDtoCour(NiveauDTO niveauDtoCour) {
		this.niveauDtoCour = niveauDtoCour;
	}

	public Long getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}

	public MatiereDTO getMatiereDtoCour() {
		return matiereDtoCour;
	}

	public void setMatiereDtoCour(MatiereDTO matiereDtoCour) {
		this.matiereDtoCour = matiereDtoCour;
	}

	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}

	public EnseignantDTO getEnseignantDtoCour() {
		return enseignantDtoCour;
	}

	public void setEnseignantDtoCour(EnseignantDTO enseignantDtoCour) {
		this.enseignantDtoCour = enseignantDtoCour;
	}

	public Long getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(Long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public String getAnneeUniversitaireCour() {
		return anneeUniversitaireCour;
	}

	public void setAnneeUniversitaireCour(String anneeUniversitaireCour) {
		this.anneeUniversitaireCour = anneeUniversitaireCour;
	}

	public ArrayList<Long> getSelectedEnabledNote() {
		return selectedEnabledNote;
	}

	public void setSelectedEnabledNote(ArrayList<Long> selectedEnabledNote) {
		this.selectedEnabledNote = selectedEnabledNote;
	}

	public void loadNoteDTOArray(ValueChangeEvent e) {
		noteDTOArray = listNote();
	}

	public void loadCourDTOArray() {
		courDTOArray = listCour();
	}

	public NoteDTO[] getNoteDTOArray() {
		noteDTOArray = listNote();
		return noteDTOArray;
	}

	public void setNoteDTOArray(NoteDTO[] noteDTOArray) {
		this.noteDTOArray = noteDTOArray;
	}

	public boolean isHasTP() {
		return hasTP;
	}

	public void setHasTP(boolean hasTP) {
		this.hasTP = hasTP;
	}

	public boolean isHasTD() {
		return hasTD;
	}

	public void setHasTD(boolean hasTD) {
		this.hasTD = hasTD;
	}

	public boolean isHasExamP() {
		return hasExamP;
	}

	public void setHasExamP(boolean hasExamP) {
		this.hasExamP = hasExamP;
	}

	public boolean isHasExamR() {
		return hasExamR;
	}

	public void setHasExamR(boolean hasExamR) {
		this.hasExamR = hasExamR;
	}

	public NotesBean getNotesBean() {
		return notesBean;
	}

	public void setNotesBean(NotesBean notesBean) {
		this.notesBean = notesBean;
	}

	public Double getCoefficientTP() {
		return coefficientTP;
	}

	public void setCoefficientTP(Double coefficientTP) {
		this.coefficientTP = coefficientTP;
	}

	public Double getCoefficientTD() {
		return coefficientTD;
	}

	public void setCoefficientTD(Double coefficientTD) {
		this.coefficientTD = coefficientTD;
	}

	public Double getCoefficientExamP() {
		return coefficientExamP;
	}

	public void setCoefficientExamP(Double coefficientExamP) {
		this.coefficientExamP = coefficientExamP;
	}

	public Double getCoefficientExamR() {
		return coefficientExamR;
	}

	public void setCoefficientExamR(Double coefficientExamR) {
		this.coefficientExamR = coefficientExamR;
	}

	public short getChangedTP() {
		return changedTP;
	}

	public void setChangedTP(short changedTP) {
		this.changedTP = changedTP;
	}

	public short getChangedTD() {
		return changedTD;
	}

	public void setChangedTD(short changedTD) {
		this.changedTD = changedTD;
	}

	public short getChangedExamP() {
		return changedExamP;
	}

	public void setChangedExamP(short changedExamP) {
		this.changedExamP = changedExamP;
	}

	public short getChangedExamR() {
		return changedExamR;
	}

	public void setChangedExamR(short changedExamR) {
		this.changedExamR = changedExamR;
	}
}