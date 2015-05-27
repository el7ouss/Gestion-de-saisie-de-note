package tn.rnu.isetsf.model;

import java.util.Date;

import javax.persistence.PrePersist;

public class CreatedDateListener {
	@PrePersist
	public void persistCreationTimestamp(AbstractAttributeEntity aDE) {
		aDE.createdAt = new Date(System.currentTimeMillis());
		System.out.println("**********************************Created_At_Date************************************************");
	}
}
