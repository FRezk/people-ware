package br.com.rezk.peopleware.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.rezk.peopleware.service.database.DbExecutor;
import br.com.rezk.peopleware.service.mapper.Mapper;
import br.com.rezk.peopleware.service.model.Job;

public class JobDAO {

	private final static String INSERT_PREFIX = "insert into pw.job (companyName, phone, fardel, desct, salary, academic, fulltime) values('";
	private final static String SULFIX = "');";
	private final static String SEPARATOR = "','";

	@Autowired
	private StringBuilder sb;

	@Qualifier("jobMapper")
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private DbExecutor db;

	public List<Job> listJobs() throws SQLException {
		ResultSet rs = db.run("select * from pw.job");
			List<Job> jobs = new ArrayList<Job>();
			while (rs.next()) {
				Job job = (Job) mapper.mapOrmToVO(rs);
				jobs.add(job);
			}
			return jobs;
		}

	public boolean add(Job job) {
		sb.setLength(0);
		sb.append(INSERT_PREFIX);
		sb.append(job.getCompanyName());
		sb.append(SEPARATOR);
		sb.append(job.getPhone());
		sb.append(SEPARATOR);
		sb.append(job.getFardel());
		sb.append(SEPARATOR);
		sb.append(job.getDescription());
		sb.append(SEPARATOR);
		sb.append(job.getSalary());
		sb.append(SEPARATOR);
		sb.append(job.isAcademic());
		sb.append(SEPARATOR);
		sb.append(job.isFullTime());
		sb.append(SULFIX);
		System.out.println(sb.toString());
		db.run(sb.toString());
		return true;
	}

}
