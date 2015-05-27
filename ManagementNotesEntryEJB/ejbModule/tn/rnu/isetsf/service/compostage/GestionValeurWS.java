package tn.rnu.isetsf.service.compostage;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.ValeurDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionValeurWS extends java.rmi.Remote {
	@WebMethod
	public void creerValeur(ValeurDTO valeurDto);

	@WebMethod
	public ValeurDTO getValeurById(Long id);

	@WebMethod
	public ValeurDTO[] getValeursArray();

	@WebMethod
	public void modifierValeur(ValeurDTO valeurDto);

}
