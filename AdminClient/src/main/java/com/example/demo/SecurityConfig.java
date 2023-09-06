package com.example.demo;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("JASHWIN").password("{noop}12345").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("AJAY").password("{noop}AJAY").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("SYED").password("{noop}SYED").authorities("STUDENT");

	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		//access details
		http.authorizeRequests()
		.antMatchers("/welcome").permitAll()
		//.antMatchers("/{id}").permitAll()
		.antMatchers("/home").authenticated()
		
		.antMatchers("/customer/all").hasAuthority("ADMIN")
		.antMatchers("/product/all").hasAuthority("ADMIN")
		
		.anyRequest().authenticated()
		
		//login
		.and()
		.formLogin()
		.defaultSuccessUrl("/home", true)
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		
		;
	}
}
