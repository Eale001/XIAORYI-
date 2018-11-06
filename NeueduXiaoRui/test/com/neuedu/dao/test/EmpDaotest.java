package com.neuedu.dao.test;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.neuedu.XiaoRyi.Dao.Neu_EmpDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Emp;

public class EmpDaotest {
	Neu_EmpDao neu_empdao=null;
	Connection conn=null;
	Neu_Emp emp=null;
	
	@Before
	public void init() {
		neu_empdao=(Neu_EmpDao) FactoryUtil.getInstanceObjectByName("Neu_EmpDao");
		conn=DBUtil.getOracleConnection();
		emp=new Neu_Emp();
	}
	@Test
	public void findByPage() {
		Integer page=2;
		Integer total=4;
		List<Neu_Emp> list=neu_empdao.findByPage(page, total, conn);
		for (Neu_Emp neu_Emp : list) {
			System.out.println(neu_Emp.getNeu_id());
			System.out.println(neu_Emp.getNeu_name());
			System.out.println(neu_Emp.getNeu_email());
			System.out.println(neu_Emp.getNeu_addre());
			System.out.println(neu_Emp.getNeu_age());
			System.out.println(neu_Emp.getNeu_sex());
			System.out.println(neu_Emp.getNeu_empno());
			System.out.println(neu_Emp.getNeu_tel());
			System.out.println("------");
		}
	}
	
	@Test
	public void findAll() {
		List<Neu_Emp> list=neu_empdao.findAll(conn);
		for (Neu_Emp neu_Emp : list) {
			System.out.println(neu_Emp.getNeu_id());
			System.out.println(neu_Emp.getNeu_name());
			System.out.println(neu_Emp.getNeu_email());
			System.out.println(neu_Emp.getNeu_addre());
			System.out.println(neu_Emp.getNeu_age());
			System.out.println(neu_Emp.getNeu_sex());
			System.out.println(neu_Emp.getNeu_empno());
			System.out.println(neu_Emp.getNeu_tel());
			System.out.println("------");
		}
	}
	
	@Test
	public void findByid() {
		Long id=(long)61;
		Optional<Neu_Emp> opt=neu_empdao.findById(id, conn);
		System.out.println(opt.get().getNeu_id());
		System.out.println(opt.get().getNeu_name());
		System.out.println(opt.get().getNeu_email());
		System.out.println(opt.get().getNeu_addre());
		System.out.println(opt.get().getNeu_age());
		System.out.println(opt.get().getNeu_sex());
		System.out.println(opt.get().getNeu_empno());
		System.out.println(opt.get().getNeu_tel());
		
	}
	
	
	@Test
	public void add() {
		emp.setNeu_name("王五15");
		emp.setNeu_email("wangwu@163.com");
		emp.setNeu_addre("成都");
		emp.setNeu_empno((long)13);
		emp.setNeu_tel((long)110);
		emp.setNeu_age((long)35);
		emp.setNeu_sex((long)0);
		neu_empdao.add(emp, conn);
	}
	
}
