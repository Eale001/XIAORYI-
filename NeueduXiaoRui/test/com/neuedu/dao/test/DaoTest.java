package com.neuedu.dao.test;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.neuedu.XiaoRyi.Dao.Neu_ClockInDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_CLOCKIN;

public class DaoTest {
	
	@Test
	public void test4() {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");        
		DateFormat format2= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");        
		Date date = null;  
		//Date date1 = null; 
		String str = null;                 
		             
		// String转Date   
		str = "2007-1-18";         
		try {   
		           Long time = format1.parse(str.toString()).getTime();
		           System.out.println(time);
		           
		           //System.out.println(format1.format(date));
		           //date1 = format2.parse(str.toString());
		           //System.out.println(date);
		           //System.out.println(date1);
		} catch (ParseException e) {   
		           e.printStackTrace();   
		}
	}
	
	@Test
	public void timetest3() throws ParseException {
		
		LocalDate nowdate=LocalDate.now();
		
		LocalDateTime localtime=LocalDateTime.of(nowdate,LocalTime.of(9, 00));
		LocalDateTime localtime1=LocalDateTime.of(nowdate,LocalTime.of(9, 10));
		
		LocalDateTime localtime3=LocalDateTime.of(nowdate,LocalTime.of(17, 30));
		LocalDateTime localtime4=LocalDateTime.of(nowdate,LocalTime.of(18, 00));
		
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String time=dtf.format(localtime); 
		Long time1=format.parse(time).getTime();
		
		String time4=dtf.format(localtime1);
		Long time5=format.parse(time4).getTime();
		
		String time6=dtf.format(localtime3);
		Long time7=format.parse(time6).getTime();
		
		String time8=dtf.format(localtime4);
		Long time9=format.parse(time8).getTime();
		
		System.out.println(time);
		System.out.println(time1);
		
		System.out.println(time4);
		System.out.println(time5);
		
		System.out.println(time6);
		System.out.println(time7);
		
		System.out.println(time8);
		System.out.println(time9);
		
		Date date=new Date(2017,05,04,9,00);
		String time3=format.format(date);
		Long stamp=format.parse(time3).getTime();
		System.out.println(stamp);
	}
	
	
	
	public void daotest5() {
		Neu_ClockInDao neu_clockindao=(Neu_ClockInDao) FactoryUtil.getInstanceObjectByName("Neu_ClockInDao");
		
		Connection conn=DBUtil.getOracleConnection();
		Neu_CLOCKIN clockin=new Neu_CLOCKIN();
		
		
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//获取当前系统时间
			Date date=new Date();
			//转换成字符串
            String dateString = format.format(date);
            //转换成long型
			Long time=format.parse(dateString).getTime();
			//再转换成字符串
			String str=format.format(date);
			System.out.println(str);
			
			clockin.setNeu_clockin_id((long)27);
			
//			clockin.setNeu_clockin_startin(time);
//			clockin.setNeu_clockin_startout(time);
			
			clockin.setNeu_empno((long)2);
			
//			clockin.setNeu_retroactivein(time);
//			clockin.setNeu_retroactiveout(time);
			
			neu_clockindao.findByExample(clockin, conn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void daotest4() {
		Neu_ClockInDao neu_clockindao=(Neu_ClockInDao) FactoryUtil.getInstanceObjectByName("Neu_ClockInDao");
		
		Connection conn=DBUtil.getOracleConnection();
		Neu_CLOCKIN clockin=new Neu_CLOCKIN();
		
		
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//获取当前系统时间
			Date date=new Date();
			//转换成字符串
            String dateString = format.format(date);
            //转换成long型
			Long time=format.parse(dateString).getTime();
			//再转换成字符串
			String str=format.format(date);
			System.out.println(str);
			
			clockin.setNeu_clockin_id((long)3);
			
			clockin.setNeu_clockin_startin(time);
			clockin.setNeu_clockin_startout(time);
			
			clockin.setNeu_empno((long)2);
			
			clockin.setNeu_retroactivein(time);
			clockin.setNeu_retroactiveout(time);
			
			neu_clockindao.update(clockin, conn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void timetest2() {
		/**
		 * 将long型转换成字符串型
		 */
		Long lo=(long)1540609627934.0;
		Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String i=sd.format(date);
        System.out.println(i);
        try {
			System.out.println(sd.parse(i).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void daotest3() {
		String lo = "SatOct272018";
		long time = Long.parseLong(lo);
		Date date = new Date(time);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sd.format(date));
	}
	
	
	@Test
	public void daotest2() {
		Neu_ClockInDao neu_clockindao=(Neu_ClockInDao) FactoryUtil.getInstanceObjectByName("Neu_ClockInDao");
		
		Connection conn=DBUtil.getOracleConnection();
		
		
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
           
			
			List<Neu_CLOCKIN> list=neu_clockindao.findAll(conn);
			for (Neu_CLOCKIN neu_CLOCKIN : list) {
				System.out.println(neu_CLOCKIN.getNeu_clockin_id());
				System.out.println(neu_CLOCKIN.getNeu_clockin_startin());
				System.out.println(neu_CLOCKIN.getNeu_clockin_startout());
				System.out.println(neu_CLOCKIN.getNeu_empno());
				System.out.println(neu_CLOCKIN.getNeu_retroactivein());
				System.out.println(neu_CLOCKIN.getNeu_retroactiveout());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void daotest1() {
		Neu_ClockInDao neu_clockindao=(Neu_ClockInDao) FactoryUtil.getInstanceObjectByName("Neu_ClockInDao");
		
		Connection conn=DBUtil.getOracleConnection();
		Neu_CLOCKIN clockin=new Neu_CLOCKIN();
		
		
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			//获取当前系统时间
			Date date=new Date();
			//转换成字符串
            String dateString = format.format(date);
            //转换成long型
			Long time=format.parse(dateString).getTime();
			//再转换成字符串
			String str=format.format(date);
			System.out.println(str);
			clockin.setNeu_clockin_startin(time);
			clockin.setNeu_clockin_startout(time);
			
			clockin.setNeu_empno((long)2);
			
			clockin.setNeu_retroactivein(time);
			clockin.setNeu_retroactiveout(time);
			
			neu_clockindao.add(clockin, conn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
