package com.revature.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class UserAuthConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService uds;

//	@Bean
//	public DaoAuthenticationProvider dap() {
//		return new DaoAuthenticationProvider();
//	}

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(uds);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		return provider;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable()
//		.authorizeRequests().antMatchers( "/**").permitAll().anyRequest().authenticated().and()
//				.formLogin().loginPage("/login").permitAll().and()
//				.logout().invalidateHttpSession(true)
//				.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/logout-success").permitAll();
		
				http
				.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated();
	}

}
