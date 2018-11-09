package com.enuedu.mybatisspring.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.Mapper.Neu_AccountMapper;
import com.neuedu.XiaoRyi.pojo.Neu_Account;

public class MyBatisSpringTest {
ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	
	/**
	 * 数据源测试
	 */
	@Test
	public void datasoursetest() {
		
		Object obj= context.getBean("dataSource");
		System.out.println(obj);
		
	}
	
	
	@Test
	public void mappertest() {
		
		SqlSessionFactory sqlSession= (SqlSessionFactory) context.getBean("sqlSessionFactory");
		SqlSession session=sqlSession.openSession();
		Neu_AccountMapper mapper=session.getMapper(Neu_AccountMapper.class);
		List<Neu_Account> list=mapper.findAll();
		for (Neu_Account neu_Account : list) {
			System.out.println(neu_Account.toString());
		}
			
		session.close();
		
	}
}
