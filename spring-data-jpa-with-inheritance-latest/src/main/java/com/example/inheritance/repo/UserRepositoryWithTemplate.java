package com.example.inheritance.repo;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.inheritance.model.User;

@Repository
@ConditionalOnProperty(name = "mode", havingValue = "normal", matchIfMissing = true)
public class UserRepositoryWithTemplate implements UserRepositoryItf 
{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
	public User save(User foo)
    {
         this.entityManager.persist(foo);
         return foo;
    }

    @Override
	public List<Map<String,Object>> getSomeReport()
    {
         return this.jdbcTemplate.queryForList(" SELECT * from User "); 
    }
}