package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

/**
 * Entity implementation class for Entity: EnseignantDTO
 *
 */
public class EnseignantDTO extends UtilisateurDTO implements Serializable {
	
	private String titre;
	
	private List<CourDTO> coursDto;
	
	private static final long serialVersionUID = 1L;

	public EnseignantDTO() {
		super();
	}   
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public List<CourDTO> getCoursDto() {
		return coursDto;
	}
	public void setCoursDto(List<CourDTO> coursDto) {
		this.coursDto = coursDto;
	}
   
}
