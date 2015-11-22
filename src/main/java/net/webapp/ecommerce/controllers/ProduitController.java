package net.webapp.ecommerce.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.webapp.ecommerce.modeles.Produit;
import net.webapp.ecommerce.services.ProduitService;

@Controller
@RequestMapping(value = "/adminProd")
public class ProduitController {

	@Autowired
	private ProduitService produitService;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", produitService.listproduits());
		model.addAttribute("categories", produitService.listCategories());
		return "produits";
	}

	@RequestMapping(value = "/save")
	public String saveProd(@Valid Produit p, BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", produitService.listCategories());
			model.addAttribute("produits", produitService.listproduits());
			return ("produit");
		}
		if (!file.isEmpty()) {
			String path = System.getProperty("java.io.tmpdir");
			p.setPhoto(file.getOriginalFilename());
			Long idP = null;
			if (p.getIdProduit() == null) {
				idP = produitService.ajouterProduit(p, p.getCategorie().getIdCategorie());
			} else {
				produitService.modifierProduit(p);
				idP = p.getIdProduit();
			}
			file.transferTo(new File(path + "/" + "PROD_" + idP + "_" + file.getOriginalFilename()));
		} else {
			if (p.getIdProduit() == null)
				produitService.ajouterProduit(p, p.getCategorie().getIdCategorie());
			else
				produitService.modifierProduit(p);
		}
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", produitService.listproduits());
		model.addAttribute("categories", produitService.listCategories());
		return "produit";
	}

	@RequestMapping(value = "photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photCat(Long idProd) throws IOException {
		Produit p = produitService.getProduit(idProd);
		File f = new File(System.getProperty("java.io.tmpdir") + "/PROD_" + idProd + "_" + p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/delete")
	public String supp(Long idProd, Model model) {
		produitService.supprimerProduit(idProd);
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", produitService.listproduits());
		model.addAttribute("categories", produitService.listCategories());
		return "produit";
	}

	@RequestMapping(value = "/edit")
	public String edit(Long idProd, Model model) {
		Produit p = produitService.getProduit(idProd);
		model.addAttribute("produit", p);
		model.addAttribute("produits", produitService.listproduits());
		model.addAttribute("categories", produitService.listCategories());
		return "produit";
	}
}
