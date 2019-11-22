package com.itmayidu.test02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itmayidu.test01.mapper.UserMappertest01;
import com.itmayidu.test02.mapper.UserMappertest02;

@Service
public class UserServicetest02 {
	@Autowired
	private UserMappertest02 usermapper2;
	@Autowired
	private UserMappertest01 usermapper1;

	@Transactional(transactionManager = "test2TransactionManager")
	public int insertUser(String name, Integer age) {
		int insertUserResult = usermapper2.insert(name, age);
		int i = 1 / age;
		System.out.println(insertUserResult + "");
		return insertUserResult;
	}

	// 测试多事务回滚
	//因为@Transactional(transactionManager = "test2TransactionManager")所以说只会回滚第二个数据源，第一个数据源依然插入了
	@Transactional(transactionManager = "test2TransactionManager")
	public int insertUsertest01andtest02(String name, Integer age) {
		//传统分布式事务解决方案，jta+atomikos注册同一个全局事务中
		// 第一个数据源
		int insertUserResult01 = usermapper1.insert(name, age);
		// 第二个数据源
		int insertUserResult02 = usermapper2.insert(name, age);
		// 如果age等于0，看看这两个数据源哪一个会回滚
		int i = 1 / age;
		System.out.println(insertUserResult01 + "" + insertUserResult02);
		int insertUserResult = insertUserResult01 + insertUserResult02;
		return insertUserResult;
	}
}
