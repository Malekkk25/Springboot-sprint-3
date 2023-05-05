package com.malek.vols.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;
    
 
    
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        return new InMemoryUserDetailsManager(
                User.withUsername("user").password(passwordEncoder.encode("123")).roles("USER").build(),
                User.withUsername("malek").password(passwordEncoder.encode("123")).roles("USER","AGENT").build(),
                User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN").build()
        );
    }



    //l'utilisation de l'annotation bean au demarage spring va appeler la methode securityFilterChain()
    @SuppressWarnings({ "deprecation", "removal" })
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin().loginPage("/login").permitAll();
        httpSecurity.authorizeRequests().requestMatchers("/webjars/**").permitAll();
        httpSecurity.authorizeRequests().requestMatchers("/showCreate").hasAnyRole("ADMIN","AGENT");
        httpSecurity.authorizeRequests().requestMatchers("/saveVol").hasAnyRole("ADMIN","AGENT");
        httpSecurity.authorizeRequests().requestMatchers("/listeVols") .hasAnyRole("ADMIN","AGENT","USER");
        httpSecurity.authorizeRequests().requestMatchers("/supprimerVol","/modifierVol","/updateVol") .hasAnyRole("ADMIN");
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");
        httpSecurity.csrf().disable(); // disable CSRF protection
   
        
        
        return httpSecurity.build();
    }
}