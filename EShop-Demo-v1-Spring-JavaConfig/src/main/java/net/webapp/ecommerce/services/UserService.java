package net.webapp.ecommerce.services;

import net.webapp.ecommerce.entities.Role;
import net.webapp.ecommerce.entities.User;

public interface UserService {

	public void ajouterUser(User u);

	public void attribuerRole(Role r, Long userID);
	
}
