package tn.rnu.isetsf.model;

import javax.persistence.PrePersist;

public class EnabledUserListener {
	@PrePersist
	public void persistEnabled(Utilisateur aDE) {
		aDE.enabled = (byte) 1;
		System.out.println("**********************************Enabled_User************************************************");
	}
}
