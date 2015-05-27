package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.lang.Byte;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

/**
 * Entity implementation class for Entity: RoleDTO
 *
 */
public class RoleDTO extends AbstractAttributeDTO implements Serializable {
	
	private Long id;
	
	private String designation;
	
	private String description;
	
	private List<UtilisateurDTO> usersDto;
	
	private static final long serialVersionUID = 1L;

	public RoleDTO() {
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
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}
	public List<UtilisateurDTO> getUsersDto() {
		return usersDto;
	}
	public void setUsersDto(List<UtilisateurDTO> usersDto) {
		this.usersDto = usersDto;
	}
}
