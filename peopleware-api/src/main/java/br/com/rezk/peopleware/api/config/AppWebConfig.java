package br.com.rezk.peopleware.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.rezk.peopleware.api.resource.LoginResource;

@EnableWebMvc
@ComponentScan(basePackageClasses={LoginResource.class})
public class AppWebConfig {
}
