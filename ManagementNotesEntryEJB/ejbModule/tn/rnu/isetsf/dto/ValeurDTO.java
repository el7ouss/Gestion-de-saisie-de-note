package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity implementation class for Entity: Valeur
 *
 */
public class ValeurDTO extends AbstractAttributeDTO implements Serializable {
	
	private Long id;
	
	private NoteDTO noteDto;
	
	private EtudiantDTO etudiantDto;
	
	private Double valeurNote;
	
	private Long numCompostage;
	
	private static final long serialVersionUID = 1L;

	public ValeurDTO() {
		super();
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public Double getValeurNote() {
		return valeurNote;
	}

	public void setValeurNote(Double valeurNote) {
		this.valeurNote = valeurNote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NoteDTO getNoteDto() {
		return noteDto;
	}

	public void setNoteDto(NoteDTO noteDto) {
		this.noteDto = noteDto;
	}

	public EtudiantDTO getEtudiantDto() {
		return etudiantDto;
	}

	public void setEtudiantDto(EtudiantDTO etudiantDto) {
		this.etudiantDto = etudiantDto;
	}

	public Long getNumCompostage() {
		return numCompostage;
	}

	public void setNumCompostage(Long numCompostage) {
		this.numCompostage = numCompostage;
	}
   
}
