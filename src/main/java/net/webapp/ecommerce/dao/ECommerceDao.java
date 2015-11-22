package net.webapp.ecommerce.dao;

import java.util.List;

import net.webapp.ecommerce.modeles.Categorie;
import net.webapp.ecommerce.modeles.Client;
import net.webapp.ecommerce.modeles.Commande;
import net.webapp.ecommerce.modeles.Panier;
import net.webapp.ecommerce.modeles.Produit;
import net.webapp.ecommerce.modeles.Role;
import net.webapp.ecommerce.modeles.User;

public interface ECommerceDao {

	/**
	 * Catégories DAO
	 */
	public Long ajouterCategorie(Categorie c);

	public List<Categorie> listCategories();

	public Categorie getCategorie(Long idCat);

	public void supprimerCategrorie(Long idcat);

	public void modifierCategorie(Categorie c);

	/**
	 * Produit DAO
	 */

	public Long ajouterProduit(Produit p, Long idCat);

	public List<Produit> listproduits();

	public List<Produit> produitsParMotCle(String mc);

	public List<Produit> produitsParCategorie(Long idCat);

	public List<Produit> produitsSelectionnes();

	public Produit getProduit(Long idP);

	public void supprimerProduit(Long idP);

	public void modifierProduit(Produit p);

	/**
	 * Users DAO
	 */
	public void ajouterUser(User u);

	public void attribuerRole(Role r, Long userID);

	/**
	 * Commandes DAO
	 */

	public Commande enregistrerCommande(Panier p, Client c);
}
