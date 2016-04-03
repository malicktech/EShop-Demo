package net.webapp.ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;

	// @NotEmpty // hibernate validor
	// @Column(unique = true, nullable = false) or @NotNull // JPA WAy of declaring a column to be not-null.

	@NotEmpty
	@Size(min = 4, max = 20)
	private String nomCategorie;
	private String description;
	@Lob
	private byte[] photo;
	private String nomPhoto;

	@OneToMany(mappedBy = "categorie")
	private Collection<Produit> produits = new ArrayList<Produit>();

	// constructors

	public Categorie() {
		super();
	}

	public Categorie(String nomCategorie, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
	}

	// getters and setters

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}

}
