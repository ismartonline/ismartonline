package br.org.ismart.ismartonline.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.org.ismart.ismartonline.models.Video;

@Repository
public class VideoDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void save(Video video) {
		em.persist(video);
	}

}
