package com.example.myFirstWebApp.securityConfig;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	
	//LDP, datatabse
	//Inmemory
	@Bean
	public InMemoryUserDetailsManager createUserDetails() {
		//Function<String, String> passwordEncoder = input->passwordEncoder().encode(input);
		UserDetails details = createUser("Rayudu", "test");
		UserDetails details1 = createUser("Dharma", "dharma00");
		
		return new InMemoryUserDetailsManager(details, details1);
	}

	private UserDetails createUser(String username, String password) {
		UserDetails details =  User.builder().passwordEncoder(input->passwordEncoder().encode(input))
			.username(username)
			.password(password)
			.roles("User", "Admin")
			.build();
		return details;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		httpSecurity.formLogin(withDefaults());
		
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		return httpSecurity.build();
	}
}
