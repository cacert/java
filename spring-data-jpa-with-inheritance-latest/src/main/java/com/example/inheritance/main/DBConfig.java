package com.example.inheritance.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"com.example.inheritance.repo"})
public class DBConfig {
	
//	@Bean
//	public UserRepoItf userRepo(){
//		return new RandomRepoImpl();
//	}

}
