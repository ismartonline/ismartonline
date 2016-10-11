/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ismart.ismartonline.controllers;

import br.org.ismart.ismartonline.daos.NotificationDAO;
import br.org.ismart.ismartonline.models.Notification;
import br.org.ismart.ismartonline.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class NotificationController extends BaseController {

	@RequestMapping("/mensagens")
	public ModelAndView listaNotifications(HttpSession session) {
            ModelAndView model = new ModelAndView("notification/list");
            
            User user = this.GetUserFromSession(session);
            List<Notification> notifications = ((user != null) ? notificationDAO.findAllByUser(user) : new ArrayList());
            model.addObject("notifications", notifications);
            return model;
	}
       
        @RequestMapping("/mensagens/ver/{id}")
	public ModelAndView detailNotification(HttpSession session, @PathVariable("id") long id) {
            ModelAndView model = new ModelAndView("notification/detail");
            
            User user = this.GetUserFromSession(session);
            Notification notification = notificationDAO.seeNotification(id, user);
            model.addObject("notification", notification);
            return model;
	}
}
