package com.neuedu.XiaoRyi.Mapper;

import java.util.Optional;

import com.neuedu.XiaoRyi.pojo.StatisticWork;


/**
 * 统计分析查询
 * 实到/迟到/早退/缺勤/请假 
 * @author Administrator
 *
 */
public interface Neu_StatisticalMapper {
	
	/**
	 * 实到
	 * @return
	 */
	Optional<StatisticWork> findrealitywork(Long empno,String startin,String startout);
	
	
	/**
	 * 迟到
	 * @return
	 */
	Optional<StatisticWork> findlatework(Long empno,String startin,String startout);
	
	/**
	 * 早退
	 * @return
	 */
	Optional<StatisticWork> findearlywork(Long empno,String startin,String startout);
	
	/**
	 * 缺勤
	 * @return
	 */
	Optional<StatisticWork> findabsencework(Long empno,String startin,String startout);
	
	/**
	 * 请假
	 * @return
	 */
	Optional<StatisticWork> findaskleavework(Long empno,String startin,String startout);
}
