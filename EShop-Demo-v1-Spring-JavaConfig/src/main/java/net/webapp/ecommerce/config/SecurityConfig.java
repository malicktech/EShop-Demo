package net.webapp.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, javax.sql.DataSource datasource ) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(datasource)
			.usersByUsernameQuery(
					"select username as principal, password as credentials, true from users where username = ?"
					)
			.authoritiesByUsernameQuery( 
					"select u.username, r.role_name from users u, role r where u.id_user = r.id_user and u.username =?"
					);
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/images/**", "/vendors/**" ).permitAll()
				.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/index.html")
				.failureUrl("/login")
				.permitAll()
				.and()
			.logout()
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.permitAll();
	}

	
	
}
