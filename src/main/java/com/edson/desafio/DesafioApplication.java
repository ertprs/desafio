package com.edson.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.edson.desafio.controller.TokenFilter;

@SpringBootApplication
public class DesafioApplication {
	
	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		FilterRegistrationBean<TokenFilter> frb = new FilterRegistrationBean<>();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/operadores/*");
		return frb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}
	
}
