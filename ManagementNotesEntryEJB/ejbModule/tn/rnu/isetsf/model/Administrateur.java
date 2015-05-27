package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import tn.rnu.isetsf.model.Utilisateur;

/**
 * Entity implementation class for Entity: Administrateur
 *
 */
//@MappedSuperclass
@Entity
//@EntityListeners({RoleAdminListener.class})
@DiscriminatorValue("Admin")
public class Administrateur extends Utilisateur implements Serializable {

	@Column(name="poste")
	private String poste;
	private static final long serialVersionUID = 1L;

	public Administrateur() {
		super();
	}   
	public String getPoste() {
		return this.poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
}
