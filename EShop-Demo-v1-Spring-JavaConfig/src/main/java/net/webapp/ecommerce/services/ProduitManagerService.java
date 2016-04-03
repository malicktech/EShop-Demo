package net.webapp.ecommerce.services;

import net.webapp.ecommerce.entities.Produit;

public interface ProduitManagerService extends CatalogueService {

	public Long ajouterProduit(Produit p, Long idCat);

	public void supprimerProduit(Long idP);

	public void modifierProduit(Produit p);
}
