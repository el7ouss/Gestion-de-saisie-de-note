package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Matiere
 *
 */
@Entity
@Table(name="matiere")
public class Matiere extends AbstractAttributeEntity implements Serializable {

	@TableGenerator(name = "matiere_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "matiere_gen")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="designation", nullable=false)
	private String designation;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="matiere")
	private List<Cour> cours;
	
	private static final long serialVersionUID = 1L;

	public Matiere() {
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
	
	public List<Cour> getCours() {
		return cours;
	}

	public void setCours(List<Cour> cours) {
		this.cours = cours;
	}
   
}
