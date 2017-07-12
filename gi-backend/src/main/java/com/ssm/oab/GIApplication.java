package com.ssm.oab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GIApplication {
	
//	@Configuration
//	static class SecurityConfig extends GlobalAuthenticationConfigurerAdapter{
//		@Override
//		public void init(AuthenticationManagerBuilder auth) throws Exception {
//			auth.inMemoryAuthentication()
//			.withUser("admin").password("root").roles("USER");
//			
//		}
//	}

	public static void main(String[] args) {
		SpringApplication.run(GIApplication.class, args);
	}
}
