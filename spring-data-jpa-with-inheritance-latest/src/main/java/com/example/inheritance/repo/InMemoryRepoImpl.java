package com.example.inheritance.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.example.inheritance.model.User;

@Repository
@ConditionalOnProperty(name = "mode", havingValue = "test", matchIfMissing = false)
public class InMemoryRepoImpl implements UserRepositoryItf{
	List<User> inner = new ArrayList<User>();

	
	@Override
	public User save(User foo) {
		inner.add(foo);
		return foo;	
	}

	@Override
	public List<Map<String, Object>> getSomeReport() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("deneme", "value");
		List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
		if(inner.size()==1)
			list.add(map);
		return list;
	}

}
