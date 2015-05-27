package tn.rnu.isetsf.service.compostage;

import java.util.List;

import javax.ejb.Local;

import tn.rnu.isetsf.dto.ValeurDTO;

@Local
public interface GestionValeurLocal {
	public void creerValeur(ValeurDTO valeurDto);

	public ValeurDTO getValeurById(Long id);

	public List<ValeurDTO> getValeurs();

	public void modifierValeur(ValeurDTO valeurDto);

}
