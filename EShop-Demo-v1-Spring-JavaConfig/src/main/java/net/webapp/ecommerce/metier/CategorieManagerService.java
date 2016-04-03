package net.webapp.ecommerce.metier;

import net.webapp.ecommerce.entites.Categorie;

public interface CategorieManagerService extends CatalogueService {

	public Long ajouterCategorie(Categorie c);

	public void supprimerCategrorie(Long idcat);

	public void modifierCategorie(Categorie c);

}
