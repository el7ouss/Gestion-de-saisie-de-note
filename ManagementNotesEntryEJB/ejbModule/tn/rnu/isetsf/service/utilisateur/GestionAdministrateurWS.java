package tn.rnu.isetsf.service.utilisateur;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.AdministrateurDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionAdministrateurWS extends java.rmi.Remote {
	@WebMethod
	public void creerAdministrateur(AdministrateurDTO adminDto);

	@WebMethod
	public AdministrateurDTO getAdministrateurById(Long id);

	@WebMethod
	public AdministrateurDTO getAdministrateurByUserNamePassword(
			String userName, String password);

	@WebMethod
	public Boolean findAdministrateurByUserNamePassword(String userName,
			String password);

	@WebMethod
	public AdministrateurDTO getAdministrateurByUserName(String userName);

	@WebMethod
	public Boolean findAdministrateurByUserName(String userName);

	@WebMethod
	public AdministrateurDTO[] getAdministrateursArray();

	@WebMethod
	public void modifierAdministrateur(AdministrateurDTO adminDto);
}
