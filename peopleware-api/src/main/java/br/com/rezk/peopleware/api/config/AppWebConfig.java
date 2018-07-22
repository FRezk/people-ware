package br.com.rezk.peopleware.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.rezk.peopleware.api.resource.JobResource;

@EnableWebMvc
@ComponentScan(basePackageClasses={JobResource.class})
public class AppWebConfig {
}
