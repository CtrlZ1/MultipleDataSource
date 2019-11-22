package com.itmayidu.test01.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.itmayidu.entity.User;

public interface UserMappertest01 {
	@Select("select * from Users where name = #{name}")
	User findByName(@Param("name") String name);
	
	@Insert("insert into Users(Name,Age) values(#{name},#{age})")
	int insert(@Param("name") String name,@Param("age") Integer age);
}
