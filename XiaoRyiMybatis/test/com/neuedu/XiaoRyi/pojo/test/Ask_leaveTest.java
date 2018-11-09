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

import com.neuedu.XiaoRyi.Mapper.Neu_ask_leaveMapper;
import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;


public class Ask_leaveTest {
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
	
	/**
	 * 查询未批准的
	 */
	@Test
	public void findByExample1() {
		SqlSession session=factory.openSession();
		Neu_ask_leaveMapper mapper=session.getMapper(Neu_ask_leaveMapper.class);
		Neu_Ask_Leave leave=new Neu_Ask_Leave();
		leave.setAsk_leave_accept((long)1);
		leave.setEmpno((long)3);
		List<Neu_Ask_Leave> leave1=mapper.findByExample(leave);
		for (Neu_Ask_Leave neu_Ask_Leave : leave1) {
			System.out.println(neu_Ask_Leave.toString());
		}
		//session.commit();
		session.close();
		
	}
	
	@Test
	public void findByExample() {
		SqlSession session=factory.openSession();
		Neu_ask_leaveMapper mapper=session.getMapper(Neu_ask_leaveMapper.class);
		
		Neu_Ask_Leave leave=new Neu_Ask_Leave();
		
		//leave.setAsk_leave_begin(new Date().getTime());
		//leave.setAsk_leave_end(new Date().getTime());
	
		leave.setAsk_leave_type("shijia");
		leave.setAsk_leave_reason("no");
		leave.setEmpno((long)8);
		
		List<Neu_Ask_Leave> leave1=mapper.findByExample(leave);
		for (Neu_Ask_Leave neu_Ask_Leave : leave1) {
			System.out.println(neu_Ask_Leave.toString());
		}
		//session.commit();
		session.close();
	}
	
	
	
	@Test
	public void findAll() {
		SqlSession session=factory.openSession();
		Neu_ask_leaveMapper mapper=session.getMapper(Neu_ask_leaveMapper.class);
		
		List<Neu_Ask_Leave> leave= mapper.findAll();
		System.out.println(leave.get(0).getAsk_leave_begin());
		for (Neu_Ask_Leave neu_Ask_Leave : leave) {
			System.out.println(neu_Ask_Leave.getAsk_leave_id());
			System.out.println(neu_Ask_Leave.getAsk_leave_begin());
			System.out.println(neu_Ask_Leave.getAsk_leave_end());
		}
		
		
		session.close();
		
	}
	
	@Test
	public void findById() {
		SqlSession session=factory.openSession();
		Neu_ask_leaveMapper mapper=session.getMapper(Neu_ask_leaveMapper.class);
		
		Neu_Ask_Leave leave= mapper.findById((long)125);
		System.out.println(leave.toString());
		System.out.println(leave.getAsk_leave_id());
		System.out.println(leave.getAsk_leave_begin());
		System.out.println(leave.getAsk_leave_end());
		System.out.println(leave.getAsk_leave_reason());
		System.out.println(leave.getAsk_leave_type());
		System.out.println(leave.getAsk_leave_accept());
		
		session.close();
		
	}
	
	@Test
	public void update() {
		SqlSession session=factory.openSession();
		Neu_ask_leaveMapper mapper=session.getMapper(Neu_ask_leaveMapper.class);
		
		Neu_Ask_Leave leave=new Neu_Ask_Leave();
		
		leave.setAsk_leave_id((long)82);
		leave.setAsk_leave_begin(new Date().getTime());
		leave.setAsk_leave_end(new Date().getTime());
	
		leave.setAsk_leave_type("shijia");
		//leave.setAsk_leave_reason("no");
		//leave.setEmpno((long)8);
		
		mapper.update(leave);
		//session.commit();
		session.close();
	}
	
	@Test
	public void delete() {
		SqlSession session=factory.openSession();
		Neu_ask_leaveMapper mapper=session.getMapper(Neu_ask_leaveMapper.class);
		
		mapper.delete((long)82);
		
		session.close();
		
	}
	
	@Test
	public void add1() {
		SqlSession session=factory.openSession();
		Neu_ask_leaveMapper mapper=session.getMapper(Neu_ask_leaveMapper.class);
		
		Neu_Ask_Leave leave=new Neu_Ask_Leave();
		
		leave.setAsk_leave_begin(new Date().getTime());
		leave.setAsk_leave_end(new Date().getTime());
	
		leave.setAsk_leave_type("shijia");
		leave.setAsk_leave_reason("no");
		leave.setEmpno((long)3);
		leave.setAsk_leave_accept((long)1);
		
		mapper.add(leave);
		session.commit();
		session.close();
	}
}
