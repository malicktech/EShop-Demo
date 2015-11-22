package net.webapp.ecommerce.modeles;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long idUser;

	@Column(name = "user_name", nullable = false)
	@Size(min = 4, max = 20)
	private String userName;

	@NotEmpty
	@Size(min = 4, max = 10)
	private String password;

	private boolean activated;

	@OneToMany
	@JoinColumn(name = "user_id")
	private Collection<Role> roles;

	// constructor

	public User() {
		super();
	}

	public User(String userName, String password, boolean activated, Collection<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.activated = activated;
		this.roles = roles;
	}

	// getters and setters

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
