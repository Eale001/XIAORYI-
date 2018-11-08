package com.neuedu.XiaoRyi.service.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.Dao.Neu_StatisticalDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.StatisticWork;
import com.neuedu.XiaoRyi.pojo.Neu_Emp;
import com.neuedu.XiaoRyi.service.Neu_EmpService;
import com.neuedu.XiaoRyi.service.Neu_StatisticService;

public class Neu_StatisticServiceImpl implements Neu_StatisticService {
	
	private Neu_StatisticalDao neu_statisticaldao=(Neu_StatisticalDao) FactoryUtil.getInstanceObjectByName("Neu_StatisticalDao");
	private Neu_EmpService neu_empservice=(Neu_EmpService) FactoryUtil.getInstanceObjectByName("Neu_EmpService");
	
	@Override
	public List<StatisticWork> findAll(String startin, String startout) {
		Connection conn=DBUtil.getOracleConnection();
		List<StatisticWork> list=new ArrayList<>();
		
		List<Neu_Emp> list1 =neu_empservice.findAll();
		for (Neu_Emp neu_Emp : list1) {
			Long emp=neu_Emp.getNeu_empno();
			Optional<StatisticWork> opt1=neu_statisticaldao.findrealitywork(emp, startin, startout, conn);
			Optional<StatisticWork> opt2=neu_statisticaldao.findabsencework(emp, startin, startout, conn);
			StatisticWork stwork=new StatisticWork();
			Integer needwork=com.neuedu.XiaoRyi.Util.TimeMinus.day(startin,startout);
			stwork.setNeedwork(needwork);
			stwork.setEmpno(emp);
			stwork.setRealitywork(opt1.get().getRealitywork());
			stwork.setAbsencework(opt2.get().getAbsencework());
			list.add(stwork);
			
		}
		return list;
	}

	@Override
	public Optional<StatisticWork> findbyEmpno(Long empno, String startin, String startout) {
		Connection conn=DBUtil.getOracleConnection();
		
		Optional<StatisticWork> opt=Optional.empty();
		
		Optional<StatisticWork> opt1=neu_statisticaldao.findrealitywork(empno, startin, startout, conn);
		Optional<StatisticWork> opt2=neu_statisticaldao.findabsencework(empno, startin, startout, conn);
		
		StatisticWork stwork=new StatisticWork();
		Integer needwork=com.neuedu.XiaoRyi.Util.TimeMinus.day(startin,startout);
		stwork.setNeedwork(needwork);
		stwork.setEmpno(empno);
		stwork.setRealitywork(opt1.get().getRealitywork());
		stwork.setAbsencework(opt2.get().getAbsencework());
		
		opt=Optional.of(stwork);
		
		return opt;
	}

}
