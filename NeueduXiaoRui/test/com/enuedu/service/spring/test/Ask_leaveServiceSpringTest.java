package com.enuedu.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

public class Ask_leaveServiceSpringTest {
	@Test
	public void autotest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) context.getBean("autoleaveService");
		List<Neu_Ask_Leave> list=neu_ask_leaveservice.findAll();
		for (Neu_Ask_Leave neu_ask_leave : list) {
			System.out.println(neu_ask_leave.getAsk_leave_id());
			System.out.println(neu_ask_leave.getAsk_leave_begin());
			System.out.println(neu_ask_leave.getAsk_leave_end());
			System.out.println("----");
		}
	}
	
	/**
	 * 分页测试
	 */
	@Test
	public void autopagetest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) context.getBean("autoleaveService");
		Page page=new Page();
		page.setPageSize(3);
		page.setCurrentPage(1);
		Neu_Ask_Leave leave=new Neu_Ask_Leave();
		//leave.setEmpno((long)3);
		leave.setAsk_leave_accept((long)1);
		
		List<Neu_Ask_Leave> list=neu_ask_leaveservice.findByPageEmp(page, leave);
		for (Neu_Ask_Leave neu_ask_leave : list) {
			System.out.println(neu_ask_leave.getAsk_leave_id());
			System.out.println(neu_ask_leave.getAsk_leave_begin());
			System.out.println(neu_ask_leave.getAsk_leave_end());
			System.out.println("----");
		}
	}
	
	/**
	 * 分页测试
	 */
	@Test
	public void autopage1test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) context.getBean("autoleaveService");
		int page=1;
		int total=3;
		
		List<Neu_Ask_Leave> list=neu_ask_leaveservice.findByPageAccount(page, total);
		for (Neu_Ask_Leave neu_ask_leave : list) {
			System.out.println(neu_ask_leave.getAsk_leave_id());
			System.out.println(neu_ask_leave.getAsk_leave_begin());
			System.out.println(neu_ask_leave.getAsk_leave_end());
			System.out.println("----");
		}
	}
}
