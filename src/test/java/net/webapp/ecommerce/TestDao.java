package net.webapp.ecommerce;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.webapp.ecommerce.modeles.Categorie;
import net.webapp.ecommerce.modeles.Produit;
import net.webapp.ecommerce.services.CategorieService;

public class TestDao {

	ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
	}

	@Test
	public void testCategorie() {
		try {
			CategorieService service = (CategorieService) context.getBean("service");

			List<Categorie> cats1 = service.listCategories();

			service.ajouterCategorie(new Categorie("Ordinateur", "Description Catégorie Ordinateurs"));
			service.ajouterCategorie(new Categorie("Imprimante", "Description Catégorie Imprimantes"));
			service.ajouterCategorie(new Categorie("Téléphone", "Description Catégorie Téléphone"));

			List<Categorie> cats2 = service.listCategories();

			assertTrue(cats2.size() == cats1.size() + 3);

		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

	@Test
	public void testProduit() {
		try {
			CategorieService service = (CategorieService) context.getBean("service");

			List<Produit> prods1 = service.listproduits();

			service.ajouterProduit(new Produit("HP453", "Desc HP453", 600, "image-HP453.jpg", 100), 1L);
			service.ajouterProduit(new Produit("Satellite C70", "Desc Satellite C70", 500, "image-C70.jpg", 100), 1L);

			List<Produit> prods2 = service.listproduits();

			assertTrue(prods2.size() == prods1.size() + 2);

		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
}
