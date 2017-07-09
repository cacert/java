package com.example.inheritance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inheritance.model.User;

@Repository
public interface UserRepositorySpringJPA  extends JpaRepository<User, Long>{

}
