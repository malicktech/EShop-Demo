package net.webapp.ecommerce.services;

import java.util.List;

import net.webapp.ecommerce.modeles.Categorie;
import net.webapp.ecommerce.modeles.Client;
import net.webapp.ecommerce.modeles.Commande;
import net.webapp.ecommerce.modeles.Panier;
import net.webapp.ecommerce.modeles.Produit;

public interface InternauteService {

	public List<Categorie> listCategories();

	public Categorie getCategorie(Long idCat);

	public List<Produit> listproduits();

	public List<Produit> produitsParMotCle(String mc);

	public List<Produit> produitsParCategorie(Long idCat);

	public List<Produit> produitsSelectionnes();

	public Produit getProduit(Long idP);

	public Commande enregistrerCommande(Panier p, Client c);
}
