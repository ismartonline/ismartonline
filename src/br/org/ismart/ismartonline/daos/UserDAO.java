package br.org.ismart.ismartonline.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.org.ismart.ismartonline.models.User;

@Repository
public class UserDAO  {

	@PersistenceContext
	private EntityManager em;


	public void salva(User user) {

		em.persist(user);

	}
	
	public void atualiza(User user){
		em.merge(user);
	}

	public List<User> lista() {
		
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	public List<User> listaFakes() {
		return em.createQuery("select u from User u where u.login like 'alunoteste%' ", User.class).getResultList();
	}

}