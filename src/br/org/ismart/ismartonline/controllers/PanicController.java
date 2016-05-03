package br.org.ismart.ismartonline.controllers;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.ismart.ismartonline.daos.MissionDAO;
import br.org.ismart.ismartonline.daos.UserDAO;
import br.org.ismart.ismartonline.daos.VideoDAO;
import br.org.ismart.ismartonline.models.GeekieStudent;
import br.org.ismart.ismartonline.models.Mission;
import br.org.ismart.ismartonline.models.StudentMission;
import br.org.ismart.ismartonline.models.User;
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

	@Autowired
	private MissionDAO missionDao;

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
//		

		 list = fileManager.list("deliveries/ano-1/missao-3/");
		saveItemsFromlist(list);
		

		list = fileManager.list("deliveries/ano-9/missao-3/");
		saveItemsFromlist(list);
		

		list = fileManager.list("deliveries/ano-8/missao-3/");
		saveItemsFromlist(list);

	}

	private void saveItemsFromlist(List<AwsFileMiniModel> list)  {

		for (AwsFileMiniModel awsFileMiniModel : list) {

			
			String key = awsFileMiniModel.getKey();
			String year = key.substring(15, 16);
			String number = key.substring(24, 25);
			String fileName = key.substring(26);
			
					
			if (key.length() < 27) {
				//saveMission(key, year, number);
				continue;
			}

			String ismartId = key.substring(26, key.indexOf("_"));

			if (Integer.valueOf(ismartId) < 1)
				continue;

			System.out.println(ismartId);

			User student = dao.getUserByIsmartId(ismartId);
			System.err.println(year + "-" + number);
			Mission mission = missionDao.finbMissionByYearAndNumber(Long.valueOf(year), Long.valueOf(number));

			//(Calendar deliveryDate, String fileLink, Mission mission, User user) {
			
			//https://s3-sa-east-1.amazonaws.com/elasticbeanstalk-sa-east-1-174765381476/deliveries/ano-1/missao-1/16_Miss%C3%A3o_1_1EM_Franciele+Maria+de+Fatima+Amancio.docx
			try {
				String urlEncoded = java.net.URLEncoder.encode(key, "UTF-8");
				String link = "https://s3-sa-east-1.amazonaws.com/elasticbeanstalk-sa-east-1-174765381476/"+urlEncoded;
				System.out.println(link);
				
				if (! missionDao.finbByYearNumberAndStudent(Long.valueOf(year), Long.valueOf(number), student).isEmpty())
						continue;
				
				StudentMission sm = new StudentMission(awsFileMiniModel.getLastModifiedAsCalendar(), link, mission, student, fileName);
				
				missionDao.updateStudentMission(sm);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private Mission saveMission(String key, String year, String number) {
		System.out.println(key);

		System.out.println("Ano : " + year);
		System.out.println("Missao : " + number);

		//String name, String docFilePath, String pdfFilePath, Long number, Long year) {
		Mission mission = new Mission("Missão " + number,  
				"missao" + number + "_" + (year.equals("1") ? year + "em.doc" : year + ".doc"),
				"missao" + number + "_" + (year.equals("1") ? year + "em.pdf" : year + ".pdf"),
				Long.valueOf(number), Long.valueOf(year));
		
		missionDao.save(mission);
		
		return missionDao.findById(mission.getId());

		//SList<String> videos = saveVideos(getMissionVideos(key), mission);

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
