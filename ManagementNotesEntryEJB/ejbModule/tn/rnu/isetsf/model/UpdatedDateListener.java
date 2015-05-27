package tn.rnu.isetsf.model;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UpdatedDateListener {
	@PreUpdate
	@PrePersist
	public void updateModificationTimestamp(AbstractAttributeEntity aDE) {
		aDE.updatedAt = new Date(System.currentTimeMillis());
		System.out.println("**********************************Updated_At_Date************************************************");
	}
}
