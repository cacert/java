package com.example.inheritance;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inheritance.main.InheritanceApplication;
import com.example.inheritance.model.User;
import com.example.inheritance.repo.UserRepositoryItf;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={InheritanceApplication.class})
public class UserRepoItfTest {

	@Autowired	
	private UserRepositoryItf user ;
	
	@Test
	public void testUserRepo(){
		assertTrue(user.getSomeReport().size() == 0);
		user.save(new User());
		assertTrue(user.getSomeReport().size()==1);
	}
}
