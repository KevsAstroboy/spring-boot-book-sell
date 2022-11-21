package com.proj.springbootbooksell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
//@PropertySource("classpath:application-${spring-profiles.active:default}.properties")
public class SpringBootBookSellApplication  extends SpringBootServletInitializer {



	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookSellApplication.class, args);
	}

}
