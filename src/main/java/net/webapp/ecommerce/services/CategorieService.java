package net.webapp.ecommerce.services;

import net.webapp.ecommerce.modeles.Categorie;
import net.webapp.ecommerce.modeles.Role;
import net.webapp.ecommerce.modeles.User;

public interface CategorieService extends ProduitService {

	public Long ajouterCategorie(Categorie c);

	public void supprimerCategrorie(Long idcat);

	public void modifierCategorie(Categorie c);

	public void ajouterUser(User u);

	public void attribuerRole(Role r, Long userID);

}
