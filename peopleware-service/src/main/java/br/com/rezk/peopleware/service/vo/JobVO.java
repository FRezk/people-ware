package br.com.rezk.peopleware.service.vo;

import java.util.ArrayList;
import java.util.List;

public class JobVO {
	private Integer id;
	private List<SkillVO> skills;
	
	public JobVO (Integer id) {
		this.id = id;
		this.skills = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List<SkillVO> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillVO> skills) {
		this.skills = skills;
	}
	
}
