package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The persistent class for the utilisateurDTO.
 * 
 */
public class UtilisateurDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String email;
	
	private Byte enabled;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	private String createdAtString;
	
	private String updatedAtString;
	
	private String lastName;
	
	private String name;
	
	private String password;
	
	private String userName;
	
	private RoleDTO roleDto;
	
	public UtilisateurDTO() {
	}

	public Long getId() {
		return this.id;
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

	public String getCreatedAtString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat();
        sdf1.applyPattern("dd/MM/yyyy HH:mm:ss");
		createdAtString=sdf1.format(createdAt);
		return createdAtString;
	}

	public void setCreatedAtString(String createdAtString) {
		this.createdAtString = createdAtString;
	}

	public String getUpdatedAtString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat();
        sdf1.applyPattern("dd/MM/yyyy HH:mm:ss");
		updatedAtString=sdf1.format(updatedAt);
		return updatedAtString;
	}

	public void setUpdatedAtString(String updatedAtString) {
		this.updatedAtString = updatedAtString;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public RoleDTO getRoleDto() {
		return roleDto;
	}

	public void setRoleDto(RoleDTO roleDto) {
		this.roleDto = roleDto;
	}
}