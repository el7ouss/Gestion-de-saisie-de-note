package tn.rnu.isetsf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@EntityListeners({CreatedDateUserListener.class, UpdatedDateUserListener.class, EnabledUserListener.class})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", length = 5)
@Table(name = "utilisateur")
// @NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "user_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "user_gen")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "enabled")
	protected Byte enabled;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "user_name", unique = true, nullable = false)
	private String userName;

	@ManyToOne()
	@JoinColumn(name = "role")
	protected Role role;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at"/*, nullable=false*/)
	protected Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at"/*, nullable=false*/)
	protected Date updatedAt;

	public Utilisateur() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}