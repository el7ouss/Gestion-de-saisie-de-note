package tn.rnu.isetsf.model;

import javax.persistence.PrePersist;

public class EnabledListener {
	@PrePersist
	public void persistEnabled(AbstractAttributeEntity aDE) {
		aDE.enabled = (byte) 1;
		System.out.println("**********************************Enabled************************************************");
	}
}
