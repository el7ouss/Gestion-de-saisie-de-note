package tn.rnu.isetsf.service.compostage;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.NoteDTO;
import tn.rnu.isetsf.dto.ValeurDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionNoteWS extends java.rmi.Remote {
	@WebMethod
	public void creerNote(NoteDTO noteDto);

	@WebMethod
	public NoteDTO getNoteById(Long id);

	@WebMethod
	public NoteDTO[] getNotesArray();

	@WebMethod
	public ValeurDTO[] getValeursOfNoteArray(NoteDTO noteDto);

	@WebMethod
	public void modifierNote(NoteDTO etudDto);

}
