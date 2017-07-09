package com.kasim.spring.security;

import javax.servlet.Filter;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class MultiSecurityConfig extends WebSecurityConfigurerAdapter {
	@Order(2)
	@EnableWebSecurity
	public static class FormAuthentication extends WebSecurityConfigurerAdapter{
		protected void configure(HttpSecurity http) throws Exception {
			http
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin();
		}
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("kasim").password("kasim").authorities("USER");
		}
	}
	@EnableWebSecurity
	@Order(1)
	public static class TokenAuthentication extends WebSecurityConfigurerAdapter{
		protected void configure(HttpSecurity http) throws Exception {
			http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.antMatcher("/services/**")
			.authorizeRequests().anyRequest().authenticated()
			;
			http.addFilterBefore(getFilter(), UsernamePasswordAuthenticationFilter.class);
		}
		private Filter getFilter() {
			return new MyTokenFilter();
		}
	}
}
