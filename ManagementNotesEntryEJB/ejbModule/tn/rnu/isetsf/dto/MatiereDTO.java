package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Entity implementation class for Entity: MatiereDTO
 *
 */
public class MatiereDTO extends AbstractAttributeDTO implements Serializable {

	private Long id;
	
	private String designation;
	
	private String description;
	
	private List<CourDTO> coursDto;
	
	private static final long serialVersionUID = 1L;

	public MatiereDTO() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
   
}
