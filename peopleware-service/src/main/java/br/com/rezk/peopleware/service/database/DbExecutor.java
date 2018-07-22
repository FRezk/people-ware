package br.com.rezk.peopleware.service.database;

import java.sql.ResultSet;

public interface DbExecutor {
	public ResultSet run(String clausule);

}
