package com.itmayidu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmayidu.test01.service.UserServicetest01;
import com.itmayidu.test02.service.UserServicetest02;

@RestController
public class MybatisMultiple {
	// 多数据源
	@Autowired
	private UserServicetest01 userServicetest1;
	@Autowired
	private UserServicetest02 userServicetest2;

	@RequestMapping("/insertusertest1")
	public Integer insertUser1(String name, Integer age) {
		return userServicetest1.insertUser(name, age);
	}

	@RequestMapping("/insertusertest2")
	public Integer insertUser2(String name, Integer age) {
		return userServicetest2.insertUser(name, age);
	}

	@RequestMapping("/insertusertest1andtest2")
	public Integer insertUsertest01andtest02(String name, Integer age) {
		return userServicetest2.insertUsertest01andtest02(name, age);
	}

}
