package tn.rnu.isetsf.bean;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.axis2.AxisFault;

import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.CourDTO;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.CreerNote;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.GetNoteById;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.GetNotesArray;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.GetValeursOfNoteArray;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.ModifierNote;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.NoteDTO;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.NoteDTOArray;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.ValeurDTO;
import tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.ValeurDTOArray;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub;
import tn.rnu.isetsf.service.parametres.GestionCourServiceStub.GetCourById;

@SuppressWarnings("serial")
@ManagedBean(name = "notesBean")
@SessionScoped
public class NotesBean implements Serializable {

	private Long idNote = (long) 0;
	private Date createdAtNote = null;
	private String createdAtStringNote = "";
	private byte enabledNote = 0;
	private String designationNote = "";
	private Double coefficientNote = (double) 0;
	private String sessionNote = "";
	private Date updatedAtNote = null;
	private String updatedAtStringNote = "";
	private Long idCour = (long) 0;
	private Long idDepartement = (long) 0;
	private Long idFormation = (long) 0;
	private Long idNiveau = (long) 0;
	private ArrayList<Long> selectedEnabledNote;
	private ArrayList<Long> selectedEnabledValeur;
	private NoteDTO[] noteDTOArray = null;
	private CourDTO courDto = null;
	private ValeurDTO[] valeurDTOArray = null;

