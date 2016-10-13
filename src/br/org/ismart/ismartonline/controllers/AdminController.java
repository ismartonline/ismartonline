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
import br.org.ismart.ismartonline.services.SESMail;
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
            List<User> users = notificationDao.getUsersToGenerateNotification(notification);
            for(User u : users) {
                // System.out.println("Usuário: " + u.getLogin());
                NotificationUser nu = new NotificationUser();
                nu.setUser(u);
                nu.setNotification(notification);
                nu.setVisualized(false);
                notification.addNotificationUser(nu);
            }
            notificationDao.save(notification);
            
            NotificationMail nm = new NotificationMail(notification);
            Thread t = new Thread(nm);
            t.start();
            
            
           
            return "redirect:/admin/notificacao";
        }
        
        @RequestMapping("/notificacao/ver/{id}")
	public ModelAndView detailNotification(@PathVariable("id") long id) {
            ModelAndView model = new ModelAndView("admin/notification-detail");
            
            Notification notification = notificationDAO.findById(id);
            model.addObject("notification", notification);
            return model;
	}        
        
}

class NotificationMail implements Runnable {
    
    private Notification notification;

    public NotificationMail(Notification notification) {
        this.notification = notification;
    }
    
    @Override
    public void run() {
        System.out.println("Iniciando o envio de emails para " + notification.getNotificationsUser().size() + " alunos.");
        for (NotificationUser nu : notification.getNotificationsUser()) {
            try{
                System.out.println("Enviar email para " + nu.getUser().getLogin());
//                SESMail ses = new SESMail(notification.getTitle(), notification.getContent(), nu.getUser().getLogin());
                
                String mail = "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"bodyTable\" style=\"font-family: sans-serif;\"><tr>"+
"<tr>"+
"<td align=\"center\" valign=\"top\">"+
"<table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"                <tr style=\"align: center;\">\n" +
"                    <td style=\"text-align: center;\">\n" +
"                       <a href=\"http://www.ismartonline.com.br\">\n" +
"                           <img src=\"http://www.ismartonline.com.br/resources/img/ismart-online-logo-2.jpg\"><br><br><br>\n" +
"                       </a>\n" +
"                    </td>"+                        
"                </tr>\n" +
"                <tr style=\"text-align: center;\">\n" +
"                    <td>"+                        
"                       <h1>"+notification.getTitle()+"</h1><br><br>\n" +
"                    </td>"+                        
"                </tr>\n" +
"                <tr>\n" +
"                    <td style=\"text-align: left;\">\n" +                       
"                           "+notification.getContent()+""+
"                    <br><br><hr><br></td>"+                         
"                </tr>\n" +
"                <tr>\n" +
"                    <td style=\"text-align: center; background-color: #FFA000; color: #fff; \">\n" +                       
"                           <br>Qualquer dúvida, entre em contato. <br>" +
"<br>" +
"Saudações,<br>" +
"Equipe Ismart Online<br>"+
"                    </td>"+                         
"                </tr>\n" +                        
"        </table>"+
"</td>\n" +
"            </tr>\n" +
"        </table>";         
                

                SESMail ses = new SESMail(notification.getTitle(), mail, nu.getUser().getLogin());
                
                
                ses.send();
            } catch(Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
        System.out.println("Envio de emails finalizado.");
        
    }
    
    
}