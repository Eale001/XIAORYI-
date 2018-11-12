package com.enuedu.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Emp;
import com.neuedu.XiaoRyi.service.Neu_EmpService;

public class EmpServiceSpringTest {
	@Test
	public void autotest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_EmpService neu_empservice=(Neu_EmpService) context.getBean("autoempService");
		List<Neu_Emp> list=neu_empservice.findAll();
		for (Neu_Emp neu_emp : list) {
			System.out.println(neu_emp.toString());
			System.out.println(neu_emp.getNeu_empno());
		}
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void autopagetest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Neu_EmpService neu_empservice=(Neu_EmpService) context.getBean("autoempService");
		Page page=new Page();
		page.setPageSize(4);
		page.setCurrentPage(3);
		
		
		List<Neu_Emp> list=neu_empservice.findByPage(page);
		for (Neu_Emp neu_emp : list) {
			System.out.println(neu_emp.toString());
			System.out.println(neu_emp.getNeu_id());
		}
	}
}
