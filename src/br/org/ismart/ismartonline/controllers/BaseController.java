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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
    
	
	@Autowired
	protected NotificationDAO notificationDAO;
        
        @ModelAttribute("unreadUserNotifications")
        public List<Notification> getUnreadNotifications(HttpSession session) {
            User user = this.GetUserFromSession(session);
            List<Notification> list = ((user != null) ? notificationDAO.findUnreadByUser(user) : new ArrayList());
            return list;
        }
        
        protected User GetUserFromSession(HttpSession session) {
            SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
            return context != null ? (User) context.getAuthentication().getPrincipal() : null;
        }
}
