package br.com.rezk.peopleware.service.enums;

public enum TechSkillsEnum {
	JAVAEE(1, "JavaEE"),
	BOOTSTRAP(2, "Bootstrap"),
	SPRING_MVC(3, "Spring MVC"),
	ECLIPSE(4, "Eclipse");
	
	private int id;
	private String name;
	
	TechSkillsEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

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

}
