package net.webapp.ecommerce.metier.impl;

import java.util.List;

import javax.transaction.Transactional;

import net.webapp.ecommerce.dao.EBoutiqueDao;
import net.webapp.ecommerce.entites.Categorie;
import net.webapp.ecommerce.entites.Client;
import net.webapp.ecommerce.entites.Commande;
import net.webapp.ecommerce.entites.Produit;
import net.webapp.ecommerce.entites.Role;
import net.webapp.ecommerce.entites.User;
import net.webapp.ecommerce.metier.CategorieManagerService;
import net.webapp.ecommerce.metier.ProduitManagerService;
import net.webapp.ecommerce.metier.UserService;
import net.webapp.ecommerce.web.modeles.Panier;

@Transactional
public class EBoutiqueServiceImpl implements CategorieManagerService, ProduitManagerService, UserService {

	// injection dépendance via setters 
	// ou utiliser annotation autowire
	private EBoutiqueDao dao;	
	public void setDao(EBoutiqueDao dao) {
		this.dao = dao;
	}


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
