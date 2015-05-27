package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import tn.rnu.isetsf.dto.EnseignantDTO;
import tn.rnu.isetsf.dto.MatiereDTO;
import tn.rnu.isetsf.dto.NoteDTO;

/**
 * Entity implementation class for Entity: EnseignantMatiereDTO
 *
 */
public class CourDTO extends AbstractAttributeDTO implements Serializable {
	
	private Long id;
	
	private String anneeUniversitaire;
	
	private EnseignantDTO enseignantDto;
	
	private MatiereDTO matiereDto;
	
	private List<NoteDTO> notesDto;
	
	private NiveauDTO niveauDto;
	
	private static final long serialVersionUID = 1L;

	public CourDTO() {
		super();
	}   
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public EnseignantDTO getEnseignantDto() {
		return enseignantDto;
	}

	public void setEnseignantDto(EnseignantDTO enseignantDto) {
		this.enseignantDto = enseignantDto;
	}

	public MatiereDTO getMatiereDto() {
		return matiereDto;
	}

	public void setMatiereDto(MatiereDTO matiereDto) {
		this.matiereDto = matiereDto;
	}

	public String getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(String anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	public List<NoteDTO> getNotesDto() {
		return notesDto;
	}

	public void setNotesDto(List<NoteDTO> notesDto) {
		this.notesDto = notesDto;
	}

	public NiveauDTO getNiveauDto() {
		return niveauDto;
	}

	public void setNiveauDto(NiveauDTO niveauDto) {
		this.niveauDto = niveauDto;
	}
	
}
