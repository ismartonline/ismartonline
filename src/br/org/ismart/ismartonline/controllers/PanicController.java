package br.org.ismart.ismartonline.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.ismart.ismartonline.daos.UserDAO;
import br.org.ismart.ismartonline.daos.VideoDAO;
import br.org.ismart.ismartonline.models.GeekieStudent;
import br.org.ismart.ismartonline.models.Mission;
import br.org.ismart.ismartonline.models.User;
import br.org.ismart.ismartonline.models.Video;
import br.org.ismart.ismartonline.services.GeekieLab;
import br.org.ismart.ismartonline.tools.AwsFileManager;
import br.org.ismart.ismartonline.tools.FileManager;
import br.org.ismart.ismartonline.tools.models.AwsFileMiniModel;

@Controller
@Transactional
@RequestMapping("vQtDNoCxpCa8QIAZPWeIMt4hPuLwZ8a/")
public class PanicController {

	@Autowired
	private UserDAO dao;

	@Autowired
	private FileManager fileManager = new AwsFileManager();

	@Autowired
	private VideoDAO videoDao;

	public static void main(String[] args) {
		new PanicController().insertStudentsMissions();
	}

	@RequestMapping("insert-students-mision")
	public void insertStudentsMissions() {

		List<AwsFileMiniModel> list = fileManager.list("deliveries/ano-1/missao-1/");
		saveItemsFromlist(list);

		list = fileManager.list("deliveries/ano-1/missao-2/");
		saveItemsFromlist(list);

		list = fileManager.list("deliveries/ano-8/missao-1/");
		saveItemsFromlist(list);

		list = fileManager.list("deliveries/ano-8/missao-2/");
		saveItemsFromlist(list);

		list = fileManager.list("deliveries/ano-9/missao-1/");
		saveItemsFromlist(list);

		list = fileManager.list("deliveries/ano-9/missao-2/");
		saveItemsFromlist(list);

	}

	private void saveItemsFromlist(List<AwsFileMiniModel> list) {

		for (AwsFileMiniModel awsFileMiniModel : list) {

			String key = awsFileMiniModel.getKey();
			if (key.length() < 27) {
				saveMission(key);
				continue;
			}

			String ismartId = key.substring(26, key.indexOf("_"));

			if (Integer.valueOf(ismartId) < 1)
				continue;

			System.out.println(ismartId);

			// User student = dao.getUserByIsmartId(ismartId);

			// StudentMission = new StudentMission(student);

		}

	}

	private void saveMission(String key) {
		System.out.println(key);

		String year = key.substring(15, 16);
		String number = key.substring(24, 25);

		System.out.println("Ano : " + year);
		System.out.println("Missao : " + number);

		Mission mission = new Mission(year, number, "Missão " + year,
				"missao" + number + "_" + (year.equals("1") ? year + "em.doc" : year + ".doc"),
				"missao" + number + "_" + (year.equals("1") ? year + "em.pdf" : year + ".pdf"));

		List<String> videos = saveVideos(getMissionVideos(key), mission);

	}

	private List<String> getMissionVideos(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<String> saveVideos(List<String> videos, Mission mission) {
		for (String string : videos) {
		//	Video video = new Video(mission, path, title);
			//videoDao.save(video);
		}

		return null;
	}

	@RequestMapping("create-users")
	public void createStudents() {

		List<User> users = dao.listaMentores();
		GeekieLab geekieLab = new GeekieLab();

		for (User user : users) {
			System.out.println("####################################################################################");
			System.out.println("IsmartId: " + user.getIsmartId());

			GeekieStudent student = geekieLab.createStudent(geekieLab.createTagsString(user), user.getName(),
					geekieLab.getOrganizationId(user), user.getIsmartId(), geekieLab.getSigninKey(user));

			System.out.println(
					"=====================================================================================\n\n");
			user.setGeekieId(student.getId());
			dao.atualiza(user);
		}
	}

	@RequestMapping("update-users")
	public void batch() throws SQLException, InterruptedException {

		List<User> users = dao.lista();
		GeekieLab geekieLab = new GeekieLab();

		for (User user : users) {
			System.out.println("####################################################################################");
			System.out.println("IsmartId: " + user.getIsmartId());

			GeekieStudent student = geekieLab.getStudentByExternalId(geekieLab.getOrganizationId(user),
					user.getIsmartId(), geekieLab.getSigninKey(user));

			System.out.println(
					"=====================================================================================\n\n");
			user.setGeekieId(student.getId());
			dao.atualiza(user);
		}

	}

}
