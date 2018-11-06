package com.neuedu.XiaoRyi.service;

import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.entity.StatisticWork;

/**
 * 事务层--统计分析的事务层
 * @author Administrator
 *
 */
public interface Neu_StatisticService {
	
	/**
	 * 查询所有员工的出勤情况
	 * @return
	 */
	List<StatisticWork> findAll(String startin,String startout);
	
	/**
	 * 查询个人的出勤情况
	 * @return
	 */
	Optional<StatisticWork> findbyEmpno(Long empno,String startin,String startout);
	
}
