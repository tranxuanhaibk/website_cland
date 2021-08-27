package edu.vinaenter.cland.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enable from users where username=?")
				.authoritiesByUsernameQuery(
						"select username, concat('ROLE_',r.name) role from users u inner join role r on r.roleId = u.roleId where username=?")
				.passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().and().csrf().disable().formLogin().loginPage("/auth/login").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/admin/index").failureUrl("/auth/login?msg=Err").
				loginProcessingUrl("/auth/login").and().logout().logoutUrl("/auth/logout").
				logoutSuccessUrl("/auth/login").invalidateHttpSession(true).deleteCookies("JSESSIONID").
				and().exceptionHandling().accessDeniedPage("/error403");
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/admin/cat/index").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");
		http.authorizeRequests().antMatchers("/admin/user/add").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/admin/contact/add").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/admin/cat/edit/**").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/admin/cat/del/**").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/admin/user/edit").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/admin/user/index").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");
		
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
