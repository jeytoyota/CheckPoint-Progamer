package br.com.fiap.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;

@Named
@RequestScoped
public class UserBean {
	
	private User user = new User();
	
	public void save() {
		new UserDao().save(this.user);
		this.user = new User();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User cadastrado com sucesso!"));
	}
	
	public List<User> getUsers(){
		return new UserDao().getAll();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
