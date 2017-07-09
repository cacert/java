package com.example.inheritance.repo;

import java.util.List;
import java.util.Map;

import com.example.inheritance.model.User;

public interface UserRepositoryItf {

	User save(User foo);

	List<Map<String, Object>> getSomeReport();

}