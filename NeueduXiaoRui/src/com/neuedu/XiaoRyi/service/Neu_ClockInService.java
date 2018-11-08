package com.neuedu.XiaoRyi.service;


import java.util.List;
import java.util.Optional;


import com.neuedu.XiaoRyi.pojo.Neu_CLOCKIN;


/**
 * 事务层  --事务管理
 * @author Administrator
 *
 */

public interface Neu_ClockInService {
	
	/**
	 * 添加 一个 打卡事件
	 * @param clockin
	 */
	void add(Neu_CLOCKIN clockin);
	
	/**
	 * 修改一个打卡事件(即签出事件)
	 * @param clockin
	 */
	void update(Neu_CLOCKIN clockin);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	Optional<Neu_CLOCKIN> findById(Long id);
	
	/**
	 * 根据实例查询打卡事件(即统计)
	 * @param clockin
	 * @return
	 */
	List<Neu_CLOCKIN> findByExample(Neu_CLOCKIN clockin);
	
	/**
	 * 查询所有打卡
	 * @return
	 */
	List<Neu_CLOCKIN> findAll();
	
	/**
	 * 分页查询
	 * @return
	 */
	//List<Neu_CLOCKIN> findBypage(int page,int total);
}
