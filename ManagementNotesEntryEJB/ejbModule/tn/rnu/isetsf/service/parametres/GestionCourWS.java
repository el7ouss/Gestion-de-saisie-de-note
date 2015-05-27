package tn.rnu.isetsf.service.parametres;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.CourDTO;
import tn.rnu.isetsf.dto.NoteDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionCourWS extends java.rmi.Remote {
	@WebMethod
	public void creerCour(CourDTO courDto);

	@WebMethod
	public CourDTO getCourById(Long id);

	@WebMethod
	public CourDTO[] getCoursArray();

	@WebMethod
	public NoteDTO[] getNotesOfCourArray(CourDTO courDto);

	@WebMethod
	public void modifierCour(CourDTO etudDto);

}
