package br.com.rezk.peopleware.service;

import java.util.List;

import br.com.rezk.peopleware.service.request.ApplicantRequest;
import br.com.rezk.peopleware.service.response.ApplicantIncludeResponse;
import br.com.rezk.peopleware.service.vo.BestApplicantVO;

public interface ApplicantService {
	public ApplicantIncludeResponse insertApplicant(ApplicantRequest request);
	public List<BestApplicantVO> bestApplicants(int jobId);

}
