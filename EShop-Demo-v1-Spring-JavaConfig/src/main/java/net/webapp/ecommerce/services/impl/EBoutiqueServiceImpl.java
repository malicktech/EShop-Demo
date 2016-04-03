package net.webapp.ecommerce.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.webapp.ecommerce.dao.EBoutiqueDao;
import net.webapp.ecommerce.entities.Categorie;
import net.webapp.ecommerce.entities.Client;
import net.webapp.ecommerce.entities.Commande;
import net.webapp.ecommerce.entities.Produit;
import net.webapp.ecommerce.entities.Role;
import net.webapp.ecommerce.entities.User;
import net.webapp.ecommerce.services.CategorieManagerService;
import net.webapp.ecommerce.services.ProduitManagerService;
import net.webapp.ecommerce.services.UserService;
import net.webapp.ecommerce.web.modeles.Panier;

@Service("eBoutiqueService")
@Transactional
public class EBoutiqueServiceImpl implements CategorieManagerService, ProduitManagerService, UserService {

	@Autowired(required=true)
	@Qualifier("eBoutiqueDao")
	private EBoutiqueDao dao;

//	private EBoutiqueDao dao;
//	@Autowired
//	public EBoutiqueServiceImpl(@Qualifier("eBoutiqueDao") EBoutiqueDao dao) {
//		this.dao = dao;
//	}

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

	@Transactional(readOnly=true)
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
	
	@Transactional(readOnly=true)
	@Override
	public List<Produit> produitsSelectionnes() {
		return dao.produitsSelectionnes();
	}

	@Transactional(readOnly=true)
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

	
	@Transactional(readOnly=true)
	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Transactional(readOnly=true)
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
