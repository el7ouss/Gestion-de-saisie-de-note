package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners({CreatedDateListener.class, UpdatedDateListener.class, EnabledListener.class})
@Embeddable
public abstract class AbstractAttributeEntity implements Serializable {
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at"/*, nullable=false*/)
	protected Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at"/*, nullable=false*/)
	protected Date updatedAt;
	
	@Column(name="enabled")
	protected Byte enabled;

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

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
}
