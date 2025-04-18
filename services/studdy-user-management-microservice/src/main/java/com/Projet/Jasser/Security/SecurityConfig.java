package com.Projet.Jasser.Security;

import com.Projet.Jasser.Security.jwt.JwtAuthenticationHttp403;
import com.Projet.Jasser.Security.jwt.JwtAuthorizationFilter;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final JwtAuthenticationHttp403 jwtAuthenticationHttp403;
    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())  // Allows all CORS requests
                .csrf(AbstractHttpConfigurer::disable)  // Disables CSRF protection
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/authentication/**").permitAll()  // Permit sign-up endpoint
                        .requestMatchers("/api/user/**").permitAll()  // Permit sign-up endpoint
                        .requestMatchers("/api/v1/**").permitAll()  // Permit sign-up endpoint
                        .requestMatchers("/api/search/**").permitAll()  // Permit sign-up endpoint
                        .requestMatchers("/api/reclamations/**").permitAll()  // Permit sign-up endpoint
                        .requestMatchers("/api/history/**").permitAll()


                        .anyRequest().authenticated()  // Require authentication for all other requests
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Stateless session
                .authenticationProvider(daoAuthenticationProvider())  // Custom authentication provider
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)  // JWT filter
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(jwtAuthenticationHttp403)  // Handle authentication errors
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);  // Use custom user details service
        provider.setPasswordEncoder(passwordEncoder());  // Use BCrypt password encoder
        return provider;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")  // Allow requests from any origin
                        .allowedMethods("*");  // Allow all HTTP methods (GET, POST, PUT, etc.)
            }
        };
    }
}
