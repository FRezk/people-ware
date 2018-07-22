package br.com.rezk.peopleware.service.response;

import java.util.List;

public class JobDetailResponse {
	private int id;
	private String companyName;
	private String phone;
	private String fardel;
	private String description;
	private int salary;
	private boolean fulltime;
	private boolean academic;
	private List<String> skills;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public boolean isFulltime() {
		return fulltime;
	}
	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}
	public boolean isAcademic() {
		return academic;
	}
	public void setAcademic(boolean academic) {
		this.academic = academic;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
}
