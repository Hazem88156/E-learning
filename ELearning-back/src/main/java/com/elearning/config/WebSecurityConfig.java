package com.elearning.config;

import com.elearning.serviceImpl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletResponse;





@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserDetailsService userDetailsService = mysqlUserDetails();
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				//.antMatchers("/api/etudiant/**").permitAll()
				.antMatchers("/api/auth/login").permitAll().antMatchers("/api/auth/register").permitAll().antMatchers("/api/auth/users").permitAll().
				antMatchers("/api/auth/usersss").permitAll().antMatchers("/api/Document/**").permitAll().antMatchers("/api/Cours/**").permitAll().
				antMatchers("/api/Vedio/**").permitAll().antMatchers("/api/auth/admin").permitAll().antMatchers("/api/Tp/**").permitAll()
				.antMatchers("/api/auth/Images/**").permitAll().antMatchers("/api/auth/users/**").permitAll().
				antMatchers("/api/auth/userstatusroles/**").permitAll().antMatchers("/api/classe/**").permitAll()
				.antMatchers("/api/auth/prof").permitAll().antMatchers("/api/auth/etudiant").permitAll().antMatchers("/api/auth/assistant").permitAll()
				.antMatchers("/api/users").hasAuthority("ASSISTANT").anyRequest().authenticated().and().csrf()
				.disable().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint()).and()
				.apply(new JwtConfigurer(jwtTokenProvider));
		http.cors();
		
	}

	//@Override
	//public void configure(WebSecurity web) throws Exception {
		//web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**","/Images/**");
	//}
	@Bean
	public AuthenticationEntryPoint unauthorizedEntryPoint() {
		// TODO Auto-generated method stub
		return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"expired or invalid token");}

	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	

	@Bean
	public UserDetailsService mysqlUserDetails() {
		return new CustomUserDetailsService();
	}

/*	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		List<String> allowedOrigins = Arrays.asList(
				"*"
		);
		config.setAllowedOrigins(allowedOrigins);
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		config.addExposedHeader(
				"Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, "
						+ "Content-Type, Access-Control-Request-Method, Custom-Filter-Header");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}*/
	
	 
}
