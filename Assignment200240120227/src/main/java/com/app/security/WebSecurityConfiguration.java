package com.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.disable()
			.antMatcher("/**")
			.authorizeRequests()
			.antMatchers("/","/index.jsp")
				.permitAll()
			.anyRequest()
				.authenticated()
			.and()
	         .oauth2Login();
		

	}



}
