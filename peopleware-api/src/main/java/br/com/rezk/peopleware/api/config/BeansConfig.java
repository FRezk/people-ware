package br.com.rezk.peopleware.api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

import br.com.rezk.peopleware.service.JobService;
import br.com.rezk.peopleware.service.LoginService;
import br.com.rezk.peopleware.service.dao.JobDAO;
import br.com.rezk.peopleware.service.database.DbExecutor;
import br.com.rezk.peopleware.service.mapper.Mapper;
import br.com.rezk.peopleware.service.model.Job;
import br.com.rezk.peopleware.service.provider.JobServiceProvider;
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
	
	@Bean
	public StringBuilder sb() {
		return new StringBuilder();
	}
	
	@Bean
	public JobDAO jobDAO() {
		return new JobDAO();
	}
	
	@Bean
	public JobService jobService() {
		return new JobServiceProvider();
	}
	
	@Bean(name="jobMapper")
	public Mapper mapper() {
		Mapper mapper = (ResultSet rs) -> {
			try {
					Job job = new Job();
					job.setId((long) rs.getInt(1));
					job.setCompanyName(rs.getString(2));
					job.setPhone(rs.getString(3));
					job.setFardel(rs.getString(4));
					job.setDescription(rs.getString(5));
					job.setSalary(rs.getInt(6));
					job.setAcademic(rs.getBoolean(7));
					job.setFullTime(rs.getBoolean(8));
				return job;
			} catch (SQLException e) {
				e.printStackTrace();
				return new ArrayList<Job>();
			}
		};
		return mapper;
	}

	@Bean
	public DbExecutor dbExecutor() {
		DbExecutor db = (String clausule) -> {
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/peopleware", "postgres",
						"rezk");
				PreparedStatement stmt = con.prepareStatement(clausule);
				ResultSet rs = stmt.executeQuery();
				return rs;
			} catch (Exception e) {
				return null;
			} 
		};
		return db;
	}
}