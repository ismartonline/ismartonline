package br.org.ismart.ismartonline.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

   @Override
   protected void configure(HttpSecurity http) throws Exception
   {
      
     // EXAMPLE OF AUTHENTICATION AND AUTHORIZATION
      
      http.csrf().disable().
      authorizeRequests()
      //TODO: verificar se da pra deixar um matcher só
    .antMatchers("/admin").hasRole("ADMIN")
    .antMatchers("/admin/**").hasRole("ADMIN")
    .antMatchers("/cadastro/**").permitAll()
    .antMatchers("/evaluate").permitAll()
    .antMatchers("/vQtDNoCxpCa8QIAZPWeIMt4hPuLwZ8a/").permitAll()
    .antMatchers("/modulo/cultura/missao/deliver").permitAll()
    .antMatchers("/entrega/submit").permitAll()
    
//      .antMatchers(HttpMethod.POST,"/specificUrl").hasRole("ADMIN")
//      .antMatchers("/url3/**").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin().loginPage("/login"). permitAll()
      .and()
      .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
      
   }

   @Autowired
   private UserDetailsService users;

   @Override
   protected void configure(AuthenticationManagerBuilder auth)
         throws Exception
   {
      auth.userDetailsService(users).passwordEncoder(new BCryptPasswordEncoder());
   }

   @Override
   public void configure(WebSecurity web) throws Exception
   {
      //you can change 
      web.ignoring().antMatchers("/resources/**");
   }
}
