package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.lang.Byte;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import tn.rnu.isetsf.dto.NiveauDTO;

/**
 * Entity implementation class for Entity: FormationDTO
 * 
 */
public class FormationDTO extends AbstractAttributeDTO implements Serializable {

	private Long id;

	private String designation;

	private String description;

	private DepartementDTO departementDto;

	private List<NiveauDTO> niveauxDto;

	private static final long serialVersionUID = 1L;

	public FormationDTO() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public DepartementDTO getDepartementDto() {
		return departementDto;
	}

	public void setDepartementDto(DepartementDTO departementDto) {
		this.departementDto = departementDto;
	}

	public List<NiveauDTO> getNiveauxDto() {
		return niveauxDto;
	}

	public void setNiveauxDto(List<NiveauDTO> niveauxDto) {
		this.niveauxDto = niveauxDto;
	}

}
