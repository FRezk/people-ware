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

import br.com.rezk.peopleware.service.JobService;
import br.com.rezk.peopleware.service.model.Job;

@RestController
public class JobResource extends Resource {
	
	@Autowired
	private JobService jobService;
	
	/*
	 **  Publish a new Job
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, value="/publishJob")
	public HttpStatus publishJob(@RequestBody Job job) {
		jobService.publishJob(job);
		return HttpStatus.ACCEPTED;
	}
	
	/*
	 **  List all the jobs published
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, value="/listJobs")
	public String listJobs() {
		return gson.toJson(jobService.listJobs());
	}
	
	/*
	 **  Brings the details of a specific Job, including its skills
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, value="/jobDetail/{id}")
	public String jobDetails(@PathVariable int id) {
		return gson.toJson(jobService.jobDetail(id));
	}
	
	/*
	 **  Brings only the applicable job for a specific applicant
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, value="/possibleJobs/{applicantId}")
	public String possibleJobs(@PathVariable("applicantId") int applicantId) {
		return gson.toJson(jobService.possibleJobs(applicantId));
	}

}
