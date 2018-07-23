package br.com.rezk.peopleware.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.rezk.peopleware.service.JobService;
import br.com.rezk.peopleware.service.model.Job;

@RestController
public class JobResource {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private	Gson gson;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, value="/publishJob")
	public HttpStatus publishJob(@RequestBody Job job) {
		jobService.publishJob(job);
		return HttpStatus.ACCEPTED;
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, value="/listJobs")
	public String listJobs() {
		return gson.toJson(jobService.listJobs());
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, value="/jobDetail/{id}")
	public String jobDetails(@PathVariable int id) {
		return gson.toJson(jobService.jobDetail(id));
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, value="/possibleJobs/{applicantId}")
	public String possibleJobs(@PathVariable("applicantId") int applicantId) {
		return gson.toJson(jobService.possibleJobs(applicantId));
	}

}
