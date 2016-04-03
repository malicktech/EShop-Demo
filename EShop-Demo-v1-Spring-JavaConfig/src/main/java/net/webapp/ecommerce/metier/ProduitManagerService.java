package net.webapp.ecommerce.metier;

import net.webapp.ecommerce.entites.Produit;

public interface ProduitManagerService extends CatalogueService {

	public Long ajouterProduit(Produit p, Long idCat);

	public void supprimerProduit(Long idP);

	public void modifierProduit(Produit p);
}
