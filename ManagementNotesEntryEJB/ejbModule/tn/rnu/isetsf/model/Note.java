package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: NiveauMatiere
 * 
 */
@Entity
@Table(name = "note")
public class Note extends AbstractAttributeEntity implements Serializable {

	@TableGenerator(name = "note_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "note_gen")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "designation", nullable = false)
	private String designation;

	@Column(name = "coefficient")
	private Double coefficient;
	
	@Column(name="session")
	private String session;

	@OneToMany(mappedBy = "note")
	private List<Valeur> valeurs;

	@ManyToOne()
	@JoinColumn(name = "cour")
	private Cour cour;

	private static final long serialVersionUID = 1L;

	public Note() {
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

	public List<Valeur> getValeurs() {
		return valeurs;
	}

	public void setValeurs(List<Valeur> valeurs) {
		this.valeurs = valeurs;
	}

	public Cour getCour() {
		return cour;
	}

	public void setCour(Cour cour) {
		this.cour = cour;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

}
