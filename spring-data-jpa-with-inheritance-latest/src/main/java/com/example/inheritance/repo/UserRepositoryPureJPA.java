package com.example.inheritance.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.inheritance.model.User;

@Repository
public class UserRepositoryPureJPA {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Create
	 */
	@Transactional
	public User save(User man) {
		entityManager.persist(man);
		entityManager.flush();
		return man;
	}

	/**
	 * Find
	 */
	public User findOne(Long id) {
		return entityManager.find(User.class, id);
	}

}
