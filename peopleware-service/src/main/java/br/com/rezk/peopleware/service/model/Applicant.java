package br.com.rezk.peopleware.service.model;

import java.util.List;

public class Applicant {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private int salary;
	private int idWorkTIme;
	private String academicDegree;
	private List<ApplicantTechSkills> skills;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getIdWorkTIme() {
		return idWorkTIme;
	}
	public void setIdWorkTIme(int idWorkTIme) {
		this.idWorkTIme = idWorkTIme;
	}
	public String getAcademicDegree() {
		return academicDegree;
	}
	public void setAcademicDegree(String academicDegree) {
		this.academicDegree = academicDegree;
	}
	public List<ApplicantTechSkills> getSkills() {
		return skills;
	}
	public void setSkills(List<ApplicantTechSkills> skills) {
		this.skills = skills;
	}
	
}
