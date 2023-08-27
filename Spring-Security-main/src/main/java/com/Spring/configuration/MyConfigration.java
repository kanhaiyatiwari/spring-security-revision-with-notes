package com.Spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyConfigration {

	@Bean
	public SecurityFilterChain Securityconfig(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers(HttpMethod.POST, "/customers").permitAll()
			.requestMatchers("/hello").permitAll()
			.anyRequest().authenticated();
		})
		.csrf(crsf->crsf.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
}
