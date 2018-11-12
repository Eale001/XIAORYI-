package com.enuedu.service.spring.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.pojo.Neu_CLOCKIN;
import com.neuedu.XiaoRyi.service.Neu_ClockInService;

public class ClockInServiceSpringTest {
	@Test
	public void autotest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_ClockInService neu_clockinservice=(Neu_ClockInService) context.getBean("autoClockService");
		List<Neu_CLOCKIN> list=neu_clockinservice.findAll();
		for (Neu_CLOCKIN neu_CLOCKIN : list) {
			System.out.println(neu_CLOCKIN.toString());
		}
	}
	@Test
	public void autotest1() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_ClockInService neu_clockinservice=(Neu_ClockInService) context.getBean("autoClockService");
		Neu_CLOCKIN clockin=new Neu_CLOCKIN();
		clockin.setNeu_retroactivein(new Date().getTime());
		clockin.setNeu_retroactiveout(new Date().getTime());
		clockin.setNeu_empno((long)3);
		
		neu_clockinservice.add(clockin);
		
	}
}
