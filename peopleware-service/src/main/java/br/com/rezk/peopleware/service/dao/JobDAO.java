package br.com.rezk.peopleware.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.rezk.peopleware.service.database.DbExecutor;
import br.com.rezk.peopleware.service.mapper.Mapper;
import br.com.rezk.peopleware.service.model.Applicant;
import br.com.rezk.peopleware.service.model.ApplicantTechSkills;
import br.com.rezk.peopleware.service.model.Job;
import br.com.rezk.peopleware.service.model.JobTechSkills;
import br.com.rezk.peopleware.service.response.JobDetailResponse;
import br.com.rezk.peopleware.service.vo.JobVO;
import br.com.rezk.peopleware.service.vo.SkillVO;

public class JobDAO {

	private final static String INSERT_PREFIX = "insert into pw.job (companyName, phone, fardel, desct, salary, academic, fulltime) values('";
	private final static String SULFIX = "');";
	private final static String SEPARATOR = ",";
	private final static String SEPARATOR_STRING = "','";

	@Autowired
	private StringBuilder sb;

	@Qualifier("jobMapper")
	@Autowired
	private Mapper mapper;

	@Autowired
	private DbExecutor db;

	public List<Job> listJobs() throws SQLException {
		ResultSet rs = db.run("select * from pw.job");
		List<Job> jobs = new ArrayList<Job>();
		while (rs.next()) {
			Job job = (Job) mapper.mapOrmToVO(rs);
			jobs.add(job);
		}
		return jobs;
	}

