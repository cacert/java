package com.example.inheritance.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.example.inheritance.repo"})
@ComponentScan(basePackages={"com.example.inheritance.repo"})
@EntityScan(basePackages="com.example.inheritance.model")
public class InheritanceApplication  implements CommandLineRunner{

//	@Autowired
//	UserRepoItf withTemplate;
	
//	@Autowired
//	UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(InheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setId(1L);
//		user.setName("kasim");
//		user.setPass("1234");
//		userRepo.save(user);
//		
//		User findOne = userRepo.findOne(1L);
//		System.err.println(findOne.getName());
//		
//		List<Map<String, Object>> report = withTemplate.getSomeReport();
//		report.stream().forEach((u)->System.out.println(u));

	}
	
}
