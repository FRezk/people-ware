package br.com.rezk.peopleware.service.mapper;

import br.com.rezk.peopleware.service.request.Request;

public interface MapRequest {
	public Object mapToORM(Request request);

}
