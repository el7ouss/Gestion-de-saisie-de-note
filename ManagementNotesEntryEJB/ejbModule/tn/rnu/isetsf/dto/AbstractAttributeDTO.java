package tn.rnu.isetsf.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public abstract class AbstractAttributeDTO implements Serializable {
	
	protected Date createdAt;
	
	protected Date updatedAt;
	
	protected String createdAtString;
	
	protected String updatedAtString;
	
	protected Byte enabled;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}
	
	public String getCreatedAtString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat();
        sdf1.applyPattern("dd/MM/yyyy HH:mm:ss");
		createdAtString=sdf1.format(createdAt);
		return createdAtString;
	}

	public void setCreatedAtString(String createdAtString) {
		this.createdAtString = createdAtString;
	}

	public String getUpdatedAtString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat();
        sdf1.applyPattern("dd/MM/yyyy HH:mm:ss");
		updatedAtString=sdf1.format(updatedAt);
		return updatedAtString;
	}

	public void setUpdatedAtString(String updatedAtString) {
		this.updatedAtString = updatedAtString;
	}

}
