package com.example.inheritance;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inheritance.main.InheritanceApplication;
import com.example.inheritance.repo.UserRepositoryItf;
import com.example.inheritance.repo.UserRepositoryPureJPA;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={InheritanceApplication.class})
public class InheritanceApplicationTests {

	@Autowired
	UserRepositoryItf userRepo;
	
	@Autowired
	UserRepositoryPureJPA userRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Before
	public void testInsert(){
		com.example.inheritance.model.User user = new com.example.inheritance.model.User();
		user.setName("kasim");
		user.setPass("1234");
		userRepo.save(user);
	}
	@Test
	public void testRead(){
		
		com.example.inheritance.model.User user = new com.example.inheritance.model.User();
		user.setName("kasim");
		user.setPass("1234");
		user = userRepo.save(user);
		
		user =userRepository.findOne(user.getId());
		assertTrue(user.getName().equals("kasim"));
	}
	
	@Test
	public void testInMemory(){
		List<Map<String,Object>> user =userRepo.getSomeReport();
		assertTrue("value".equals(user.get(0).get("deneme")));
	}

}
