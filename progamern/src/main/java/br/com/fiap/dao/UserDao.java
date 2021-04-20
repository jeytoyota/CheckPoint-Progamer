package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;
import br.com.fiap.model.User;
import br.com.fiap.util.EntityManagerFacade;

public class UserDao {
	
	private EntityManager manager = EntityManagerFacade.get();
	
	public void save(User user) {
		
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		
		manager.close();
		
	}

	public List<User> getAll() {
		
		return manager.createQuery("SELECT u from User u", User.class).getResultList();
		
		}

}
