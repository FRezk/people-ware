package br.com.rezk.peopleware.service.mapper;

import java.sql.ResultSet;

public interface Mapper {
	public Object mapOrmToVO(ResultSet rs);

}
