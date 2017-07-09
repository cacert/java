package com.example.inheritance.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.inheritance.model.User;

@Repository
@ConditionalOnProperty(name = "mode", havingValue = "jpa", matchIfMissing = false)
public class UserRepositoryWithTemplateWithJPA implements UserRepositoryItf 
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    UserRepositorySpringJPA userJpaRepo;

    @Override
    //@Transactional
	public User save(User foo)
    {
         return userJpaRepo.save(foo);
    }

    @Override
	public List<Map<String,Object>> getSomeReport()
    {
         return this.jdbcTemplate.queryForList(" SELECT * from User "); 
    }
}