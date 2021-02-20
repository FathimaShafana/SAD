//Configuration File
package com.example.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


//This file will run first when you run and set your configs.
@EnableWebSecurity
@Configuration

//If you use extends, it will work i=even if you dont add any data;
//it has its default values
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	//Singleton
	//Salt it produce different passwords
	//allows other classes to use it as @Autowired
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Authentication
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder());
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()		//Allows h2 to work CSRF: Cross-Site Request Forgery
			.authorizeRequests()
				.antMatchers("/h2-console/**", "/login", "/register").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/**").hasAnyRole("ADMIN","USER")
			.and()
			.formLogin()
				.loginPage("/login").permitAll() //Use login page you created instead of inbuilt login
				.defaultSuccessUrl("/home",true)
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll();		
			
			//To make h2 frame visible
			http.headers().frameOptions().disable();
	}
	
	
}
