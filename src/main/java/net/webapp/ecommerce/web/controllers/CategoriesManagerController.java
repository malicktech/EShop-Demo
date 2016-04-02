package net.webapp.ecommerce.web.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import net.webapp.ecommerce.entites.Categorie;
import net.webapp.ecommerce.metier.CategorieManagerService;

@Controller
@RequestMapping(value = "/categories")
@SessionAttributes("editedCat") // place les attribut editedCat du model dans la session
public class CategoriesManagerController implements HandlerExceptionResolver {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CategorieManagerService categorieService;

	/**
	 * Return Home Index page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", categorieService.listCategories());
		return "CategoriesView";
	}

	/**
	 * Enregistrer une catégorie
	 * 
	 * @param c
	 * @param bindingResult
	 * @param model
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String saveCat(@Valid Categorie c, BindingResult bindingResult, Model model, MultipartFile file)
			throws Exception {
		// test si le formulaire à des erreurs
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", categorieService.listCategories());
			return "CategoriesView";
		}
		if (!file.isEmpty()) {
			// check if really à photo, genere a exception and quit if not
			BufferedImage bi = ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
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
		return "CategoriesView";
	}

	/**
	 * 
	 * @param idCat
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getPhoto(Long idCat) throws IOException {
		Categorie c = categorieService.getCategorie(idCat);
		if (c.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	/**
	 * 
	 * @param idCat
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/suppCat")
	public String suppCat(Long idCat, Model model) {
		categorieService.supprimerCategrorie(idCat);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", categorieService.listCategories());
		return "CategoriesView";
	}

	/**
	 * 
	 * @param idCat
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editCat")
	public String editCat(Long idCat, Model model) {
		Categorie c = categorieService.getCategorie(idCat);
		model.addAttribute("editedCat", c); // place en session
		model.addAttribute("categorie", c);
		model.addAttribute("categories", categorieService.listCategories());
		return "CategoriesView";
	}

	/**
	 * handler Gestionnaire d'exception
	 */
	// @ExceptionHandler(MaxUploadSizeExceededException.class)
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception ex) {
		logger.error("Request: "+ request.getRequestURL() +" raised "+ ex);
		ex.printStackTrace();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("categorie", new Categorie());
		mv.addObject("categories", categorieService.listCategories());
		mv.addObject("exeption", ex.getMessage());
		mv.addObject("url", request.getRequestURL());
		mv.setViewName("CategoriesView");
		return mv;
	}
}
