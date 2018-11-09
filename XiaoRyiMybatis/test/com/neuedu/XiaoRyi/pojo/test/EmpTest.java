package com.neuedu.XiaoRyi.pojo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.XiaoRyi.Mapper.Neu_EmpMapper;
import com.neuedu.XiaoRyi.pojo.Neu_Emp;

public class EmpTest {
	SqlSessionFactory factory = null;
	@Before
	public void before() throws IOException {
		// 读取配置文件
		InputStream inputstream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		// 创建session工厂,类似conn
		factory = new SqlSessionFactoryBuilder().build(inputstream);
		// 获取session
		// 会有线程问题
		//session = factory.openSession();
	}
	@Test
	public void findByExample() {
		SqlSession session=factory.openSession();
		Neu_EmpMapper mapper=session.getMapper(Neu_EmpMapper.class);
		Neu_Emp emp=new Neu_Emp();
		emp.setNeu_empno((long)25);
		List<Neu_Emp> list=mapper.findByExample(emp);
		for (Neu_Emp neu_Emp : list) {
			System.out.println(neu_Emp.toString());
		}
		
		session.close();
	}
	

	@Test
	public void findAll() {
		SqlSession session=factory.openSession();
		Neu_EmpMapper mapper=session.getMapper(Neu_EmpMapper.class);
		List<Neu_Emp> list=mapper.findAll();
		for (Neu_Emp neu_Emp : list) {
			System.out.println(neu_Emp.toString());
		}
		
		session.close();
	}
	
	@Test
	public void findById() {
		SqlSession session=factory.openSession();
		Neu_EmpMapper mapper=session.getMapper(Neu_EmpMapper.class);
		Neu_Emp emp= mapper.findById((long)50);
		System.out.println(emp.toString());
		session.close();
	}
	
	@Test
	public void update() {
		SqlSession session=factory.openSession();
		Neu_EmpMapper mapper=session.getMapper(Neu_EmpMapper.class);
		Neu_Emp emp=new Neu_Emp();
		emp.setNeu_id((long)50);
		emp.setNeu_addre("成都");
		emp.setNeu_empno((long)25);
		mapper.update(emp);
		session.close();
	}
	
	@Test
	public void delete() {
		SqlSession session=factory.openSession();
		Neu_EmpMapper mapper=session.getMapper(Neu_EmpMapper.class);
		mapper.delete((long)50);
		session.close();
	}
	
	@Test
	public void add() {
		SqlSession session=factory.openSession();
		Neu_EmpMapper mapper=session.getMapper(Neu_EmpMapper.class);
		Neu_Emp emp=new Neu_Emp();
		emp.setNeu_age((long)20);
		emp.setNeu_delete((long)1);
		emp.setNeu_email("zhangsan@126.com");
		emp.setNeu_name("zhangsan");
		emp.setNeu_sex((long)1);
		emp.setNeu_addre("成都");
		emp.setNeu_empno((long)50);
		emp.setNeu_tel((long)110);
		
		mapper.add(emp);
		session.close();
	}
}
