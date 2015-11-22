package net.webapp.ecommerce.controllers;

import java.io.ByteArrayInputStream;
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

import net.webapp.ecommerce.modeles.Categorie;
import net.webapp.ecommerce.services.CategorieService;

@Controller
@RequestMapping(value = "/categorie")
public class CategorieController {

	@Autowired
	private CategorieService categorieService;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", categorieService.listCategories());
		return "categorie";
	}

	@RequestMapping("/save")
	public String saveCat(@Valid Categorie c, BindingResult bindingResult, Model model, MultipartFile file)
			throws Exception {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", categorieService.listCategories());
			return "categorie";
		}
		if (!file.isEmpty()) {
			c.setPhoto(file.getBytes());
		} else {
			if (c.getIdCategorie() != null) {
				Categorie cat = (Categorie) model.asMap().get("editedCat");
				c.setPhoto(cat.getPhoto());
			}
		}
		if (c.getIdCategorie() == null)
			categorieService.ajouterCategorie(c);
		else
			categorieService.modifierCategorie(c);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", categorieService.listCategories());
		return "categorie";
	}

	@RequestMapping(value = "/photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idCat) throws IOException {
		Categorie c = categorieService.getCategorie(idCat);
		if (c.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@RequestMapping(value = "/suppCat")
	public String suppCat(Long idCat, Model model) {
		categorieService.supprimerCategrorie(idCat);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", categorieService.listCategories());
		return "categorie";
	}

	@RequestMapping(value = "/editCat")
	public String editCat(Long idCat, Model model) {
		Categorie c = categorieService.getCategorie(idCat);
		model.addAttribute("editedCat", c);
		model.addAttribute("categorie", c);
		model.addAttribute("categories", categorieService.listCategories());
		return "categorie";
	}
}
