package com.htc.springboot.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
   private String usersQuery;

    @Value("${spring.queries.roles-query}")
   private String rolesQuery;

	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("PasswordEncoder");
		return passwordEncoder;
	}
	
	/*		@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configure");
    	auth.inMemoryAuthentication()
    	.passwordEncoder(passwordEncoder)
    	.withUser("deva").password(passwordEncoder.encode("deva")).roles("EMPLOYEE")
    	.and()
    	.withUser("admin").password(passwordEncoder.encode("admin")).roles("EMPLOYEE", "ADMIN","MANAGER")
    	.and()
    	.withUser("newuser").password(passwordEncoder.encode("newuser")).roles("EMPLOYEE","MANAGER");
	}*/

		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder)
			.usersByUsernameQuery(usersQuery)			
			.authoritiesByUsernameQuery(rolesQuery);	 	 
	}

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Inside Configuration");
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/employeeForm").hasRole("EMPLOYEE")
			.antMatchers("/addEmployee").hasRole("EMPLOYEE")
			.antMatchers("/empSuccess").hasRole("EMPLOYEE")
			.antMatchers("/searchEmpForm").hasRole("MANAGER")
			.antMatchers("/getEmployee").hasRole("MANAGER")
			.antMatchers("/listEmps").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
            .and().csrf().disable()
            .formLogin()
            	.loginPage("/login")
            	.failureUrl("/login?error=true")
            	.usernameParameter("username")
            	.passwordParameter("password")
            	.defaultSuccessUrl("/")
            	.and()
            	.logout()
            		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            		.logoutSuccessUrl("/login?logout=true")
            		.and()
            		.exceptionHandling()
            			.accessDeniedPage("/accessDenied");
	}
	
}
