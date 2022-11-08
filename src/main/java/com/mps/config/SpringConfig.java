package com.mps.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("Select uname,upwd,uenabled from usertab where uname=?")
		.authoritiesByUsernameQuery("select uname,urole from usertab where uname=?")
		.passwordEncoder(pwdEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//used for Authorization (url and their access defined)
				http.authorizeRequests()
				//URL-Access type
				.antMatchers("/home").permitAll()
				.antMatchers("/welcome").authenticated()
				.antMatchers("/admin").hasAuthority("ADMIN")
				.antMatchers("/std").hasAuthority("STUDENT")
				.antMatchers("/emp").hasAuthority("EMPLOYEE")
				//login form
				.and()
				.formLogin()
				.defaultSuccessUrl("/welcome", true)
				//logout
				.and()
				.logout()
				//Exception Handling (403 handling)
				.and()
				.exceptionHandling()
				.accessDeniedPage("/denied")
				;
			}
}