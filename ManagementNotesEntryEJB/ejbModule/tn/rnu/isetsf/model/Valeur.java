package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Valeur
 *
 */
@Entity
@Table(name="valeur")
public class Valeur extends AbstractAttributeEntity implements Serializable {

	@TableGenerator(name = "valeur_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "valeur_gen")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name="note")
	private Note note;
	
	@ManyToOne()
	@JoinColumn(name="etudiant")
	private Etudiant etudiant;
	
	@Column(name="valeur_note")
	private Double valeurNote;
	
	@Column(name="num_compostage")
	private Long numCompostage;
	
	private static final long serialVersionUID = 1L;

	public Valeur() {
		super();
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
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

	public Double getValeurNote() {
		return valeurNote;
	}

	public void setValeurNote(Double valeurNote) {
		this.valeurNote = valeurNote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumCompostage() {
		return numCompostage;
	}

	public void setNumCompostage(Long numCompostage) {
		this.numCompostage = numCompostage;
	}
   
}
