package tn.rnu.isetsf.model;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.persistence.PostPersist;

import tn.rnu.isetsf.dao.RoleDAORemote;

@SuppressWarnings("serial")
public class RoleAdminListener implements Serializable {
	@EJB
	RoleDAORemote roleDao;

	@PostPersist
	public void persistRoleAdmin(Utilisateur admin) {
		admin.role = new Role();
		admin.role = roleDao.getById((long) 1);
	}
}
