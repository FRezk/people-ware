package br.com.rezk.peopleware.service.enums;

public enum WorkingTimeEnum {
	PART_TIME(0, "part-time"),
	FULL_TIME(1, "full-time");
	
	private int id;
	private String workTime;
	
	WorkingTimeEnum(int id, String workingTime) {
		this.id = id;
		this.workTime = workingTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
}
