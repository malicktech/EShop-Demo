package net.webapp.ecommerce.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * equivalent of servlet-context
 * 
 * @author Malick
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(WebMvcConfig.class);

	/**
	 * Resolves views selected for rendering by "@Controllers" to .jsp resources
	 * in the /WEB-INF/views directory
	 * 
	 * TODO : replace tiles by thymeleaf
	 */
	// @Bean
	// public InternalResourceViewResolver setupViewResolver() {
	// InternalResourceViewResolver resolver = new
	// InternalResourceViewResolver();
	// resolver.setViewClass(JstlView.class);
	// resolver.setPrefix("/WEB-INF/pages/");
	// resolver.setSuffix(".jsp");
	// return resolver;
	// }

	// Tiles View Resolver Configuration
	@Bean
	TilesViewResolver viewResolver() {
		LOG.error("------------------------------- TilesViewResolver ");
		TilesViewResolver viewResolver = new TilesViewResolver();
		return viewResolver;
	}

	// Initializes the Apache Tiles CompositeView system
	@Bean
	TilesConfigurer tilesConfigurer() {
		LOG.error("------------------------------- TilesConfigurer ");
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("WEB-INF/tiles/tiles-definitions.xml");
		tilesConfigurer
				.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
		return tilesConfigurer;
	}

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
		LOG.error("------------------------------- getMessageSource ");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    // @Bean
//    public void multipartResolver(CommonsMultipartResolver multipartresolver) {
//		LOG.error("------------------------------- multipartResolver ");
//    	multipartresolver.setMaxUploadSize(100000);
//    }
    
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
		LOG.error("------------------------------- getMultipartResolver ");
        // return new CommonsMultipartResolver();
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(100000);
        return resolver;
    }
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		LOG.error("------------------------------- addResourceHandlers ");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		LOG.error("------------------------------- configureDefaultServletHandling ");
		configurer.enable();
	}
	
	// @Override
	// public void addViewControllers(ViewControllerRegistry registry) {
	// registry.addViewController("/login").setViewName("login");
	// registry.addViewController("/logout").setViewName("login");
	// }

}
