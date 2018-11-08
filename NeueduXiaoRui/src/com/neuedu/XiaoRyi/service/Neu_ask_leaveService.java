package com.neuedu.XiaoRyi.service;

import java.util.List;

import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;


/**
 * 事务层 -- 管理事务
 * @author Administrator
 *
 */
public interface Neu_ask_leaveService {
	
	/**
	 * 添加一个请假事件
	 * @param leave
	 */
	void add(Neu_Ask_Leave leave);
	
	/**
	 * 删除某个请假事件
	 * @param id
	 * @return
	 */
	boolean deleted(Long id);
	
	/**
	 * 修改一个请假事件(即准驳)
	 * @param leave
	 */
	void update(Neu_Ask_Leave leave);
	
	/**
	 * 根据实例查询请假事件
	 * @param leave
	 * @return
	 */
	List<Neu_Ask_Leave> findByExample(Neu_Ask_Leave leave);
	
	/**
	 * 查询所有请假事件
	 * @return
	 */
	List<Neu_Ask_Leave> findAll();
	
	/**
	 * 分页查询
	 * @param page
	 * @param total
	 * @return
	 */
	List<Neu_Ask_Leave> findByPage(int page,int total);
}
