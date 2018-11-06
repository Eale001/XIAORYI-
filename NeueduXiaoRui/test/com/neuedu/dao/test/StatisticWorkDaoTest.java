package com.neuedu.dao.test;

import java.sql.Connection;
import java.util.Optional;

import org.junit.Test;

import com.neuedu.XiaoRyi.Dao.Impl.Neu_StatisticalDaoImpl;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.entity.StatisticWork;


public class StatisticWorkDaoTest {
	@Test
	public void findreal1() {
		Connection conn=DBUtil.getOracleConnection();
		Neu_StatisticalDaoImpl neu_statisticaldaoimpl=new Neu_StatisticalDaoImpl();
		Optional<StatisticWork> opt=neu_statisticaldaoimpl.findrealitywork((long)2, null,null , conn);
		System.out.println(opt.get().getRealitywork());
		
	}
	
	@Test
	public void findreal() {
		Connection conn=DBUtil.getOracleConnection();
		Neu_StatisticalDaoImpl neu_statisticaldaoimpl=new Neu_StatisticalDaoImpl();
		Optional<StatisticWork> opt=neu_statisticaldaoimpl.findrealitywork((long)2, "2018-10-01 08:00:00", "2018-10-31 08:00:00", conn);
		System.out.println(opt.get().getRealitywork());
		
	}
}
