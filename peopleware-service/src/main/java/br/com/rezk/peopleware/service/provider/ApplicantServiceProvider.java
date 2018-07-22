package br.com.rezk.peopleware.service.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.rezk.peopleware.service.ApplicantService;
import br.com.rezk.peopleware.service.dao.ApplicantDAO;
import br.com.rezk.peopleware.service.mapper.MapRequest;
import br.com.rezk.peopleware.service.model.Applicant;
import br.com.rezk.peopleware.service.request.ApplicantRequest;
import br.com.rezk.peopleware.service.response.ApplicantIncludeResponse;
import br.com.rezk.peopleware.service.vo.BestApplicantVO;

public class ApplicantServiceProvider implements ApplicantService {
	
	@Qualifier("applicantRequest")
	@Autowired
	private MapRequest mapper;
	
	@Autowired
	private ApplicantDAO applicantDAO;

	@Override
	public ApplicantIncludeResponse insertApplicant(ApplicantRequest request) {
		Applicant applicant = (Applicant) mapper.mapToORM(request);
		Integer idApplicant = applicantDAO.add(applicant);
		return new ApplicantIncludeResponse(idApplicant, true);
	}

	@Override
	public List<BestApplicantVO> bestApplicants(int jobId) {
		return applicantDAO.bestApplicants(jobId);
	}

}
