package net.webapp.ecommerce.services;

import net.webapp.ecommerce.modeles.Produit;

public interface ProduitService extends InternauteService {

	public Long ajouterProduit(Produit p, Long idCat);

	public void supprimerProduit(Long idP);

	public void modifierProduit(Produit p);
}
