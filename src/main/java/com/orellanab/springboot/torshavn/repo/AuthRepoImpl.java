package com.orellanab.springboot.torshavn.repo;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orellanab.springboot.torshavn.entity.AppUser;
import com.orellanab.springboot.torshavn.repo.interfaces.AuthRepo;

@Repository
public class AuthRepoImpl implements AuthRepo {

	private EntityManager _entityManager;
	
	@Autowired
	public AuthRepoImpl(EntityManager entityManager) {
		_entityManager = entityManager;
	}
	
	@Override
	public AppUser findByUsername(String email) {
		
		Session currentSession = _entityManager.unwrap(Session.class);
		
		Query<AppUser> query = currentSession.createQuery("from AppUser where email = :email", AppUser.class);
		query.setParameter("email", email);
		
		AppUser user = query.getSingleResult();
		
		return user;
	}

}
