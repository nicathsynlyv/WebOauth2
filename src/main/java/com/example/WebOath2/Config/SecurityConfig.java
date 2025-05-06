package com.example.WebOath2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("password")
                .roles("USER")
                .passwordEncoder(p -> passwordEncoder().encode(p))
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http
                    .csrf().disable() // CSRF qorumasını deaktiv et (API-lər üçün ümumiyyətlə lazımdır)
                    .authorizeRequests()
                    .antMatchers("/api/**").permitAll() // /api/** altındakı bütün URL-ləri açıq et
                    .anyRequest().authenticated() // Digər bütün yolları autentifikasiya tələb et
                    .and()
                    .formLogin().disable() // Forma ilə giriş etməyi deaktiv et (əgər istifadə etmirsənsə)
                    .httpBasic().disable(); // Basic auth-u deaktiv et (əgər istifadə etmirsənsə)
        }

    }

//            http
//                    .csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers("/oauth/**", "/api/users").permitAll() // bunu əlavə et
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin().disable()
//                    .httpBasic().disable();
//        }
//
//    }
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/oauth/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().disable()
//                .httpBasic().disable();
//    }




