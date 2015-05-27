package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.lang.Byte;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Formation
 * 
 */
@Entity
@Table(name = "formation")
public class Formation extends AbstractAttributeEntity implements Serializable {

	@TableGenerator(name = "formation_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "formation_gen")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "designation", nullable = false)
	private String designation;

	@Column(name = "description")
	private String description;

	@ManyToOne()
	@JoinColumn(name = "departement")
	private Departement departement;

	@OneToMany(mappedBy = "formation")
	protected List<Niveau> niveaux;

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	private static final long serialVersionUID = 1L;

	public Formation() {
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

	public List<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(List<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

}
