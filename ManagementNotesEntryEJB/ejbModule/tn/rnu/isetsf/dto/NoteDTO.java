package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Entity implementation class for Entity: NiveauMatiereDTO
 *
 */
public class NoteDTO extends AbstractAttributeDTO implements Serializable {

	private Long id;
	
	private String designation;
	
	private Double coefficient;
	
	private String session;
	
	private List<ValeurDTO> valeursDto;
	
	private CourDTO courDto;
	
	private static final long serialVersionUID = 1L;

	public NoteDTO() {
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

	public Double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}

	public List<ValeurDTO> getValeursDto() {
		return valeursDto;
	}

	public void setValeursDto(List<ValeurDTO> valeursDto) {
		this.valeursDto = valeursDto;
	}

	public CourDTO getCourDto() {
		return courDto;
	}

	public void setCourDto(CourDTO courDto) {
		this.courDto = courDto;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
   
}
