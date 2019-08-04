package com.orellanab.springboot.torshavn.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.orellanab.springboot.torshavn.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orellanab.springboot.torshavn.repo.interfaces.UserRepo;

@Repository
public class UserRepoImpl implements UserRepo {
	
	private EntityManager _entityManager;
	
	@Autowired
	public UserRepoImpl(EntityManager entityManager) {
		_entityManager = entityManager;
	}

	@Override
	public List<User> findAllUsers() {
		
		Session currentSession = _entityManager.unwrap(Session.class);
		
		Query<User> query = currentSession.createQuery("from User", User.class);
		
		List<User> users = query.getResultList();
		
		return users;
	}

	@Override
	@Transactional
	public User loadUserByUsername(String username) {

		Session currentSession = _entityManager.unwrap(Session.class);

		Query<User> query = currentSession.createQuery("from User where username =: username ", User.class);
		query.setParameter("username", username);

		User user = query.getSingleResult();

		return user;
	}

	@Override
	public User saveUser(User user) {

		Session currentSession = _entityManager.unwrap(Session.class);

		currentSession.save(user);
		return user;

	}

	@Override
	public boolean usernameExists(String username) {
		
		Session currentSession = _entityManager.unwrap(Session.class);

		Query<User> query = currentSession.createQuery("from User where username =: username ", User.class);
		query.setParameter("username", username);
		
		User user = null;
		
		try {
			
			user = query.getSingleResult();
			if (user != null)
				return true;

		} catch (Exception ex) {
			return false;
			// throw new UsernameNotFoundException("User not found with username: " + username);
		}

		return false;
	}

}
