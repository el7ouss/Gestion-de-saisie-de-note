package tn.rnu.isetsf.service.parametres;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.DepartementDTO;
import tn.rnu.isetsf.dto.FormationDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionDepartementWS extends java.rmi.Remote {
	@WebMethod
	public void creerDepartement(DepartementDTO departementDto);

	@WebMethod
	public DepartementDTO getDepartementById(Long id);

	@WebMethod
	public DepartementDTO[] getDepartementsArray();

	@WebMethod
	public FormationDTO[] getFormationsOfDepartementArray(DepartementDTO departementDto);

	@WebMethod
	public void modifierDepartement(DepartementDTO departementDto);

}
