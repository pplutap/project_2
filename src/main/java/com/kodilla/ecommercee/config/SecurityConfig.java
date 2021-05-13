package com.kodilla.ecommercee.config;

import com.kodilla.ecommercee.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String STATUS = "ADMIN";
    
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/v1/user/createUser").permitAll()
                .antMatchers("/v1/product/createProduct").hasAnyAuthority(STATUS)
                .antMatchers("/v1/product/deleteProduct").hasAnyAuthority(STATUS)
                .antMatchers("/v1/product/updateProduct").hasAnyAuthority(STATUS)
                .antMatchers("/v1/order/createOrder").hasAnyAuthority(STATUS)
                .antMatchers("/v1/order/updateOrder").hasAnyAuthority(STATUS)
                .antMatchers("/v1/order/deleteOrder").hasAnyAuthority(STATUS)
                .antMatchers("/v1/groups/createGroup").hasAnyAuthority(STATUS)
                .antMatchers("/v1/groups/updateGroup").hasAnyAuthority(STATUS)
                .antMatchers("/v1/cart/createCart").hasAnyAuthority(STATUS)
                .antMatchers("/v1/cart/addItemToCart").hasAnyAuthority(STATUS)
                .antMatchers("/v1/cart/deleteItemFromCart").hasAnyAuthority(STATUS)
                .and().authorizeRequests().antMatchers("/user/**").authenticated().and().httpBasic();
    }






}
