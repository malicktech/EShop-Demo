package net.webapp.ecommerce.services;

import java.util.List;

import net.webapp.ecommerce.entities.Categorie;
import net.webapp.ecommerce.entities.Client;
import net.webapp.ecommerce.entities.Commande;
import net.webapp.ecommerce.entities.Produit;
import net.webapp.ecommerce.web.modeles.Panier;

public interface CatalogueService {

	
	public List<Categorie> listCategories();

	public Categorie getCategorie(Long idCat);

	
	public Produit getProduit(Long idP);
	
	public List<Produit> listproduits();

	public List<Produit> produitsParMotCle(String mc);

	public List<Produit> produitsParCategorie(Long idCat);

	public List<Produit> produitsSelectionnes();


	public Commande enregistrerCommande(Panier p, Client c);
}
