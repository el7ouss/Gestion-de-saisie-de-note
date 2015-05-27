package tn.rnu.isetsf.service.parametres;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.FormationDTO;
import tn.rnu.isetsf.dto.NiveauDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionFormationWS extends java.rmi.Remote {
	@WebMethod
	public void creerFormation(FormationDTO formationDto);

	@WebMethod
	public FormationDTO getFormationById(Long id);

	@WebMethod
	public FormationDTO[] getFormationsArray();

	@WebMethod
	public NiveauDTO[] getNiveauxOfFormationArray(FormationDTO formationDto);

	@WebMethod
	public void modifierFormation(FormationDTO formationDto);

}
