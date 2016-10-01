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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotificationController extends BaseController {

	@RequestMapping("/mensagens")
	public ModelAndView listaNotifications(HttpSession session) {
            System.out.println("okokokoko");
            ModelAndView model = new ModelAndView("notification/list");
            
            User user = this.GetUserFromSession(session);
            List<Notification> notifications = ((user != null) ? notificationDAO.findAllByUser(user) : new ArrayList());
            model.addObject("notifications", notifications);
            return model;
	}

    
}
