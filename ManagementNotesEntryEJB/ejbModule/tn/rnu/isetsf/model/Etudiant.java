package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import tn.rnu.isetsf.model.Utilisateur;

/**
 * Entity implementation class for Entity: Etudiant
 *
 */
//@MappedSuperclass
@Entity
@DiscriminatorValue("Etud")
public class Etudiant extends Utilisateur implements Serializable {

	@Column(name="cin", unique=true, nullable=false)
	private Long cin;
	
	@Column(name="num_inscrit", unique=true, nullable=false)
	private Long numInscrit;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;
	
	@ManyToOne()
	@JoinColumn(name="niveau")
	private Niveau niveau;
	
	@OneToMany(mappedBy="etudiant")
	private List<Valeur> valeurs;
	
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	private static final long serialVersionUID = 1L;

	public Etudiant() {
		super();
	}   
	public Long getCin() {
		return this.cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}   
	public Long getNumInscrit() {
		return this.numInscrit;
	}

	public void setNumInscrit(Long numInscrit) {
		this.numInscrit = numInscrit;
	}   
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public List<Valeur> getValeurs() {
		return valeurs;
	}
	public void setValeurs(List<Valeur> valeurs) {
		this.valeurs = valeurs;
	}
   
}
