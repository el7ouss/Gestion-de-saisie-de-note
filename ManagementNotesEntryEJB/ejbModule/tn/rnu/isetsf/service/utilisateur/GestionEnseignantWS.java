package tn.rnu.isetsf.service.utilisateur;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.EnseignantDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionEnseignantWS extends java.rmi.Remote {
	@WebMethod
	public void creerEnseignant(EnseignantDTO ensDto);

	@WebMethod
	public EnseignantDTO getEnseignantById(Long id);

	@WebMethod
	public EnseignantDTO getEnseignantByUserNamePassword(String userName,
			String password);

	@WebMethod
	public Boolean findEnseignantByUserNamePassword(String userName,
			String password);

	@WebMethod
	public EnseignantDTO getEnseignantByUserName(String userName);

	@WebMethod
	public Boolean findEnseignantByUserName(String userName);

	@WebMethod
	public EnseignantDTO[] getEnseignantsArray();

	@WebMethod
	public CourDTO[] getCoursOfEnseignantArray(EnseignantDTO enseignantDto);

	@WebMethod
	public void modifierEnseignant(EnseignantDTO ensDto);

}
