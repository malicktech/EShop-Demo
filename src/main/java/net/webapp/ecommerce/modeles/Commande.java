package net.webapp.ecommerce.modeles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;

	@Column(nullable = false)
	// @Temporal(TemporalType.TIMESTAMP) // Date avec heure
	private Date dateCommande;

	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

	@OneToMany
	@JoinColumn(name = "idCommande")
	private Collection<LigneCommande> ligneCommandes;

	// constructor

	public Commande() {
		super();
	}

	public Commande(Date dateCommande, Client client, Collection<LigneCommande> ligneCommandes) {
		super();
		this.dateCommande = dateCommande;
		this.client = client;
		this.ligneCommandes = ligneCommandes;
	}

	// getters and setters

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Collection<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

}
