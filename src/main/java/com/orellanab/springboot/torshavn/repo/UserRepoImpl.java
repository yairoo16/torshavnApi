package com.orellanab.springboot.torshavn.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orellanab.springboot.torshavn.entity.AppUser;
import com.orellanab.springboot.torshavn.repo.interfaces.UserRepo;

@Repository
public class UserRepoImpl implements UserRepo {
	
	private EntityManager _entityManager;
	
	@Autowired
	public UserRepoImpl(EntityManager entityManager) {
		_entityManager = entityManager;
	}

	@Override
	public List<AppUser> findAllUsers() {
		
		Session currentSession = _entityManager.unwrap(Session.class);
		
		Query<AppUser> query = currentSession.createQuery("from User", AppUser.class);
		
		List<AppUser> users = query.getResultList();
		
		return users;
	}

}
