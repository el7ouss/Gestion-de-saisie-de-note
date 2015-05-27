package tn.rnu.isetsf.service.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.rnu.isetsf.common.helper.RoleHelper;
import tn.rnu.isetsf.common.helper.UtilisateurHelper;
import tn.rnu.isetsf.dao.RoleDAORemote;
import tn.rnu.isetsf.dto.RoleDTO;
import tn.rnu.isetsf.dto.UtilisateurDTO;
import tn.rnu.isetsf.model.Role;
import tn.rnu.isetsf.model.Utilisateur;

/**
 * Session Bean implementation class GestionRole
 */
@SuppressWarnings("serial")
//@LocalBean
@WebService(endpointInterface="tn.rnu.isetsf.service.utilisateur.GestionRoleWS")
@Stateless//(mappedName = "gestionrole")
public class GestionRole implements GestionRoleRemote, GestionRoleLocal, Serializable {
	
	@EJB
	RoleDAORemote roleDao;
    /**
     * Default constructor. 
     */
    public GestionRole() {
    	
    }
    
    public void creerRole(RoleDTO roleDto){
    	Role role = RoleHelper.DTOToModel(roleDto);
    	roleDao.save(role);
    }
    
    public RoleDTO getRoleById(Long id)
    {
    	Role role = roleDao.getById(id);
    	RoleDTO roleDto=RoleHelper.modelToDTO(role);
    	return roleDto;
    }
    
    public List<RoleDTO> getRoles()
    {
    	List<Role> roles=roleDao.getAll();
    	List<RoleDTO> rolesDto=new ArrayList<RoleDTO>();
    	for(Role role:roles)
    	{
    		rolesDto.add(RoleHelper.modelToDTO(role));
    	}
    	return rolesDto;
    }
    
    public RoleDTO[] getRolesArray()
    {
    	return getRoles().toArray(new RoleDTO[getRoles().size()]);
    }
    
    public List<UtilisateurDTO> getUtilisateursOfRole(
			RoleDTO roleDto) {
		Role role = RoleHelper.DTOToModel(roleDto);
		List<Utilisateur> userList = roleDao
				.getAllUtilisateur(role);
		List<UtilisateurDTO> userDtoList = new ArrayList<UtilisateurDTO>();
		for (Utilisateur user : userList) {
			UtilisateurDTO userDto = new UtilisateurDTO();
			userDto = UtilisateurHelper.modelToDTO(user);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	public UtilisateurDTO[] getUtilisateursOfRoleArray(RoleDTO roleDto) {
		return getUtilisateursOfRole(roleDto).toArray(
				new UtilisateurDTO[getUtilisateursOfRole(roleDto)
						.size()]);
	}
    
    public void modifierRole(RoleDTO roleDto)
    {
    	Role role = RoleHelper.DTOToModel(roleDto);
    	roleDao.edit(role);
    }

}
