package tn.rnu.isetsf.service.utilisateur;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.UtilisateurDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionUtilisateurWS {
	@WebMethod
	public void creerUtilisateur(UtilisateurDTO userDto);

	@WebMethod
	public UtilisateurDTO getUtilisateurById(Long id);

	@WebMethod
	public UtilisateurDTO getUtilisateurByUserNamePassword(String userName,
			String password);

	@WebMethod
	public Boolean findUtilisateurByUserNamePassword(String userName,
			String password);

	@WebMethod
	public UtilisateurDTO getUtilisateurByUserName(String userName);

	@WebMethod
	public Boolean findUtilisateurByUserName(String userName);

	@WebMethod
	public UtilisateurDTO[] getUtilisateursArray();

	@WebMethod
	public void modifierUtilisateur(UtilisateurDTO etudDto);
}
