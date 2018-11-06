package com.neuedu.XiaoRyi.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 两个时间相减  --得到天数
 * @author Administrator
 *
 */
public class TimeMinus {
	public static int day(String startin,String startout) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date d1;
		Date d2;
		try {
			d1 = format.parse(startin);
			d2=format.parse(startout);
			Integer days=(int) ((d2.getTime()-d1.getTime())/(24*60*60*1000));
			return days;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
}
