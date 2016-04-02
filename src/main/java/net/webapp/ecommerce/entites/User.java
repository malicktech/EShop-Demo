package net.webapp.ecommerce.entites;

import java.io.Serializable;
import java.security.MessageDigest;
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
	@Column(name = "id_user")
	private Long id;

	@Column(name = "username", nullable = false)
	@Size(min = 4, max = 20)
	private String username;

	@NotEmpty
	private String password;

	private boolean activated;

	@OneToMany
	@JoinColumn(name = "id_user")
	private Collection<Role> roles;

	/* constructors */

	public User() {
		super();
	}

	public User(String userName, String password, boolean activated, Collection<Role> roles) {
		super();
		this.username = userName;
		this.password = password;
		this.activated = activated;
		this.roles = roles;
	}

	// getters and setters

	public Long getIdUser() {
		return id;
	}

	public void setIdUser(Long idUser) {
		this.id = idUser;

	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes("UTF8"));
			byte s[] = m.digest();
			String result = "";
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
			}
			this.password = result;
		} catch (Exception e) {
			e.printStackTrace();
			this.password = password;
		}

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
