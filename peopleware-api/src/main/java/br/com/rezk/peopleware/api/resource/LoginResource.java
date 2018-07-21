package br.com.rezk.peopleware.api.resource;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.rezk.peopleware.service.LoginService;

@RestController
public class LoginResource {
	
	@Autowired
	private Gson gson;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET, value="/try", produces=MediaType.APPLICATION_JSON_VALUE)
	public String hello() {
		return gson.toJson(loginService.companyInfo());
	}

}
