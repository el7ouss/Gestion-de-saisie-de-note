package tn.rnu.isetsf.service.parametres;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.MatiereDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionMatiereWS extends java.rmi.Remote {
	@WebMethod
	public void creerMatiere(MatiereDTO matiereDto);

	@WebMethod
	public MatiereDTO getMatiereById(Long id);

	@WebMethod
	public MatiereDTO[] getMatieresArray();

	@WebMethod
	public CourDTO[] getCoursOfMatiereArray(MatiereDTO matiereDto);

	@WebMethod
	public void modifierMatiere(MatiereDTO matiereDto);

}
