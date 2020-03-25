package com.akatsukidevs.perfumariapi4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementarUsuario userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				// todas as paginas que tem"/" vão ser autenticados por todos
				// As restantes com hasRole eu identifico quem usar
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, "/admin").hasAnyRole("admin", "estoque")
				.antMatchers(HttpMethod.POST, "/admin").hasRole("admin")
				.antMatchers(HttpMethod.GET, "/cadatrarUsuario").hasAnyRole("admin")
				.antMatchers(HttpMethod.POST, "/cadatrarUsuario").hasAnyRole("admin")
				.antMatchers(HttpMethod.GET, "/cadastrarProduto").hasAnyRole("admin")
				.antMatchers(HttpMethod.POST, "/cadastrarProduto").hasAnyRole("admin")
				// autenticação de telas por pessas
				.anyRequest().authenticated().and().formLogin()./*loginPage("/login").*/permitAll()
				// se a pessoa quer sair só apertar "/logout"
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	// autenticação com base em senha codificada
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder()); //codificar a senha
		
	}

	// para não bloaquear paginas estaticas, passa as pastas para o spring security ignorar
	@Override
	public void configure(WebSecurity WEB) throws Exception {
		WEB.ignoring().antMatchers("/css/**", "/image/**","/imgCarousel/**");
	}

}
