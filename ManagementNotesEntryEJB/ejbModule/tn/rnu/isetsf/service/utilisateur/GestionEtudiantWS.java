package tn.rnu.isetsf.service.utilisateur;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import tn.rnu.isetsf.dto.EtudiantDTO;
import tn.rnu.isetsf.dto.ValeurDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GestionEtudiantWS {
	@WebMethod
	public void creerEtudiant(EtudiantDTO etudDto);

	@WebMethod
	public EtudiantDTO getEtudiantById(Long id);

	@WebMethod
	public EtudiantDTO getEtudiantByUserNamePassword(String userName,
			String password);

	@WebMethod
	public Boolean findEtudiantByUserNamePassword(String userName,
			String password);

	@WebMethod
	public EtudiantDTO getEtudiantByUserName(String userName);

	@WebMethod
	public Boolean findEtudiantByUserName(String userName);

	@WebMethod
	public EtudiantDTO getEtudiantByCin(Long cin);

	@WebMethod
	public EtudiantDTO getEtudiantByNumInscrit(Long numInscrit);

	@WebMethod
	public EtudiantDTO[] getEtudiantsArray();

	@WebMethod
	public ValeurDTO[] getValeursOfEtudiantArray(EtudiantDTO etudiantDto);

	@WebMethod
	public void modifierEtudiant(EtudiantDTO etudDto);

}
