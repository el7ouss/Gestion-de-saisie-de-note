package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.lang.Long;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import tn.rnu.isetsf.dto.UtilisateurDTO;

/**
 * Entity implementation class for Entity: EtudiantDTO
 *
 */
public class EtudiantDTO extends UtilisateurDTO implements Serializable {

	private Long cin;
	
	private Long numInscrit;
	
	private Date dateNaissance;
	
	private String dateNaissanceString;
	
	private NiveauDTO niveauDto;
	
	private List<ValeurDTO> valeursDto;
	
	private static final long serialVersionUID = 1L;

	public EtudiantDTO() {
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

	public NiveauDTO getNiveauDto() {
		return niveauDto;
	}
	public void setNiveauDto(NiveauDTO niveauDto) {
		this.niveauDto = niveauDto;
	}

	public List<ValeurDTO> getValeursDto() {
		return valeursDto;
	}
	public void setValeursDto(List<ValeurDTO> valeursDto) {
		this.valeursDto = valeursDto;
	}
	public String getDateNaissanceString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat();
        sdf1.applyPattern("dd/MM/yyyy");
        dateNaissanceString=sdf1.format(dateNaissance);
		return dateNaissanceString;
	}
	public void setDateNaissanceString(String dateNaissanceString) {
		SimpleDateFormat sdf1 = new SimpleDateFormat();
        sdf1.applyPattern("dd/MM/yyyy");
		this.dateNaissanceString = dateNaissanceString;
		try {
			dateNaissance=sdf1.parse(this.dateNaissanceString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
   
}
