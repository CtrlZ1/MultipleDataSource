package com.itmayidu.test01.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itmayidu.test01.mapper.UserMappertest01;

@Service
public class UserServicetest01 {
	@Autowired
	private UserMappertest01 usermapper1;
	@Transactional(transactionManager = "test1TransactionManager")
	public int insertUser(String name, Integer age) {
		int insertUserResult = usermapper1.insert(name, age);
		int i = 1 / age;
		System.out.println(insertUserResult + "");
		return insertUserResult;
	}
}
