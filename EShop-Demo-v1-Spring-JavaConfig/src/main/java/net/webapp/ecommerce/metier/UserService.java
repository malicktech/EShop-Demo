package net.webapp.ecommerce.metier;

import net.webapp.ecommerce.entites.Role;
import net.webapp.ecommerce.entites.User;

public interface UserService {

	public void ajouterUser(User u);

	public void attribuerRole(Role r, Long userID);
	
}
