package br.org.ismart.ismartonline.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.org.ismart.ismartonline.models.Notification;

@Repository
public class NotificationDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Notification> findAll() {
            return entityManager.createQuery("select n from Notification n order by date desc").getResultList();
	}

	public void save(Notification notification) {
            entityManager.persist(notification);
	}

	public Notification findById(Long id) {
            return entityManager.find(Notification.class, id);
	}
}
