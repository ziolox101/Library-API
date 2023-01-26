package com.uz.library_api.config;

import com.uz.library_api.service.User.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecruityConfig{

    private final PasswordEncoder passwordEncoder;
    private final UserLoginService userService;
    private final CustomFilter customFilter = new CustomFilter();
    private final LogoutHandler logoutHandler;

    private String[] publicPath = new String[]{"/api/author/**","/api/library/all",
            "/api/library/**", "/api/book/**", "/api/genre/**", "/api/user/**", "/api/publisher/**", "/api/register"};
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder.getPasswordEncoder());
        provider.setHideUserNotFoundExceptions(true);
        return  provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        customFilter.setAuthenticationManager(authenticationConfiguration.getAuthenticationManager());
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers(publicPath).permitAll()
                .antMatchers("/api/admin/**").hasAuthority("ADMIN")
                .antMatchers("/login").permitAll()// just for test
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .accessDeniedHandler(accessDeniedHandler())     //if i would add form login i need to create failure handler and succes handler
                .and()
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .addLogoutHandler(logoutHandler)
                        .invalidateHttpSession(true)
                )
                .httpBasic();
        http.csrf().disable();
        http.addFilterAt(customFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccesDeniedHandler();
    }
}



