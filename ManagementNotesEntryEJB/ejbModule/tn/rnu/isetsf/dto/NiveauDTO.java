package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;


/**
 * Entity implementation class for Entity: Niveau
 *
 */
public class NiveauDTO extends AbstractAttributeDTO implements Serializable {
	
	private Long id;
	
	private String designation;
	
	private FormationDTO formationDto;
	
	private List<CourDTO> coursDto;
	
	private List<EtudiantDTO> etudiantsDto;
	
	private static final long serialVersionUID = 1L;

	public NiveauDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	public List<CourDTO> getCoursDto() {
		return coursDto;
	}
	public void setCoursDto(List<CourDTO> coursDto) {
		this.coursDto = coursDto;
	}
	public List<EtudiantDTO> getEtudiantsDto() {
		return etudiantsDto;
	}
	public void setEtudiantsDto(List<EtudiantDTO> etudiantsDto) {
		this.etudiantsDto = etudiantsDto;
	}
	public FormationDTO getFormationDto() {
		return formationDto;
	}
	public void setFormationDto(FormationDTO formationDto) {
		this.formationDto = formationDto;
	}
}
