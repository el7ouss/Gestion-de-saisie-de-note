package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.lang.Byte;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@Table(name="role")
public class Role extends AbstractAttributeEntity implements Serializable {
	   
	@TableGenerator(name = "role_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "role_gen")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="designation", nullable=false)
	private String designation;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="role")
	private List<Utilisateur> users;	

	private static final long serialVersionUID = 1L;

	public Role() {
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
	
	public List<Utilisateur> getUsers() {
		return users;
	}
	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}
   
}
