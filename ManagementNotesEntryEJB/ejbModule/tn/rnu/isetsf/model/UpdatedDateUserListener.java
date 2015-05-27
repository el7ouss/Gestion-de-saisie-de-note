package tn.rnu.isetsf.model;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UpdatedDateUserListener {
	@PrePersist
	@PreUpdate
	public void updateModificationTimestamp(Utilisateur aDE) {
		aDE.updatedAt = new Date(System.currentTimeMillis());
		System.out.println("**********************************Updated_At_Date_User************************************************");
	}
}
