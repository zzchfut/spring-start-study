package com.mybatis3.hello;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class App {
	
	@Test
	public void getUser() throws IOException{
		//classpath路径
       String globalConfig = "mybatis-config.xml";
       InputStream inputStream = Resources.getResourceAsStream(globalConfig);
       
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
       
       SqlSession session = sqlSessionFactory.openSession();
       
       User user = session.selectOne("com.mybatis3.hello.UserMapper.selectUser", 1L);
       
       session.close();
       
       System.out.println(user);       
	}

	@Test
	public void getUserAll() throws IOException{
		//classpath路径
       String globalConfig = "mybatis-config.xml";
       InputStream inputStream = Resources.getResourceAsStream(globalConfig);
       
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
       
       SqlSession session = sqlSessionFactory.openSession();
       
       List<User> users = session.selectList("com.mybatis3.hello.UserMapper.selectUserAll");
       
       session.close();
       
       for(User user : users){
    	   System.out.println(user); 
       }
	}

	
}
