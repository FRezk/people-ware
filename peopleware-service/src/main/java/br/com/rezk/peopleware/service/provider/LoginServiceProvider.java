package br.com.rezk.peopleware.service.provider;

import br.com.rezk.peopleware.service.LoginService;
import br.com.rezk.peopleware.service.model.Company;

public class LoginServiceProvider implements LoginService {

	@Override
	public Company companyInfo() {
		Company comp = new Company();
		comp.setId(1l);
		comp.setName("Noesis");
		return comp;
	}

}
