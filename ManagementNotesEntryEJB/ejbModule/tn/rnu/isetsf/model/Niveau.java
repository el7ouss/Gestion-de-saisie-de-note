package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Niveau
 *
 */
@Entity
@Table(name="niveau")
public class Niveau extends AbstractAttributeEntity implements Serializable {

	@TableGenerator(name = "niveau_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "niveau_gen")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="designation", nullable=false)
	private String designation;
	
	@ManyToOne()
	@JoinColumn(name = "formation")
	private Formation formation;
	
	@OneToMany(mappedBy="niveau")
	private List<Cour> cours;
	
	@OneToMany(mappedBy="niveau")
	private List<Etudiant> etudiants;
	
	private static final long serialVersionUID = 1L;

	public Niveau() {
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
	
	public List<Cour> getCours() {
		return cours;
	}
	public void setCours(List<Cour> cours) {
		this.cours = cours;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
   
}
