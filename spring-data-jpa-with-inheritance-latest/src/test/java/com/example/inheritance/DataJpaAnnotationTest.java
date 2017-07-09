package com.example.inheritance;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inheritance.main.InheritanceApplication;
import com.example.inheritance.model.User;
import com.example.inheritance.repo.UserRepositorySpringJPA;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={InheritanceApplication.class})
@DataJpaTest
public class DataJpaAnnotationTest {

	@Autowired	
	private UserRepositorySpringJPA user ;
	
	@Test
	public void testUserRepo(){
		assertTrue(user.findAll().size() == 0);
		user.save(new User());
		assertTrue(user.count()==1);
	}
}
