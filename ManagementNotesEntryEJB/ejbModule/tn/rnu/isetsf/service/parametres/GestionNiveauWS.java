package tn.rnu.isetsf.service.parametres;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.EtudiantDTO;
import tn.rnu.isetsf.dto.NiveauDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionNiveauWS extends java.rmi.Remote {
	@WebMethod
	public void creerNiveau(NiveauDTO niveauDto);

	@WebMethod
	public NiveauDTO getNiveauById(Long id);

	@WebMethod
	public NiveauDTO[] getNiveausArray();

	@WebMethod
	public CourDTO[] getCoursOfNiveauArray(NiveauDTO niveauDto);

	@WebMethod
	public EtudiantDTO[] getEtudiantsOfNiveauArray(NiveauDTO niveauDto);

	@WebMethod
	public void modifierNiveau(NiveauDTO niveauDto);

}
