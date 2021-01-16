package it.unical.asd.group6.computerSparePartsCompany.security;

import it.unical.asd.group6.computerSparePartsCompany.security.jwt.JwtAuthFilter;
import it.unical.asd.group6.computerSparePartsCompany.security.jwt.JwtTokenVerifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider(customerUserService()));
        auth.authenticationProvider(authenticationProvider(employeeUserService()));
    }

    @Bean
    public CustomerUserServiceImpl customerUserService() {
        return new CustomerUserServiceImpl();
    }

    @Bean
    public EmployeeUserServiceImpl employeeUserService() {
        return new EmployeeUserServiceImpl();
    }

    @Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }

    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsService service) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(service);
        daoAuthenticationProvider.setHideUserNotFoundExceptions(true);

        return daoAuthenticationProvider;

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(), JwtAuthFilter.class)
                .authorizeRequests()
                .antMatchers("/employee/authenticate").permitAll()
                .antMatchers("/products/all-products/distinct").hasRole("ADMIN")
                .antMatchers("/products/all-products").hasRole("ADMIN")
                .antMatchers("/review/all").hasRole("USER")
                .antMatchers("/purchaseNotice/all-noticeViews").hasAnyRole("USER","ADMIN")
                //.anyRequest()
                //.authenticated()
                .and()
                .formLogin()
                    .loginPage("http://localhost:4200/login");
    }

/*    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/
//    antMatcher("http://localhost:8080/products/all-products/distinct").formLogin();
}
