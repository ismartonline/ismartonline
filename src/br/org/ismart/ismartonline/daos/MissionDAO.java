package br.org.ismart.ismartonline.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.org.ismart.ismartonline.models.Mission;
import br.org.ismart.ismartonline.models.StudentMission;
import br.org.ismart.ismartonline.models.User;

@Repository
public class MissionDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Mission> finbByYear(Long year) {
		return entityManager.createQuery("select m from Mission m where m.year = :year").setParameter("year", year)
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<StudentMission> finbByYearAndNumber(Long year, Long number) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select sm ");
		stringBuilder.append("	from StudentMission sm");
		stringBuilder.append("	where sm.mission.number = :number and sm.mission.year = :year");

		return entityManager.createQuery(stringBuilder.toString()).setParameter("number", number)
				.setParameter("year", year).getResultList();
	}
	
	public List<StudentMission> finbByYearNumberAndStudent(Long year, Long number, User user) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select sm ");
		stringBuilder.append("	from StudentMission sm");
		stringBuilder.append("	where sm.mission.number = :number and sm.mission.year = :year and sm.user = :user");
		
		System.out.println("NUMBER: " + number);
		System.out.println("YEAR: " + year);
		System.out.println("USER: " + user.getLogin() + " - " + user.getIsmartId())  ;

		return entityManager.createQuery(stringBuilder.toString(), StudentMission.class)
				.setParameter("number", number)
				.setParameter("year", year)
				.setParameter("user", user)
				.getResultList();
	}

	public StudentMission findStudentMissionById(Long id) {
		return entityManager.find(StudentMission.class, id);
	}

	public void updateStudentMission(StudentMission studentMission) {
		entityManager.merge(studentMission);
		
	}
	
	public void saveStudentMission(StudentMission studentMission){
		entityManager.persist(studentMission);
	}

	public void save(Mission mission) {
		entityManager.persist(mission);
		
	}

	public Mission findById(Long id) {
		return entityManager.find(Mission.class, id);
	}

	public Mission finbMissionByYearAndNumber(Long year, Long number) {
		return entityManager.createQuery("select m from Mission m where m.year = :year and m.number = :number", Mission.class).setParameter("year", year).setParameter("number", number).getSingleResult();
	}

	public List<StudentMission> listStudentMissions(User user) {
		
		return entityManager.createQuery("select sm from StudentMission sm where sm.user = :user", StudentMission.class).setParameter("user", user).getResultList();
	}

}
