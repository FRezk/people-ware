package br.com.rezk.peopleware.service.provider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rezk.peopleware.service.JobService;
import br.com.rezk.peopleware.service.dao.JobDAO;
import br.com.rezk.peopleware.service.model.Job;
import br.com.rezk.peopleware.service.response.JobDetailResponse;

public class JobServiceProvider implements JobService {
	
	@Autowired
	private JobDAO jobDAO;

	@Override
	public boolean publishJob(Job job) {
		return jobDAO.add(job);
	}

	@Override
	public List<Job> listJobs(){
		try {
			return jobDAO.listJobs();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Job>();
		}
	}

	@Override
	public JobDetailResponse jobDetail(int applicantId) {
		return jobDAO.jobDetail(applicantId);
	}

	@Override
	public List<Job> possibleJobs(int id) {
		return jobDAO.possibleJobs(id);
	}

}
