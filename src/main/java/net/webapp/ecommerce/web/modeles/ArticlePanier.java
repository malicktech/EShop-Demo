package net.webapp.ecommerce.web.modeles;

import net.webapp.ecommerce.entites.Produit;

public class ArticlePanier {

	private Produit produit;
	private int quantite;
		
	
	public ArticlePanier() {
		super();
	}
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	
}
