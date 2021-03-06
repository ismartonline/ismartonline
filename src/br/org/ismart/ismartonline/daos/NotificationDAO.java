package br.org.ismart.ismartonline.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.org.ismart.ismartonline.models.Notification;
import br.org.ismart.ismartonline.models.NotificationUser;
import br.org.ismart.ismartonline.models.User;
import java.util.ArrayList;
import javax.persistence.Query;

@Repository
public class NotificationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Notification> findAll() {
        return entityManager.createQuery("select n from Notification n order by date desc").getResultList();
    }

    public List<Notification> findAllByUser(User user) {            
        Query q = entityManager.createQuery("select n from Notification n "
                + "inner join n.notificationsUser nu "
                + "where nu.user.login = :login "
                + "order by date desc");
        q.setParameter("login", user.getLogin());
        return q.getResultList();
    }

    public List<Notification> findUnreadByUser(User user) {
        Query q = entityManager.createQuery("select n from Notification n "
                + "inner join n.notificationsUser nu "
                + "where nu.user.login = :login "
                + "and nu.visualized = false "
                + "order by date desc");
        q.setParameter("login", user.getLogin());
        return q.getResultList();
    }

    public void save(Notification notification) {
        entityManager.persist(notification);
    }

    public Notification findById(Long id) {
        return entityManager.find(Notification.class, id);
    }

    public List<User> getUsersToGenerateNotification(Notification notification) {
        if(
            (notification.getYears() == null || notification.getYears().isEmpty()) &&
            (notification.getYears() == null || notification.getYears().isEmpty()) 
        ){
            return new ArrayList<User>();
        }
        else
        {
            Query q = entityManager.createQuery("select u from User u where u.ano in (:ano) and u.unidade in (:unidade)");
            q.setParameter("ano", notification.getYears());
            q.setParameter("unidade", notification.getUnits());

            return q.getResultList();
        }
    }

    public void saveNotificationUser(NotificationUser nu) {
        entityManager.persist(nu);
    }

    public void markAsRead(Long notificationId, String login) {
        Query q = entityManager.createQuery("select nu "
                + "from NotificationUser nu "
                + "where nu.user.login = (:login) "
                + "and nu.notification.id = (:notification_id)");
        q.setParameter("login", login);
        q.setParameter("notification_id", notificationId);
        NotificationUser nu = (NotificationUser) q.getSingleResult();
        
        nu.setVisualized(true);
        
        entityManager.merge(nu);
    }

    public Notification seeNotification(long id, User user) {
        this.markAsRead(id, user.getLogin());
        return this.findById(id);
    }
}
