package br.com.rezk.peopleware.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rezk.peopleware.service.database.DbExecutor;
import br.com.rezk.peopleware.service.model.Applicant;
import br.com.rezk.peopleware.service.model.ApplicantTechSkills;
import br.com.rezk.peopleware.service.model.Job;
import br.com.rezk.peopleware.service.vo.BestApplicantVO;

public class ApplicantDAO {

	private static final String INSERT_PREFIX = "insert into pw.applicant(name, email, phone, salary, idWorkingTime, academicDegree) values ('";
	private static final String SEPARATOR_STRING = "','";
	private static final String SEPARATOR = ",";
	private static final String SULFIX = "');";

	@Autowired
	private StringBuilder sb;

	@Autowired
	private DbExecutor db;

	public Integer add(Applicant applicant) {
		Integer ret = 0;
		sb.setLength(0);
		sb.append(INSERT_PREFIX);
		sb.append(applicant.getName());
		sb.append(SEPARATOR_STRING);
		sb.append(applicant.getEmail());
		sb.append(SEPARATOR_STRING);
		sb.append(applicant.getPhone());
		sb.append("',");
		sb.append(applicant.getSalary());
		sb.append(",");
		sb.append(applicant.getIdWorkTIme());
		sb.append(",'");
		sb.append(applicant.getAcademicDegree());
		sb.append(SULFIX);
		db.run(sb.toString());
		try {
			ResultSet run = db.run("select max(id) from pw.applicant");
			run.next();
			for (ApplicantTechSkills skill : applicant.getSkills()) {
				sb.setLength(0);
				sb.append(
						"insert into pw.applicant_tech_skills (applicant_id, tech_skill_id, tech_skill_level) values(");
				sb.append(run.getInt(1));
				sb.append(SEPARATOR);
				sb.append(skill.getTechSkillId());
				sb.append(SEPARATOR);
				sb.append(skill.getTechSkillLevel());
				sb.append(");");
				db.run(sb.toString());

				sb.setLength(0);
				sb.append("select max(id) from pw.applicant");
				ResultSet id = db.run(sb.toString());
				id.next();
				ret = id.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public List<BestApplicantVO> bestApplicants(int jobId) {
		List<Applicant> allApplicants = new ArrayList<>();
		List<BestApplicantVO> bestVO = new ArrayList<>();
		Job job = new Job();
		sb.setLength(0);
		sb.append("select * from pw.applicant");
		ResultSet applicantRs = db.run(sb.toString());
		try {
			while (applicantRs.next()) {
				Applicant applicant = new Applicant();
				applicant.setId(applicantRs.getInt(1));
				applicant.setName(applicantRs.getString(2));
				applicant.setEmail(applicantRs.getString(3));
				applicant.setPhone(applicantRs.getString(4));
				applicant.setSalary(applicantRs.getInt(5));
				applicant.setIdWorkTIme(applicantRs.getInt(6));
				applicant.setAcademicDegree(applicantRs.getString(7));
				allApplicants.add(applicant);
			}

			sb.setLength(0);
			sb.append("select * from pw.job where id = ");
			sb.append(jobId);
			ResultSet jobRs = db.run(sb.toString());
			while (jobRs.next()) {
				job.setId((long) jobRs.getInt(1));
				job.setCompanyName(jobRs.getString(2));
				job.setPhone(jobRs.getString(3));
				job.setFardel(jobRs.getString(4));
				job.setDescription(jobRs.getString(5));
				job.setSalary(jobRs.getInt(6));
				job.setAcademic(jobRs.getBoolean(7));
				job.setFullTime(jobRs.getBoolean(8));
			}

			List<Applicant> auxList = new ArrayList<Applicant>();
			// Administrative
			for (Applicant applicant : allApplicants) {
				if (job.isAcademic() && applicant.getAcademicDegree().length() > 0 || !job.isAcademic()) {
					if (job.getSalary() >= applicant.getSalary()) {
						auxList.add(applicant);
					}
				}
			}
			allApplicants = auxList;
			auxList = new ArrayList<>();

			sb.setLength(0);
			sb.append("select * from pw.job_tech_skills where job_id = ");
			sb.append(jobId);
			ResultSet skillRs = db.run(sb.toString());
			List<Integer> idMandatorySkills = new ArrayList<Integer>();
			while (skillRs.next()) {
				if (skillRs.getInt(3) > 0) {
					idMandatorySkills.add(skillRs.getInt(2));
				}
			}
			
			for(Applicant applicant : allApplicants) {
				int score = 0;
				sb.setLength(0);
				sb.append("select * from pw.applicant_tech_skills where applicant_id = ");
				sb.append(applicant.getId());
				ResultSet run = db.run(sb.toString());
				while(run.next()) {
					if(idMandatorySkills.contains(run.getInt(2))) {
						score += run.getInt(3);
					}
				}
				if(score > 0) {
					BestApplicantVO vo = new BestApplicantVO();
					vo.setName(applicant.getName());
					vo.setGraduation(applicant.getAcademicDegree());
					vo.setEmail(applicant.getEmail());
					vo.setPhone(applicant.getPhone());
					vo.setSalary(applicant.getSalary());
					vo.setScore(score);
					bestVO.add(vo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bestVO;
	}

}
