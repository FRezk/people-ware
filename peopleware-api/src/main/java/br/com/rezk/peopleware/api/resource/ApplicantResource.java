package br.com.rezk.peopleware.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rezk.peopleware.service.ApplicantService;
import br.com.rezk.peopleware.service.request.ApplicantRequest;

@RestController
public class ApplicantResource extends Resource {

	@Autowired
	private ApplicantService applicantService;

	/*
	 **  Insert a new Applicant
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, value="/insertApplicant")
	public String insertApplicant(@RequestBody ApplicantRequest request) {
		return gson.toJson(applicantService.insertApplicant(request));
	}
	
	/*
	 **  Brings the best applicants for the job
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, value="/bestApplicants/{jobId}")
	public String bestApplicants(@PathVariable int jobId) {
		return gson.toJson(applicantService.bestApplicants(jobId));
	}

}
