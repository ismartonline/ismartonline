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
public class UserDetailsServiceDAO implements UserDetailsService
{

   @PersistenceContext
   private EntityManager em;

   @Override
   public UserDetails loadUserByUsername(String username)
         throws UsernameNotFoundException
   {
	   String jpql = "select u from User u where u.login = :login";
	   
	   List<User> users = em.createQuery(jpql, User.class).setParameter("login", username).getResultList();
	   
	   if (users.isEmpty())
	   {
		   throw new UsernameNotFoundException("O usuario " + username + "não existe." );
		   
	   }
	   return users.get(0);
   }
   
   public void salva(User user){
	   
	   em.persist(user);
	   
   }

}