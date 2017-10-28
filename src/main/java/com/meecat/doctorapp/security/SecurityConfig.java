package com.meecat.doctorapp.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private  PasswordEncoder passwordEncoder;

	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("p1")
				.roles("USER").and().withUser("admin1").password("p1")
				.roles("USER", "ADMIN");
		
		auth.
		jdbcAuthentication()
			.usersByUsernameQuery(usersQuery)
			.authoritiesByUsernameQuery(rolesQuery)
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder);
	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/**", "/home","/resources/**", "/static/**", "/api/**").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll()
            .and()
        .csrf().disable()
 	    .headers().frameOptions().disable();
		
//		http.authorizeRequests().antMatchers("/students/**")
//				.hasRole("USER").antMatchers("/users/**").hasRole("USER")
//				.antMatchers("/**").hasRole("ADMIN").and().csrf().disable()
//				.headers().frameOptions().disable();
	}

}
