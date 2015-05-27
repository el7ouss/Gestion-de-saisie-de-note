package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Enseignant
 *
 */
//@MappedSuperclass
@Entity
@DiscriminatorValue("Ens")
public class Enseignant extends Utilisateur implements Serializable {
	
	
	@Column(name="titre")
	private String titre;
	
	@OneToMany(mappedBy="enseignant")
	private List<Cour> cours;
	
	private static final long serialVersionUID = 1L;

	public Enseignant() {
		super();
	}   
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public List<Cour> getCours() {
		return cours;
	}
	public void setCours(List<Cour> cours) {
		this.cours = cours;
	}
   
}
