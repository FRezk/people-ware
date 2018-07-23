package br.com.rezk.peopleware.service.model;

import java.util.List;

import br.com.rezk.peopleware.service.request.SkillRequest;

public class Job {
	
	private Long id;
	private String companyName;
	private String phone;
	private String fardel;
	private String description;
	private int salary;
	private boolean fullTime;
	private boolean academic;
	private List<SkillRequest> techSkills;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFardel() {
		return fardel;
	}
	public void setFardel(String fardel) {
		this.fardel = fardel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public boolean isFullTime() {
		return fullTime;
	}
	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}
	public boolean isAcademic() {
		return academic;
	}
	public void setAcademic(boolean academic) {
		this.academic = academic;
	}
	public List<SkillRequest> getTechSkills() {
		return techSkills;
	}
	public void setTechSkills(List<SkillRequest> techSkills) {
		this.techSkills = techSkills;
	}
	
}
