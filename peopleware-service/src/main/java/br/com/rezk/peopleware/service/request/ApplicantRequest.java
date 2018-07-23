package br.com.rezk.peopleware.service.request;

import java.util.List;

public class ApplicantRequest implements Request{
	
	private String name;
	private String email;
	private String phone;
	private int minimumSalary;
	private String academic;
	private List<SkillRequest> skills;
	private List<String> workingTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMinimumSalary() {
		return minimumSalary;
	}
	public void setMinimumSalary(int minimumSalary) {
		this.minimumSalary = minimumSalary;
	}
	public String getAcademic() {
		return academic;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public List<SkillRequest> getSkills() {
		return skills;
	}
	public void setSkills(List<SkillRequest> skills) {
		this.skills = skills;
	}
	public List<String> getWorkingTime() {
		return workingTime;
	}
	public void setWorkingTime(List<String> workingTime) {
		this.workingTime = workingTime;
	}
	
}
