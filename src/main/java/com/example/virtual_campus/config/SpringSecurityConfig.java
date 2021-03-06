package com.example.virtual_campus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;


/*
 INSERT INTO `role` VALUES (1,'ADMIN');
 INSERT INTO `role` VALUES (2,'USER');
*/

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;



    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(bCryptPasswordEncoder.encode(""))
                .roles("ADMIN");

        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().frameOptions().disable();

        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/home").permitAll()
                    .antMatchers("/vendor/**", "/dist/**", "/js/**", "/less/**", "/data/**", "/h2/**").permitAll()
                    .antMatchers("/registration/**").permitAll()
                    .antMatchers("/faculties").permitAll()
                    .antMatchers("/subjects").permitAll()
                    .anyRequest().authenticated().and().csrf().disable().formLogin()
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/index", true)
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .exceptionHandling()
                    .accessDeniedHandler(customAccessDeniedHandler);


                /*
                http.logout()
                .logoutUrl("/my/logout")
                .logoutSuccessUrl("/my/index")
                .logoutSuccessHandler(logoutSuccessHandler)
                .invalidateHttpSession(true)
                .addLogoutHandler(logoutHandler)
                .deleteCookies(cookieNamesToClear)
                .and();
                */
    }

/*
    @SuppressWarnings("deprecation")
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("")
                        .roles("USER")
                        .build();

        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
    */
}
