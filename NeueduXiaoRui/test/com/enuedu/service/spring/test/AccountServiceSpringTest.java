package com.enuedu.service.spring.test;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Account;
import com.neuedu.XiaoRyi.service.Neu_AccountService;

public class AccountServiceSpringTest {
	
	/**
	 * 测试查询所有
	 */
	@Test
	public void autotest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_AccountService autoaccountservice=(Neu_AccountService) context.getBean("autoaccountService");
		List<Neu_Account> list=autoaccountservice.findAll();
		for (Neu_Account neu_Account : list) {
			System.out.println(neu_Account.toString());
		}
	}
	
	/**
	 * 测试分页查询
	 */
	@Test
	public void autopagetest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_AccountService autoaccountservice=(Neu_AccountService) context.getBean("autoaccountService");
		Page page=new Page();
		page.setPageSize(4);
		page.setCurrentPage(3);
		
		List<Neu_Account> list=autoaccountservice.findPage(page);
		for (Neu_Account neu_Account : list) {
			System.out.println(neu_Account.toString());
			System.out.println(neu_Account.getM_id());
		}
	}
	
	/**
	 * 测试ID查询
	 */
	@Test
	public void autotest1() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_AccountService autoaccountservice=(Neu_AccountService) context.getBean("autoaccountService");
		Optional<Neu_Account> opt=autoaccountservice.findById((long)10);
		System.out.println(opt.get().getNei_empno());
		System.out.println(opt.get().getNeu_pwd());
	}
}
