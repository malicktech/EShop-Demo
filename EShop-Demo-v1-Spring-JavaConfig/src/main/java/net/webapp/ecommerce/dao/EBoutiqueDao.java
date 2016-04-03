package net.webapp.ecommerce.dao;

import java.util.List;

import net.webapp.ecommerce.entities.Categorie;
import net.webapp.ecommerce.entities.Client;
import net.webapp.ecommerce.entities.Commande;
import net.webapp.ecommerce.entities.Produit;
import net.webapp.ecommerce.entities.Role;
import net.webapp.ecommerce.entities.User;
import net.webapp.ecommerce.web.modeles.Panier;

/**
 * 
 * @author Malick
 *
 */
public interface EBoutiqueDao {

	/**
	 * Catégories
	 */
	public Long ajouterCategorie(Categorie c);

	public List<Categorie> listCategories();

	public Categorie getCategorie(Long idCat);

	public void supprimerCategrorie(Long idcat);

	public void modifierCategorie(Categorie c);

	/**
	 * Produit
	 */

	public Long ajouterProduit(Produit p, Long idCat);

	public void supprimerProduit(Long idP);

	public void modifierProduit(Produit p);
	
	
	public Produit getProduit(Long idP);

	public List<Produit> listproduits();

	public List<Produit> produitsParMotCle(String mc);

	public List<Produit> produitsParCategorie(Long idCat);

	public List<Produit> produitsSelectionnes();
	
	
	


	/**
	 * Users 
	 * TODO move to UserDao
	 */
	public void ajouterUser(User u);

	public void attribuerRole(Role r, Long userID);

	/**
	 * Commandes
	 */

	public Commande enregistrerCommande(Panier p, Client c);
}
