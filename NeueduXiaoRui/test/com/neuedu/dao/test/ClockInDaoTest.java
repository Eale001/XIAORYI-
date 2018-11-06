package com.neuedu.dao.test;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.neuedu.XiaoRyi.Dao.Neu_ClockInDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_CLOCKIN;

public class ClockInDaoTest {
	Neu_ClockInDao neu_clockindao=null;
	Connection conn=null;
	Neu_CLOCKIN clockin=null;
	@Before
	public void init() {
		neu_clockindao=(Neu_ClockInDao) FactoryUtil.getInstanceObjectByName("Neu_ClockInDao");
		conn=DBUtil.getOracleConnection();
		clockin=new Neu_CLOCKIN();
	}
	
	
	
	@Test
	public void delete() {
		Long id=(long)1;
		neu_clockindao.delete(id, conn);
	}
	
	@Test
	public void findById() {
		Long id=(long)27;
		Optional<Neu_CLOCKIN> opt=neu_clockindao.findById(id, conn);
		
		System.out.println(opt.get().getNeu_clockin_id());
		System.out.println(opt.get().getNeu_clockin_startin());
		System.out.println(opt.get().getNeu_clockin_startout());
		System.out.println(opt.get().getNeu_empno());
		System.out.println(opt.get().getNeu_retroactivein());
		System.out.println(opt.get().getNeu_retroactiveout());
	}
	
	@Test
	public void findAll() {
		List<Neu_CLOCKIN> list=neu_clockindao.findAll(conn);
		for (Neu_CLOCKIN neu_CLOCKIN : list) {
			System.out.println(neu_CLOCKIN.getNeu_clockin_id());
			System.out.println(neu_CLOCKIN.getNeu_clockin_startin());
			System.out.println(neu_CLOCKIN.getNeu_clockin_startout());
			System.out.println(neu_CLOCKIN.getNeu_empno());
			System.out.println(neu_CLOCKIN.getNeu_retroactivein());
			System.out.println(neu_CLOCKIN.getNeu_retroactiveout());
			System.out.println("----------");
		}
	}
	
	@Test
	public void findByExample() {
		clockin.setNeu_empno((long)2);
		
		List<Neu_CLOCKIN> list=neu_clockindao.findByExample(clockin, conn);
		
		for (Neu_CLOCKIN neu_CLOCKIN : list) {
			System.out.println(neu_CLOCKIN.getNeu_clockin_id());
			System.out.println(neu_CLOCKIN.getNeu_clockin_startin());
			System.out.println(neu_CLOCKIN.getNeu_clockin_startout());
			System.out.println(neu_CLOCKIN.getNeu_empno());
			System.out.println(neu_CLOCKIN.getNeu_retroactivein());
			System.out.println(neu_CLOCKIN.getNeu_retroactiveout());
			System.out.println("----------");
		}
	}
}
