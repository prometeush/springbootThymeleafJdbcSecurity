package com.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.jdbcAuthentication()
		 .dataSource(dataSource)
		 .passwordEncoder(new BCryptPasswordEncoder())
		 .usersByUsernameQuery("Select username,password,enabled from users where username=?")
		 .authoritiesByUsernameQuery("select username,role from users where username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers("/usersForm/**","/angstForm/**","/delete/**","/update/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403");*/
		
		http.authorizeRequests().antMatchers("/usersForm/**","/angstForm/**","/delete/**","/update/**")
		.authenticated().anyRequest().permitAll()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
		
	}

}
