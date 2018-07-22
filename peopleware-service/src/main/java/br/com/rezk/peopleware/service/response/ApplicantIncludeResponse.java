package br.com.rezk.peopleware.service.response;

public class ApplicantIncludeResponse {
	
	private int idApplicant;
	private boolean status;
	
	public ApplicantIncludeResponse(int idApplicant, boolean status) {
		this.idApplicant = idApplicant;
		this.status = status;
	}
	
	public int getidApplicant() {
		return idApplicant;
	}
	public void setidApplicant(int idApplicant) {
		this.idApplicant = idApplicant;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
