package com.neuedu.dao.test;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.neuedu.XiaoRyi.Dao.Neu_ask_leaveDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Ask_Leave;

public class Ask_leaveDaoTest {
	Neu_ask_leaveDao neu_ask_leavedao=null;
	Connection conn=null;
	Neu_Ask_Leave leave=null;
	
	@Before
	public void init() {
		neu_ask_leavedao=(Neu_ask_leaveDao) FactoryUtil.getInstanceObjectByName("Neu_ask_leaveDao");
		conn=DBUtil.getOracleConnection();
		leave=new Neu_Ask_Leave();
		
	}
	@Test
	public void findByExample() {
		Date date=new Date();
		Long time=date.getTime();
		
		//leave.setEmpno((long)13);
		leave.setM_id((long)12);
		List<Neu_Ask_Leave> list=neu_ask_leavedao.findByExample(leave, conn);
		for (Neu_Ask_Leave neu_Ask_Leave : list) {
			System.out.println(neu_Ask_Leave.getAsk_leave_id());
			System.out.println(neu_Ask_Leave.getAsk_leave_begin());
			System.out.println(neu_Ask_Leave.getAsk_leave_end());
			System.out.println(neu_Ask_Leave.getAsk_leave_reason());
			System.out.println(neu_Ask_Leave.getAsk_leave_type());
			System.out.println(neu_Ask_Leave.getAsk_leave_accept());
			System.out.println(neu_Ask_Leave.getEmpno());
			System.out.println(neu_Ask_Leave.getM_id());
			System.out.println("------");
		}
	}
	
	
	@Test
	public void findAll() {
		
		List<Neu_Ask_Leave> list=neu_ask_leavedao.findAll(conn);
		for (Neu_Ask_Leave neu_Ask_Leave : list) {
			System.out.println(neu_Ask_Leave.getAsk_leave_id());
			System.out.println(neu_Ask_Leave.getAsk_leave_begin());
			System.out.println(neu_Ask_Leave.getAsk_leave_end());
			System.out.println(neu_Ask_Leave.getAsk_leave_reason());
			System.out.println(neu_Ask_Leave.getAsk_leave_type());
			System.out.println(neu_Ask_Leave.getAsk_leave_accept());
			System.out.println(neu_Ask_Leave.getEmpno());
			System.out.println(neu_Ask_Leave.getM_id());
		}
	}
	
	@Test
	public void findById() {
		Long id=(long) 34;		
		Optional<Neu_Ask_Leave> opt=neu_ask_leavedao.findById(id, conn);
		System.out.println(opt.get().getAsk_leave_id());
		System.out.println(opt.get().getAsk_leave_begin());
		System.out.println(opt.get().getAsk_leave_end());
		System.out.println(opt.get().getAsk_leave_reason());
		System.out.println(opt.get().getAsk_leave_type());
		System.out.println(opt.get().getAsk_leave_accept());
		System.out.println(opt.get().getEmpno());
		System.out.println(opt.get().getM_id());
	}
	
	@Test
	public void update() {
		Date date=new Date();
		Long time=date.getTime();
		leave.setAsk_leave_id((long)34);
		leave.setAsk_leave_begin(time);
		leave.setAsk_leave_end(time);
		leave.setEmpno((long)14);
		
		neu_ask_leavedao.update(leave, conn);
		
	}
	
	@Test
	public void delete() {
		Long id=(long)33;
		neu_ask_leavedao.delete(id, conn);
	}
	
	@Test
	public void add() {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date date=new Date();
		Long time=date.getTime();
		
		leave.setAsk_leave_begin(time);
		leave.setAsk_leave_end(time);
		leave.setAsk_leave_reason("1223");
		leave.setAsk_leave_type("shijia");
		leave.setM_id((long)12);
		leave.setEmpno((long)13);
		neu_ask_leavedao.add(leave, conn);
	}
}
