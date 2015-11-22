package net.webapp.ecommerce.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import net.webapp.ecommerce.dao.ECommerceDao;
import net.webapp.ecommerce.modeles.Categorie;
import net.webapp.ecommerce.modeles.Client;
import net.webapp.ecommerce.modeles.Commande;
import net.webapp.ecommerce.modeles.Panier;
import net.webapp.ecommerce.modeles.Produit;
import net.webapp.ecommerce.modeles.Role;
import net.webapp.ecommerce.modeles.User;
import net.webapp.ecommerce.services.CategorieService;

// déclare toute les méthode transactionel
@Transactional
public class EcommerceServiceImpl implements CategorieService {

	// injection dépendance via setters, ou utiliser annotation autowire

	private ECommerceDao dao;

	public void setDao(ECommerceDao dao) {
		this.dao = dao;
	}

	// method implement

	/**
	 * PRODUIT
	 */

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {
		dao.modifierProduit(p);
	}

	@Override
	public List<Produit> listproduits() {
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		return dao.getProduit(idP);
	}

	/**
	 * CATEGORIES
	 */

	@Override
	public Long ajouterCategorie(Categorie c) {
		return dao.ajouterCategorie(c);
	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return dao.getCategorie(idCat);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		dao.supprimerCategrorie(idcat);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
	}

	/**
	 * COMMANDES
	 */

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		return dao.enregistrerCommande(p, c);
	}

	/**
	 * USERS
	 */

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		dao.attribuerRole(r, userID);
	}

}
