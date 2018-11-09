package com.neuedu.XiaoRyi.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;


public interface Neu_ask_leaveMapper {
	/**
	 * 增加
	 * 
	 * @param user
	 * @param conn
	 */
	void add(Neu_Ask_Leave leave);

	/**
	 * 删除
	 * 
	 * @param neu_id
	 * @param conn
	 */
	void delete(Long leave_id);

	/**
	 * 修改
	 * 
	 * @param user
	 * @param conn
	 */
	void update(Neu_Ask_Leave leave);

	/**
	 * 根据Id查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	Neu_Ask_Leave findById(Long leave_id);

	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Ask_Leave> findAll();

	/**
	 * 根据实例查询相似
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Ask_Leave> findByExample(Neu_Ask_Leave leave);

	/**
	 * 分页查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Ask_Leave> findByPage(@Param("page")int page,@Param("total") int total);

}
