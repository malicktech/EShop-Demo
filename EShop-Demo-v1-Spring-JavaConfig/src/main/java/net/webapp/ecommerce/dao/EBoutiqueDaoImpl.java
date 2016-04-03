package net.webapp.ecommerce.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import net.webapp.ecommerce.entities.Categorie;
import net.webapp.ecommerce.entities.Client;
import net.webapp.ecommerce.entities.Commande;
import net.webapp.ecommerce.entities.LigneCommande;
import net.webapp.ecommerce.entities.Produit;
import net.webapp.ecommerce.entities.Role;
import net.webapp.ecommerce.entities.User;
import net.webapp.ecommerce.web.modeles.Panier;
/**
 * 
 * @author Malick
 *
 */
@Repository("eBoutiqueDao")
// @Scope("prototype")
public class EBoutiqueDaoImpl implements EBoutiqueDao {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Catégories 
	 */

	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		Query req = em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		Categorie c = em.find(Categorie.class, idcat);
		em.remove(c);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
	}

	/**
	 * Produit DAO
	 */

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		Categorie c = getCategorie(idCat);
		p.setCategorie(c);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public void supprimerProduit(Long idP) {
		Produit p = getProduit(idP);
		em.remove(p);
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
	}
	

	@Override
	public Produit getProduit(Long idP) {
		return em.find(Produit.class, idP);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> listproduits() {
		Query req = em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req = em.createQuery("select p from Produit p where p.designation like :x or p.description like:x");
		req.setParameter("x", "%" + mc + "%");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		Query req = em.createQuery("select p from Produit p where p.categorie.idCategorie=:x");
		req.setParameter("x", idCat);
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		Query req = em.createQuery("select p from Produit p where p.selected=true");
		return req.getResultList();
	}



	/**
	 * Users DAO
	 */
	@Override
	public void ajouterUser(User u) {
		em.persist(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		User u = em.find(User.class, userID);
		u.getRoles().add(r);
		// r.setUser(u);
		em.persist(r);
	}

	/**
	 * Commandes DAO
	 */
	@Override
	public Commande enregistrerCommande(Panier panier, Client c) {
		em.persist(c);
		Commande cmd = new Commande();
		cmd.setDateCommande(new Date());
		cmd.setLigneCommandes(panier.getItems());
		// on enregistre les ligne de commande ou on met cascade all sur commande
		// TODO a TESTER 
		for (LigneCommande lc : panier.getItems()) {
			em.persist(lc);
		}
		cmd.setClient(c);
		em.persist(cmd);
		return cmd;
	}

}