	public void execute(ValueChangeEvent e) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String txtProperty = request.getParameter("listFormation");
		// note the difference when getting the parameter
		String txtAnotherProperty = request.getParameter("txtAnotherProperty");
		// use the value in txtProperty as you want...
		// Note: don't use System.out.println in production, use a logger
		// instead
		System.out.println(txtProperty);
		System.out.println(txtAnotherProperty);
	}

	public NoteDTO[] listNote() {
		NoteDTO[] noteDTOArray = null;
		selectedEnabledNote = new ArrayList<Long>();
		try {
			GestionNoteServiceStub noteStub = new GestionNoteServiceStub();
			GetNotesArray notesArray = new GetNotesArray();
			NoteDTOArray noteDtoArray = noteStub.getNotesArray(notesArray)
					.get_return();
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

	private ValeurDTO[] listValeur() {
		ValeurDTO[] valeurDTOArray = null;
		selectedEnabledValeur = new ArrayList<Long>();
		try {
			GestionNoteServiceStub noteStub = new GestionNoteServiceStub();
			GetNoteById noteById = new GetNoteById();
			noteById.setArg0(idNote);
			NoteDTO noteDto = noteStub.getNoteById(noteById).get_return();
			GetValeursOfNoteArray valeursArray = new GetValeursOfNoteArray();
			valeursArray.setArg0(noteDto);
			ValeurDTOArray valeurDtoArray = noteStub.getValeursOfNoteArray(
					valeursArray).get_return();
			valeurDTOArray = valeurDtoArray.getItem();
			for (ValeurDTO valeurDto : valeurDTOArray)
				if (valeurDto.getEnabled() == (byte) 1)
					selectedEnabledValeur.add(valeurDto.getId());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return valeurDTOArray;
	}

	public String ajoutNote() {
		try {
			GestionNoteServiceStub noteStub = new GestionNoteServiceStub();
			CreerNote note = new CreerNote();
			NoteDTO noteDto = new NoteDTO();
			noteDto.setDesignation(designationNote);
			noteDto.setCoefficient(coefficientNote);
			noteDto.setSession(sessionNote);
			GestionCourServiceStub courStub = new GestionCourServiceStub();
			GetCourById courById = new GetCourById();
			courById.setArg0(idCour);
			courDto = new CourDTO();
			courDto.setCreatedAt(courStub.getCourById(courById).get_return()
					.getCreatedAt());
			courDto.setAnneeUniversitaire(courStub.getCourById(courById)
					.get_return().getAnneeUniversitaire());
			courDto.setEnabled(courStub.getCourById(courById).get_return()
					.getEnabled());
			courDto.setId(courStub.getCourById(courById).get_return().getId());
			courDto.setUpdatedAt(courStub.getCourById(courById).get_return()
					.getUpdatedAt());
			noteDto.setCourDto(courDto);
			note.setArg0(noteDto);
			noteStub.creerNote(note);
			initialAttributes();
			return "cours";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String modifierNote() {
		try {
			GestionNoteServiceStub noteStub = new GestionNoteServiceStub();
			// TODO FacesContext fc = FacesContext.getCurrentInstance();
			GetNoteById noteById = new GetNoteById();
			noteById.setArg0(idNote);
			NoteDTO noteDto = noteStub.getNoteById(noteById).get_return();
			ModifierNote noteDtoEditParam = new ModifierNote();
			noteDto.setDesignation(designationNote);
			noteDto.setCoefficient(coefficientNote);
			noteDto.setSession(sessionNote);
			// TODO etudDto.setEnabled(enabledEtud);
			GestionCourServiceStub courStub = new GestionCourServiceStub();
			GetCourById courById = new GetCourById();
			courById.setArg0(idCour);
			courDto = new CourDTO();
			courDto.setCreatedAt(courStub.getCourById(courById).get_return()
					.getCreatedAt());
			courDto.setAnneeUniversitaire(courStub.getCourById(courById)
					.get_return().getAnneeUniversitaire());
			courDto.setEnabled(courStub.getCourById(courById).get_return()
					.getEnabled());
			courDto.setId(courStub.getCourById(courById).get_return().getId());
			courDto.setUpdatedAt(courStub.getCourById(courById).get_return()
					.getUpdatedAt());
			noteDto.setCourDto(courDto);
			noteDtoEditParam.setArg0(noteDto);
			noteStub.modifierNote(noteDtoEditParam);
			initialAttributes();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "cours";
	}

	public void initialAttributes() {
		createdAtNote = null;
		createdAtStringNote = "";
		designationNote = "";
		coefficientNote = (double) 0;
		sessionNote = "";
		enabledNote = (byte) 0;
		updatedAtNote = null;
		updatedAtStringNote = "";
		idCour = (long) 0;
		idDepartement = (long) 0;
		idFormation = (long) 0;
		idNiveau = (long) 0;
	}

	public Long getIdNote() {
		return idNote;
	}

	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}

	public Date getCreatedAtNote() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			createdAtNote = format1.parse(createdAtStringNote);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createdAtNote;
	}

	public Date getUpdatedAtNote() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			updatedAtNote = format1.parse(updatedAtStringNote);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updatedAtNote;
	}

	public String getCreatedAtStringNote() {
		return createdAtStringNote;
	}

	public void setCreatedAtStringNote(String createdAtStringNote) {
		this.createdAtStringNote = createdAtStringNote;
	}

	public String getDesignationNote() {
		return designationNote;
	}

	public void setDesignationNote(String designationNote) {
		this.designationNote = designationNote;
	}

	public byte getEnabledNote() {
		return enabledNote;
	}

	public void setEnabledNote(byte enabledNote) {
		this.enabledNote = enabledNote;
	}

	public Double getCoefficientNote() {
		return coefficientNote;
	}

	public void setCoefficientNote(Double coefficientNote) {
		this.coefficientNote = coefficientNote;
	}

	public String getSessionNote() {
		return sessionNote;
	}

	public void setSessionNote(String sessionNote) {
		this.sessionNote = sessionNote;
	}

	public String getUpdatedAtStringNote() {
		return updatedAtStringNote;
	}

	public void setUpdatedAtStringNote(String updatedAtStringNote) {
		this.updatedAtStringNote = updatedAtStringNote;
	}

	public ArrayList<Long> getSelectedEnabledNote() {
		return selectedEnabledNote;
	}

	public void setSelectedEnabledNote(ArrayList<Long> selectedEnabledNote) {
		this.selectedEnabledNote = selectedEnabledNote;
	}

	public NoteDTO[] getNoteDTOArray() {
		noteDTOArray = listNote();
		return noteDTOArray;
	}

	public void setNoteDTOArray(NoteDTO[] noteDTOArray) {
		this.noteDTOArray = noteDTOArray;
	}

	public void setCreatedAtNote(Date createdAtNote) {
		this.createdAtNote = createdAtNote;
	}

	public void setUpdatedAtNote(Date updatedAtNote) {
		this.updatedAtNote = updatedAtNote;
	}

	public ArrayList<Long> getSelectedEnabledValeur() {
		return selectedEnabledValeur;
	}

	public void setSelectedEnabledValeur(ArrayList<Long> selectedEnabledValeur) {
		this.selectedEnabledValeur = selectedEnabledValeur;
	}

	public void loadValeurDTOArray(ValueChangeEvent e) {
		valeurDTOArray = listValeur();
	}

	public ValeurDTO[] getValeurDTOArray() {
		valeurDTOArray = listValeur();
		return valeurDTOArray;
	}

	public void setValeurDTOArray(ValeurDTO[] valeurDTOArray) {
		this.valeurDTOArray = valeurDTOArray;
	}

	public CourDTO getCourDto() {
		return courDto;
	}

	public void setCourDto(CourDTO courDto) {
		this.courDto = courDto;
	}

	public Long getIdCour() {
		return idCour;
	}

	public void setIdCour(Long idCour) {
		this.idCour = idCour;
	}

	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public Long getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}
}