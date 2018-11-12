package com.enuedu.service.spring.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.pojo.Neu_CLOCKIN;
import com.neuedu.XiaoRyi.service.Neu_ClockInService;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

public class SechelLeaveRestorListTest {
	
	/**
	 * 集合测试
	 */
	@Test
	public void autotest1() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_ClockInService neu_clockinservice=(Neu_ClockInService) context.getBean("autoClockService");
		
		Neu_CLOCKIN clockin=new Neu_CLOCKIN();
		//clockin.setNeu_retroactivein(new Date().getTime());
		//clockin.setNeu_retroactiveout(new Date().getTime());
		clockin.setNeu_clockin_startin(null);
		clockin.setNeu_clockin_startout(null);
		//clockin.setNeu_empno(null);
		List<Neu_CLOCKIN> list1=neu_clockinservice.findByExample(clockin);
		
		
		
		Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) context.getBean("autoleaveService");
		Neu_Ask_Leave leave =new Neu_Ask_Leave();
		leave.setAsk_leave_accept((long)0);
		List<Neu_Ask_Leave> list2=neu_ask_leaveservice.findByExample(leave);
		
		Set set = new HashSet(list2);
	    set.addAll(list1);
	    List c = new ArrayList(set);
	    for (Object object : c) {
	    	if(object instanceof Neu_Ask_Leave ) {
	    		Neu_Ask_Leave leave2=(Neu_Ask_Leave) object;
	    		System.out.println("请假");
	    		System.out.println(leave2.getAsk_leave_id());
	    		System.out.println(leave2.getEmpno());
	    		System.out.println(leave2.getAsk_leave_accept());
	    		System.out.println("-----");
	    	}else {
	    		Neu_CLOCKIN clockin2=(Neu_CLOCKIN) object;
	    		System.out.println("补签:");
	    		System.out.println(clockin2.getNeu_empno());
	    		System.out.println(clockin2.getNeu_clockin_id());
	    	}
	    		
		}
	    
		
	}
	
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
}
