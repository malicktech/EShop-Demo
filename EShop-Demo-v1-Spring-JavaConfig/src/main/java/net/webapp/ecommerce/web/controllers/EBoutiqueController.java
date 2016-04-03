package net.webapp.ecommerce.web.controllers;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.webapp.ecommerce.entities.Produit;
import net.webapp.ecommerce.services.CatalogueService;
import net.webapp.ecommerce.web.modeles.Panier;

@Controller
@SessionAttributes("panier")
public class EBoutiqueController {
	@Autowired
	private CatalogueService metier;

	@RequestMapping("/index")
	public String index(Model model) {
		if (model.asMap().get("panier") == null) {
			model.addAttribute("panier", new Panier());
		}
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.produitsSelectionnes());
		return "index";
	}

	@RequestMapping("/produitsParCat")
	public String produitsParCat(@RequestParam Long idCat, Model model) {
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.produitsParCategorie(idCat));
		return "index";
	}

	@RequestMapping("/chercherProduits")
	public String chercherProduits(@RequestParam String mc, Model model) {
		model.addAttribute("mc", mc);
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.produitsParMotCle(mc));
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/photoProduit", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] photoProd(@RequestParam("idP") Long idP) throws Exception {
		Produit p = metier.getProduit(idP);
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		// FileInputStream input = classLoader.getResourceAsStream("src/main/resources/ids.txt");

		
		// String path = System.getProperty("java.io.tmpdir") + "/" + p.getIdProduit();
		String pathToProductImage = "resources/images/product/" + p.getPhoto();	
		return IOUtils.toByteArray(new FileInputStream(pathToProductImage));
	}

	@RequestMapping("/ajouterAuPanier")
	public String chercherProduits(@RequestParam Long idProduit, @RequestParam int quantite, Model model) {
		Panier panier = null;
		if (model.asMap().get("panier") == null) {
			panier = new Panier();
			model.addAttribute("panier", panier);
		} else
			panier = (Panier) model.asMap().get("panier");
		panier.addItem(metier.getProduit(idProduit), quantite);
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.produitsSelectionnes());
		return "index";
	}

}
