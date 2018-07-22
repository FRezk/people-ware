package br.com.rezk.peopleware.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.rezk.peopleware.service.ApplicantService;
import br.com.rezk.peopleware.service.request.ApplicantRequest;

@RestController
public class ApplicantResource {

	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private Gson gson;

	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, value="/insertApplicant")
	public String insertApplicant(@RequestBody ApplicantRequest request) {
		return gson.toJson(applicantService.insertApplicant(request));
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, value="/bestApplicants/{jobId}")
	public String bestApplicants(@PathVariable int jobId) {
		return gson.toJson(applicantService.bestApplicants(jobId));
	}

}
