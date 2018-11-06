package com.neuedu.dao.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

public class Timetest {
	@Test
	public void timetest2() {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String t1="2018-10-01";
		String t2="2018-10-31";
		try {
			Date d1=format.parse(t1);
			Date d2=format.parse(t2);
			System.out.println(d1);
			System.out.println(d2);
			System.out.println((d2.getTime()-d1.getTime())/(24*60*60*1000));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void timetest1() throws ParseException {
		
        
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
	}
}
