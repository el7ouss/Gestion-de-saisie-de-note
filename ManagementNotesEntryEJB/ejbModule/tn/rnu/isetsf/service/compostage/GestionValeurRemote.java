package tn.rnu.isetsf.service.compostage;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.dto.ValeurDTO;

@Remote
public interface GestionValeurRemote {
	public void creerValeur(ValeurDTO valeurDto);

	public ValeurDTO getValeurById(Long id);

	public List<ValeurDTO> getValeurs();

	public void modifierValeur(ValeurDTO valeurDto);

}
