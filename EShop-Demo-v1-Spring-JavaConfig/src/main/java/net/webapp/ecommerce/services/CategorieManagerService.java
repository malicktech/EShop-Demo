package net.webapp.ecommerce.services;

import net.webapp.ecommerce.entities.Categorie;

public interface CategorieManagerService extends CatalogueService {

	public Long ajouterCategorie(Categorie c);

	public void supprimerCategrorie(Long idcat);

	public void modifierCategorie(Categorie c);

}
