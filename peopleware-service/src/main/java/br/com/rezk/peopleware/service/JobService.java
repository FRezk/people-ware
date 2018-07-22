package br.com.rezk.peopleware.service;

import java.util.List;

import br.com.rezk.peopleware.service.model.Job;
import br.com.rezk.peopleware.service.response.JobDetailResponse;

public interface JobService {
	public boolean publishJob(Job job);
	public List<Job> listJobs();
	public JobDetailResponse jobDetail(int id);
	public List<Job> possibleJobs(int applicantId);

}
