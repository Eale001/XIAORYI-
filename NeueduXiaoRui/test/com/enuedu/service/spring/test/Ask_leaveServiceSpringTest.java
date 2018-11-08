package com.enuedu.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

public class Ask_leaveServiceSpringTest {
	@Test
	public void autotest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) context.getBean("autoleaveService");
		List<Neu_Ask_Leave> list=neu_ask_leaveservice.findAll();
		for (Neu_Ask_Leave neu_ask_leave : list) {
			System.out.println(neu_ask_leave.toString());
		}
	}
}
