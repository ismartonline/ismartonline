
package br.org.ismart.ismartonline.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="User_iol")
public class User implements UserDetails {

	@Id
	private String login;
	private String password;
	private String name;
	
	private String ano;
	private String turma;
	private String turno;
	private String unidade;
	private String ismartId;
	private String geekieId;
	
	
	@OneToMany(mappedBy="user")
	private List<StudentMission> missions;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}
	

	public String getName() {
		return name;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public String getLogin() {
		return login;
	}


	public String getAno() {
		return ano;
	}


	public String getTurma() {
		return turma;
	}


	public String getTurno() {
		return turno;
	}


	public String getUnidade() {
		return unidade;
	}


	public String getIsmartId() {
		return ismartId;
	}


	public String getGeekieId() {
		return geekieId;
	}


	public List<Role> getRoles() {
		return roles;
	}
	
	public void setGeekieId(String geekieId){
		this.geekieId = geekieId;
	}
	

}