	public boolean add(Job job) {
		sb.setLength(0);
		sb.append(INSERT_PREFIX);
		sb.append(job.getCompanyName());
		sb.append(SEPARATOR_STRING);
		sb.append(job.getPhone());
		sb.append(SEPARATOR_STRING);
		sb.append(job.getFardel());
		sb.append(SEPARATOR_STRING);
		sb.append(job.getDescription());
		sb.append(SEPARATOR_STRING);
		sb.append(job.getSalary());
		sb.append(SEPARATOR_STRING);
		sb.append(job.isAcademic());
		sb.append(SEPARATOR_STRING);
		sb.append(job.isFullTime());
		sb.append(SULFIX);
		System.out.println(sb.toString());
		db.run(sb.toString());
		try {
			ResultSet run = db.run("select max(id) from pw.job");
			run.next();
			for (JobTechSkills techSkill : job.getTechSkills()) {
				sb.setLength(0);
				sb.append("insert into pw.job_tech_skills (job_id, tech_skill_id, tech_skill_level) values (");
				sb.append(run.getInt(1));
				sb.append(SEPARATOR);
				sb.append(techSkill.getTechSkillId());
				sb.append(SEPARATOR);
				sb.append(techSkill.getTechSkillLevel());
				sb.append(");");
				db.run(sb.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public JobDetailResponse jobDetail(int id) {
		JobDetailResponse response = new JobDetailResponse();
		sb.setLength(0);
		sb.append("Select j.*, ts.skill_name from pw.job j " + "Inner join pw.job_tech_skills jts on j.id = jts.job_id "
				+ "Inner join pw.tech_skill ts on jts.tech_skill_id = ts.id " + "where jts.tech_skill_level > 0 "
				+ "and j.id = ");
		sb.append(id);
		ResultSet run = db.run(sb.toString());
		List<String> skills = new ArrayList<String>();
		try {
			while (run.next()) {
				if (response.getId() != run.getInt(1)) {
					response.setId(run.getInt(1));
					response.setCompanyName(run.getString(2));
					response.setPhone(run.getString(3));
					response.setFardel(run.getString(4));
					response.setDescription(run.getString(5));
					response.setSalary(run.getInt(6));
					response.setAcademic(run.getBoolean(7));
					response.setFulltime(run.getBoolean(8));
					skills.add(run.getString(9));
				} else {
					skills.add(run.getString(9));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setSkills(skills);
		return response;
	}

	public List<Job> possibleJobs(int applicantId) {
		List<Job> returnList = new ArrayList<>();
		List<Job> auxList = new ArrayList<Job>();
		Applicant applicant = new Applicant();
		sb.setLength(0);
		sb.append("Select * from pw.applicant where id = ");
		sb.append(applicantId);
		try {
		ResultSet applicantDB = db.run(sb.toString());
		while(applicantDB.next()) {
			applicant.setId(applicantDB.getInt(1));
			applicant.setName(applicantDB.getString(2));
			applicant.setEmail(applicantDB.getString(3));
			applicant.setPhone(applicantDB.getString(4));
			applicant.setSalary(applicantDB.getInt(5));
			applicant.setIdWorkTIme(applicantDB.getInt(6));
			applicant.setAcademicDegree(applicantDB.getString(7));
		}
		
		List<ApplicantTechSkills> applicantTechSkills = new ArrayList<>();
		sb.setLength(0);
		sb.append("select ats.* from pw.applicant_tech_skills ats " + "where ats.applicant_id = ");
		sb.append(applicantId);
		ResultSet appSkills = db.run(sb.toString());
		List<Integer> possibleJobsId = new ArrayList<Integer>();
			while (appSkills.next()) {
				ApplicantTechSkills skill = new ApplicantTechSkills();
				skill.setApplicantId(applicantId);
				skill.setTechSkillId(appSkills.getInt(2));
				skill.setTechSkillLevel(appSkills.getInt(3));
				applicantTechSkills.add(skill);
			}

			List<JobTechSkills> jobTechSkills = new ArrayList<>();
			sb.setLength(0);
			sb.append("select * from pw.job_tech_skills");
			ResultSet run = db.run(sb.toString());
			while (run.next()) {
				JobTechSkills jobTech = new JobTechSkills();
				jobTech.setJobId(run.getInt(1));
				jobTech.setTechSkillId(run.getInt(2));
				jobTech.setTechSkillLevel(run.getInt(3));
				jobTechSkills.add(jobTech);
			}
			List<JobVO> jobs = new ArrayList<>();
			List<Integer> ids = new ArrayList<>();
			for (JobTechSkills skills : jobTechSkills) {
				if (!ids.contains(skills.getJobId())) {
					ids.add(skills.getJobId());
					jobs.add(new JobVO(skills.getJobId()));
				}
			}

			for (JobTechSkills skills : jobTechSkills) {
				for (JobVO vo : jobs) {
					if (vo.getId() == skills.getJobId()) {
						vo.getSkills().add(new SkillVO(skills.getTechSkillId(), skills.getTechSkillLevel()));
					}
				}
			}

			for (JobVO job : jobs) {
				boolean include = true;
				for (SkillVO vo : job.getSkills()) {
					for (ApplicantTechSkills skill : applicantTechSkills) {
						if (vo.getSkillId() == skill.getTechSkillId()) {
							if (vo.getSkillLevel() > skill.getTechSkillLevel()) {
								include = false;
							}
						}
					}
				}
				if (include) {
					possibleJobsId.add(job.getId());
				}
			}

			sb.setLength(0);
			sb.append("select * from pw.job where id in ( ");
			String comma = "";
			for (Integer jobId : possibleJobsId) {
				sb.append(comma);
				comma = ",";
				sb.append(jobId);
			}
			sb.append(")");
			ResultSet rs = db.run(sb.toString());
			while (rs.next()) {
				Job job = (Job) mapper.mapOrmToVO(rs);
				auxList.add(job);
			}
			
				// Administrative 
			for(Job res : auxList) {
				boolean valid = true;
				if(res.getSalary() < applicant.getSalary()) {
					valid = false;
				}
				if(res.isAcademic() && applicant.getAcademicDegree().length() <= 0) {
					valid = false;
				}
				if(valid) {
					returnList.add(res);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnList;
	}

}
