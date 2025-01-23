package com.aniljadhav2833.mysite.mysiteBackend.config;

import com.aniljadhav2833.mysite.mysiteBackend.login.JWTFilter;
import com.aniljadhav2833.mysite.mysiteBackend.login.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class ProjectConfig {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    JWTFilter jwtFilter;



    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        reqest->reqest
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/updatemessage").authenticated()
                                .requestMatchers("/checkMessage/**").authenticated()
                                .requestMatchers("/sendmessage/**").authenticated()
                                .anyRequest().permitAll()
                        )
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }



    @Bean
AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
return daoAuthenticationProvider;
}

@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
return configuration.getAuthenticationManager();
}

@Bean
PasswordEncoder passwordEncoder(){
return new BCryptPasswordEncoder();
    }

}
