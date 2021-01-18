package com.kosify.car_shop_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kosify.car_shop_api.config.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecrityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JwtFilter jwtFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/api/v1/**")
		.httpBasic().realmName("API")
        .and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		.antMatchers("/api/v1/employee/**").hasRole("ADMIN")
		.antMatchers("/api/v1/user/**", "/api/v1/inspection").hasAnyRole("USER","ADMIN")
		.antMatchers("/api/v1/auth/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class );
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
