package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.lang.String;

import tn.rnu.isetsf.dto.UtilisateurDTO;

/**
 * Entity implementation class for Entity: AdministrateurDTO
 *
 */
public class AdministrateurDTO extends UtilisateurDTO implements Serializable {

	private String poste;
	private static final long serialVersionUID = 1L;

	public AdministrateurDTO() {
		super();
	}   
	public String getPoste() {
		return this.poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
   
}
