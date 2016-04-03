package net.webapp.ecommerce;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPAHibernate {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
