package br.com.rezk.peopleware.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

import br.com.rezk.peopleware.service.LoginService;
import br.com.rezk.peopleware.service.provider.LoginServiceProvider;

@Configuration
public class BeansConfig {
	
	@Bean
	public Gson gson() {
		return new Gson();
	}

	@Bean
	public LoginService loginService() {
		return new LoginServiceProvider();
	}
}