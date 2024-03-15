package jp.ac.group.manage.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)
			throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests(authorize -> {
			authorize
					.requestMatchers("/").permitAll()
					.requestMatchers("/js/**").permitAll()
					.requestMatchers("/css/**").permitAll()
					.requestMatchers("/img/**").permitAll()
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated();
		});
		http.formLogin(form -> {
			form.defaultSuccessUrl("/secret");
		});
		return http.build();
	}

	@Autowired
	private DataSource dataSource;

	@Bean
	public UserDetailsManager userDetailsManager() {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(this.dataSource);
		//ユーザー登録
		users.createUser(makeUser("admin", "kanri", "ADMIN"));
		users.createUser(makeUser("kiku", "akiyosi", "USER"));
		return users;
	}

	private UserDetails makeUser(String user, String pass, String role) {
		return User.withUsername(user)
				.password(
						PasswordEncoderFactories
								.createDelegatingPasswordEncoder()
								.encode(pass))
				.roles(role)
				.build();
	}
}