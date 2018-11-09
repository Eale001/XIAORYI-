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

import com.neuedu.XiaoRyi.Dao.Neu_AccountMapper;
import com.neuedu.XiaoRyi.pojo.Neu_Account;

public class AccountTest {
	
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
	public void findByPage() {
		SqlSession session=factory.openSession();
		Neu_AccountMapper mapper=session.getMapper(Neu_AccountMapper.class);
		int page=1;
		int total=3;
		List<Neu_Account> list=mapper.findByPage(page, total);
		for (Neu_Account neu_Account : list) {
			System.out.println(neu_Account.getM_id());
			System.out.println(neu_Account.getNei_empno());
			System.out.println(neu_Account.getNeu_pwd());
			System.out.println(neu_Account.getNeu_power_level());
			System.out.println("------");
		}
	}
	
	@Test
	public void findByExample() {
		SqlSession session=factory.openSession();
		Neu_AccountMapper mapper=session.getMapper(Neu_AccountMapper.class);
		Neu_Account account=new Neu_Account();
		account.setNeu_power_level((long)1);
		List<Neu_Account> list=mapper.findByExample(account);
		for (Neu_Account neu_Account : list) {
			System.out.println(neu_Account.getM_id());
			System.out.println(neu_Account.getNei_empno());
			System.out.println(neu_Account.getNeu_pwd());
			System.out.println(neu_Account.getNeu_power_level());
			System.out.println("------");
		}
		
	}
	
	@Test
	public void findAll() {
		SqlSession session=factory.openSession();
		Neu_AccountMapper mapper=session.getMapper(Neu_AccountMapper.class);
		List<Neu_Account> list=mapper.findAll();
		for (Neu_Account neu_Account : list) {
			System.out.println(neu_Account.getM_id());
			System.out.println(neu_Account.getNei_empno());
			System.out.println(neu_Account.getNeu_pwd());
			System.out.println(neu_Account.getNeu_power_level());
			System.out.println("------");
		}
	}
	
	
	@Test
	public void findById() {
		SqlSession session=factory.openSession();
		Neu_AccountMapper mapper=session.getMapper(Neu_AccountMapper.class);
		Neu_Account account=mapper.findById((long)82);
		System.out.println(account.getNei_empno());
		System.out.println(account.getNeu_pwd());
		System.out.println(account.getNeu_power_level());
		session.close();
	}
	
	@Test
	public void update() {
		SqlSession session=factory.openSession();
		Neu_AccountMapper mapper=session.getMapper(Neu_AccountMapper.class);
		Neu_Account account=new Neu_Account();
		account.setM_id((long)82);
		account.setNei_empno((long)8);
		//account.setNeu_pwd("222222");
		account.setNeu_power_level((long)2);
		mapper.update(account);
		session.commit();
		session.close();
	}
	
	@Test
	public void delete() {
		SqlSession session=factory.openSession();
		Neu_AccountMapper mapper=session.getMapper(Neu_AccountMapper.class);
		mapper.delete((long)81);
		session.commit();
		session.close();
	}
	
	@Test
	public void add1() {
		SqlSession session=factory.openSession();
		Neu_AccountMapper mapper=session.getMapper(Neu_AccountMapper.class);
		Neu_Account account=new Neu_Account();
		account.setNei_empno((long)9);
		account.setNeu_pwd("11111111");
		//account.setNeu_power_level((long)2);
		mapper.add(account);
		session.commit();
		session.close();
	}
	
	
	
	
	@Test	
	public void add() throws IOException {
		//读取配置文件
				InputStream inputstream=Resources.getResourceAsStream("config/SqlMapConfig.xml");
				//创建session工厂,类似conn
				SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputstream);
				//获取session
				SqlSession session=factory.openSession();
				
				Neu_Account account=new Neu_Account();
				account.setNei_empno((long)5);
				account.setNeu_pwd("888888");
				account.setNeu_power_level((long)3);
				
				
				//插入(名词空间.id,user对象)
				session.insert("com.neuedu.XiaoRyi.pojo.insertAccount", account);
				session.commit();
				session.close();
	}
}	
