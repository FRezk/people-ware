package br.com.rezk.peopleware.api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

import br.com.rezk.peopleware.service.ApplicantService;
import br.com.rezk.peopleware.service.JobService;
import br.com.rezk.peopleware.service.dao.ApplicantDAO;
import br.com.rezk.peopleware.service.dao.JobDAO;
import br.com.rezk.peopleware.service.database.DbExecutor;
import br.com.rezk.peopleware.service.mapper.MapRequest;
import br.com.rezk.peopleware.service.mapper.Mapper;
import br.com.rezk.peopleware.service.model.Applicant;
import br.com.rezk.peopleware.service.model.ApplicantTechSkills;
import br.com.rezk.peopleware.service.model.Job;
import br.com.rezk.peopleware.service.provider.ApplicantServiceProvider;
import br.com.rezk.peopleware.service.provider.JobServiceProvider;
import br.com.rezk.peopleware.service.request.ApplicantRequest;
import br.com.rezk.peopleware.service.request.ApplicantSkillRequest;
import br.com.rezk.peopleware.service.request.Request;

@Configuration
public class BeansConfig {

	@Bean
	public Gson gson() {
		return new Gson();
	}
	
	@Bean
	public StringBuilder sb() {
		return new StringBuilder();
	}
	
	@Bean
	public JobService jobService() {
		return new JobServiceProvider();
	}
	
	@Bean
	public ApplicantService applicantService() {
		return new ApplicantServiceProvider();
	}
	
	@Bean
	public JobDAO jobDAO() {
		return new JobDAO();
	}
	
	@Bean
	public ApplicantDAO applicantDAO() {
		return new ApplicantDAO();
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
	
	@Bean(name="applicantRequest")
	public MapRequest mapRequest() {
		MapRequest mapRequest = (Request request) -> {
			Applicant applicant = new Applicant();
			ApplicantRequest applicantRequest = (ApplicantRequest) request;
			applicant.setName(applicantRequest.getName());
			applicant.setEmail(applicantRequest.getEmail());
			applicant.setAcademicDegree(applicantRequest.getAcademic());
			applicant.setSalary(applicantRequest.getMinimumSalary());
			applicant.setPhone(applicantRequest.getPhone());
			
			if(applicantRequest.getWorkingTime().size() > 1) {
				applicant.setIdWorkTIme(2);
			} else if(applicantRequest.getWorkingTime().get(0).equalsIgnoreCase("full-time")) {
				applicant.setIdWorkTIme(1);
			} else {
				applicant.setIdWorkTIme(0);
			}
			
			List<ApplicantTechSkills> applicantTechSkills = new ArrayList<ApplicantTechSkills>();
			for(ApplicantSkillRequest skillRequest : applicantRequest.getSkills()) {
				ApplicantTechSkills techSkill = new ApplicantTechSkills();
				techSkill.setTechSkillId(skillRequest.getId());
				techSkill.setTechSkillLevel(skillRequest.getValue());
				applicantTechSkills.add(techSkill);
			}
			applicant.setSkills(applicantTechSkills);
			return applicant;
		};
		return mapRequest;
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