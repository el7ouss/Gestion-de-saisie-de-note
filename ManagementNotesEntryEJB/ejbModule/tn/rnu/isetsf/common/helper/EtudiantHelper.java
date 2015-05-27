package tn.rnu.isetsf.common.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tn.rnu.isetsf.dto.EtudiantDTO;
import tn.rnu.isetsf.dto.ValeurDTO;
import tn.rnu.isetsf.model.Etudiant;
import tn.rnu.isetsf.model.Valeur;

@SuppressWarnings("serial")
public class EtudiantHelper implements Serializable {

	public static EtudiantDTO modelToDTO(Etudiant etud) {
		EtudiantDTO etudDto = new EtudiantDTO();
		if (etud.getCreatedAt() != null)
			etudDto.setCreatedAt(etud.getCreatedAt());
		if (etud.getEmail() != null)
			etudDto.setEmail(etud.getEmail());
		if (etud.getEnabled() != null)
			etudDto.setEnabled(etud.getEnabled());
		if (etud.getId() != null)
			etudDto.setId(etud.getId());
		if (etud.getLastName() != null)
			etudDto.setLastName(etud.getLastName());
		if (etud.getName() != null)
			etudDto.setName(etud.getName());
		if (etud.getPassword() != null)
			etudDto.setPassword(etud.getPassword());
		if (etud.getUpdatedAt() != null)
			etudDto.setUpdatedAt(etud.getUpdatedAt());
		if (etud.getUserName() != null)
			etudDto.setUserName(etud.getUserName());
		if (etud.getCin() != null)
			etudDto.setCin(etud.getCin());
		if (etud.getNumInscrit() != null)
			etudDto.setNumInscrit(etud.getNumInscrit());
		if (etud.getDateNaissance() != null)
			etudDto.setDateNaissance(etud.getDateNaissance());
		if (etud.getRole() != null)
			etudDto.setRoleDto(RoleHelper.modelToDTO(etud.getRole()));
		if (etud.getNiveau() != null)
			etudDto.setNiveauDto(NiveauHelper.modelToDTO(etud.getNiveau()));
		/*if (etud.getValeurs() != null && etud.getValeurs().size() > 0) {
			List<Valeur> valeurs = etud.getValeurs();
			List<ValeurDTO> valeursDto = new ArrayList<ValeurDTO>();
			for (Valeur valeur : valeurs)
				valeursDto.add(ValeurHelper.modelToDTO(valeur));
			etudDto.setValeursDto(valeursDto);
		}*/
		return etudDto;
	}

	public static Etudiant DTOToModel(EtudiantDTO etudDto) {
		Etudiant etud = new Etudiant();
		if (etudDto.getCreatedAt() != null)
			etud.setCreatedAt(etudDto.getCreatedAt());
		if (etudDto.getEmail() != null)
			etud.setEmail(etudDto.getEmail());
		if (etudDto.getEnabled() != null)
			etud.setEnabled(etudDto.getEnabled());
		if (etudDto.getId() != null)
			etud.setId(etudDto.getId());
		if (etudDto.getLastName() != null)
			etud.setLastName(etudDto.getLastName());
		if (etudDto.getName() != null)
			etud.setName(etudDto.getName());
		if (etudDto.getPassword() != null)
			etud.setPassword(etudDto.getPassword());
		if (etudDto.getUpdatedAt() != null)
			etud.setUpdatedAt(etudDto.getUpdatedAt());
		if (etudDto.getUserName() != null)
			etud.setUserName(etudDto.getUserName());
		if (etudDto.getCin() != null)
			etud.setCin(etudDto.getCin());
		if (etudDto.getNumInscrit() != null)
			etud.setNumInscrit(etudDto.getNumInscrit());
		if (etudDto.getDateNaissance() != null)
			etud.setDateNaissance(etudDto.getDateNaissance());
		if (etudDto.getRoleDto() != null)
			etud.setRole(RoleHelper.DTOToModel(etudDto.getRoleDto()));
		if (etudDto.getNiveauDto() != null)
			etud.setNiveau(NiveauHelper.DTOToModel(etudDto.getNiveauDto()));
		/*if (etudDto.getValeursDto() != null
				&& etudDto.getValeursDto().size() > 0) {
			List<Valeur> valeurs = new ArrayList<Valeur>();
			List<ValeurDTO> valeursDto = etudDto.getValeursDto();
			for (ValeurDTO valeurDto : valeursDto)
				valeurs.add(ValeurHelper.DTOToModel(valeurDto));
			etud.setValeurs(valeurs);
		}*/
		return etud;
	}
}
