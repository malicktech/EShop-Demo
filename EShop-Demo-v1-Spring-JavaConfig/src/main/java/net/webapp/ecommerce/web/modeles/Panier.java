package net.webapp.ecommerce.web.modeles;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.webapp.ecommerce.entites.LigneCommande;
import net.webapp.ecommerce.entites.Produit;

public class Panier implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();

	/* methodes utilitaireS */

	/**
	 * Ajouter un produit
	 */
	public void addItem(Produit p, int quantite) {
		LigneCommande lc = items.get(p.getIdProduit());
		if (lc == null) {
			LigneCommande article = new LigneCommande();
			article.setProduit(p);
			article.setQuantite(quantite);
			article.setPrix(p.getPrix());
			items.put(p.getIdProduit(), lc);
		} else {
			lc.setQuantite(lc.getQuantite() + quantite);
		}
		// TODO test ligneComlande non sérializable comme article panier

	}

	/**
	 * ensemble des articles du panier
	 */
	public Collection<LigneCommande> getItems() {
		return items.values();
	}

	/**
	 * Nombre de produit
	 */
	public int getSize() {		
//		int nb=0;
//		Collection<LigneCommande> items = getItems();
//		for(LigneCommande item : items){
//		nb += item.getQuantite();
//		}
//		return nb;
		return items.size();
	}

	/**
	 * total du panier
	 */

	public double getTotal() {
		double total = 0;
		for (LigneCommande lc : items.values()) {
			total += lc.getPrix() * lc.getQuantite();
		}
		return total;
	}

	/**
	 * Supprimer un produit du panier
	 */
	public void deleteItem(Long idproduit) {
		items.remove(idproduit);
	}
}
