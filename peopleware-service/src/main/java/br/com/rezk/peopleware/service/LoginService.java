package br.com.rezk.peopleware.service;

import org.springframework.stereotype.Service;

import br.com.rezk.peopleware.service.model.Company;

@Service
public interface LoginService {
	public Company companyInfo();
}
