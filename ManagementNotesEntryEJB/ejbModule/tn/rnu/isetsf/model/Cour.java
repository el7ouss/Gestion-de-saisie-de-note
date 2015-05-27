package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import tn.rnu.isetsf.model.Enseignant;
import tn.rnu.isetsf.model.Matiere;

/**
 * Entity implementation class for Entity: EnseignantMatiere
 *
 */
@Entity
@Table(name="cour")
public class Cour extends AbstractAttributeEntity implements Serializable {

	@TableGenerator(name = "cour_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "cour_gen")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="annee_universitaire")
	private String anneeUniversitaire;
	
	@ManyToOne()
	@JoinColumn(name="enseignant")
	private Enseignant enseignant;
	
	@ManyToOne()
	@JoinColumn(name="matiere")
	private Matiere matiere;
	
	@OneToMany(mappedBy="cour")
	private List<Note> notes;
	
	@ManyToOne()
	@JoinColumn(name="niveau")
	private Niveau niveau;
	
	private static final long serialVersionUID = 1L;

	public Cour() {
		super();
	}   
	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}   
	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getAnneeUniversitaire() {
		return anneeUniversitaire;
	}
	public void setAnneeUniversitaire(String anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
}
