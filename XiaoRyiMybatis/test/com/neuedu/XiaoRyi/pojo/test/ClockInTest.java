package com.neuedu.XiaoRyi.pojo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.XiaoRyi.Dao.Neu_ClockInMapper;
import com.neuedu.XiaoRyi.pojo.Neu_CLOCKIN;

public class ClockInTest {
	
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
		Neu_ClockInMapper mapper=session.getMapper(Neu_ClockInMapper.class);
		Neu_CLOCKIN clockin=new Neu_CLOCKIN();
		
//		clockin.setNeu_clockin_startin(new Date().getTime());
//		clockin.setNeu_clockin_startout(new Date().getTime());
		
		//clockin.setNeu_retroactivein(new Date().getTime());
		//clockin.setNeu_retroactiveout(new Date().getTime());
		
		clockin.setNeu_clockin_id((long)80);
		clockin.setNeu_empno((long)2);	
		List<Neu_CLOCKIN> list=mapper.findByExample(clockin);
		for (Neu_CLOCKIN neu_CLOCKIN : list) {
			System.out.println(neu_CLOCKIN.toString());
		}
		session.close();
	}
	
	@Test
	public void findAll() {
		SqlSession session=factory.openSession();
		Neu_ClockInMapper mapper=session.getMapper(Neu_ClockInMapper.class);
		List<Neu_CLOCKIN> list=mapper.findAll();
		for (Neu_CLOCKIN neu_CLOCKIN : list) {
			System.out.println(neu_CLOCKIN.toString());
		}
		session.close();
	}
	
	@Test
	public void findById() {
		SqlSession session=factory.openSession();
		Neu_ClockInMapper mapper=session.getMapper(Neu_ClockInMapper.class);
		Neu_CLOCKIN clockin= mapper.findById((long)80);
		System.out.println(clockin.toString());
		session.close();
	}
	
	@Test
	public void update() {
		SqlSession session=factory.openSession();
		Neu_ClockInMapper mapper=session.getMapper(Neu_ClockInMapper.class);
		Neu_CLOCKIN clockin=new Neu_CLOCKIN();
		
//		clockin.setNeu_clockin_startin(new Date().getTime());
//		clockin.setNeu_clockin_startout(new Date().getTime());
		
		clockin.setNeu_retroactivein(new Date().getTime());
		clockin.setNeu_retroactiveout(new Date().getTime());
		
		clockin.setNeu_clockin_id((long)80);
		clockin.setNeu_empno((long)2);	
		mapper.update(clockin);
		session.close();
		
	}

	@Test
	public void delete() {
		SqlSession session=factory.openSession();
		Neu_ClockInMapper mapper=session.getMapper(Neu_ClockInMapper.class);
		mapper.delete((long)80);
		session.close();
	}
	
	@Test
	public void add1() {
		SqlSession session=factory.openSession();
		Neu_ClockInMapper mapper=session.getMapper(Neu_ClockInMapper.class);
		
		Neu_CLOCKIN clockin=new Neu_CLOCKIN();
		
		clockin.setNeu_clockin_startin(new Date().getTime());
		clockin.setNeu_clockin_startout(new Date().getTime());
	
		clockin.setNeu_empno((long)2);
		//clockin.setNeu_retroactivein(new Date().getTime());
		//clockin.setNeu_retroactiveout(new Date().getTime());
		
		mapper.add(clockin);
		session.commit();
		session.close();
	}
}
