package br.org.ismart.ismartonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.org.ismart.ismartonline.daos.MissionDAO;
import br.org.ismart.ismartonline.daos.NotificationDAO;
import br.org.ismart.ismartonline.models.Mission;
import br.org.ismart.ismartonline.models.Notification;
import br.org.ismart.ismartonline.models.NotificationUser;
import br.org.ismart.ismartonline.models.StudentMission;
import br.org.ismart.ismartonline.models.User;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/admin")
@Transactional
public class AdminController extends BaseController {

	@Autowired
	private MissionDAO missionDao;

	@Autowired
	private NotificationDAO notificationDao;

	@RequestMapping
	public String home() {

		return "admin/home";

	}

	@RequestMapping("/avaliacao/ano-{year}")
	public ModelAndView avaliacaoAnoId(@PathVariable("year") Long year) {

		ModelAndView model = new ModelAndView("admin/evaluate");

		List<Mission> missions = missionDao.finbByYear(year);

		model.addObject("missions", missions);
		model.addObject("year", year);

		return model;

	}

	@RequestMapping("/avaliacao/ano-{year}/missao-{missionNumber}")
	public ModelAndView avaliacaoAnoMissao(@PathVariable("year") Long year,
			@PathVariable("missionNumber") Long missionNumber) {
		ModelAndView model = new ModelAndView("admin/evaluate-mission");

		List<StudentMission> missions = missionDao.finbByYearAndNumber(year, missionNumber);

		for (StudentMission sm : missions) {
			System.out.println(sm.getUser().getIsmartId() + "-" + sm.getUser().getName());
		}

		model.addObject("missions", missions);
		model.addObject("year", year);
		model.addObject("number", missionNumber);

		return model;

	}
        
        @RequestMapping("/notificacao")
        public ModelAndView notificacao(){
            ModelAndView model = new ModelAndView("admin/notification-list");
           
            List<Notification> notifications = notificationDao.findAll();
            model.addObject("notifications", notifications);
            return model;
        }
        
        @RequestMapping("/notificacao/cadastro")
        public ModelAndView notificacaoCadastro(){
            ModelAndView model = new ModelAndView("admin/notification-form");
           
            Notification notificationForm = new Notification();    
            model.addObject("notificationForm", notificationForm);
            model.addObject("unitsList", getUnitsList());
            return model;
        }
        
        private List<String> getUnitsList() {            
            List<String> unitsList = new ArrayList<String>();
            unitsList.add("Cotia");
            unitsList.add("RJ");
            unitsList.add("SJC");
            unitsList.add("Sorocaba");
            unitsList.add("SP");
            return unitsList;
        }
        
        @RequestMapping("/notificacao/cadastro/submit")
        public String notificacaoCadastroSubmit(@ModelAttribute("notificationForm") Notification notification){
            
            notification.setDate(new Date());
//            NotificationThread thread = new NotificationThread(notification, notificationDao);
//            thread.start();
            notificationDao.save(notification);
            List<User> users = notificationDao.getUsersToGenerateNotification(notification);
            for(User u : users) {
                System.out.println("Usuário: " + u.getLogin());
                NotificationUser nu = new NotificationUser();
                nu.setUser(u);
                nu.setNotification(notification);
                nu.setVisualized(false);

                notificationDao.saveNotificationUser(nu);
            }
            
           
            return "redirect:/admin/notificacao";
        }
        
}

class NotificationThread extends Thread {
    
    private Notification notification;
    private NotificationDAO dao;
    
    public NotificationThread(Notification notification, NotificationDAO dao) {
        this.notification = notification;
        this.dao = dao;
    }
    
    public void run(){
        System.out.println("Rodando: " + new Date().toString());
        dao.save(notification);
        List<User> users = this.dao.getUsersToGenerateNotification(notification);
        for(User u : users) {
            System.out.println("Usuário: " + u.getLogin());
            NotificationUser nu = new NotificationUser();
            nu.setUser(u);
            nu.setNotification(notification);
            nu.setVisualized(false);
            
            dao.saveNotificationUser(nu);
        }
        System.out.println("Finalizando: " + new Date().toString());
    }
}