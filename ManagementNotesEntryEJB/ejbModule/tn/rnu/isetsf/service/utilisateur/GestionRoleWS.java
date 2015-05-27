package tn.rnu.isetsf.service.utilisateur;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.RoleDTO;
import tn.rnu.isetsf.dto.UtilisateurDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionRoleWS extends java.rmi.Remote {
	@WebMethod
	public void creerRole(RoleDTO roleDto);

	@WebMethod
	public RoleDTO getRoleById(Long id);

	@WebMethod
	public RoleDTO[] getRolesArray();

	@WebMethod
	public UtilisateurDTO[] getUtilisateursOfRoleArray(RoleDTO roleDto);

	@WebMethod
	public void modifierRole(RoleDTO roleDto);

}
