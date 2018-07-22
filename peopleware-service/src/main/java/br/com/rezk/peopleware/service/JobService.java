package br.com.rezk.peopleware.service;

import java.util.List;

import br.com.rezk.peopleware.service.model.Job;

public interface JobService {
	public boolean publishJob(Job job);
	public List<Job> listJobs();

}
