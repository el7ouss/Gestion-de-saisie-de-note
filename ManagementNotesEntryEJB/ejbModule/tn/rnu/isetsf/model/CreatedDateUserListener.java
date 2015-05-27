package tn.rnu.isetsf.model;

import java.util.Date;

import javax.persistence.PrePersist;

public class CreatedDateUserListener {
	@PrePersist
	public void persistCreationTimestamp(Utilisateur aDE) {
		aDE.createdAt = new Date(System.currentTimeMillis());
		System.out.println("**********************************Created_At_Date_User************************************************");
	}
}
