package com.neuedu.XiaoRyi.Dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.entity.Neu_Ask_Leave;

public interface Neu_ask_leaveDao {
	/**
	 * 增加
	 * 
	 * @param user
	 * @param conn
	 */
	void add(Neu_Ask_Leave leave, Connection conn);

	/**
	 * 删除
	 * 
	 * @param neu_id
	 * @param conn
	 */
	void delete(Long leave_id, Connection conn);

	/**
	 * 修改
	 * 
	 * @param user
	 * @param conn
	 */
	void update(Neu_Ask_Leave leave, Connection conn);

	/**
	 * 根据Id查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	Optional<Neu_Ask_Leave> findById(Long leave_id, Connection conn);

	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Ask_Leave> findAll(Connection conn);

	/**
	 * 根据实例查询相似
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Ask_Leave> findByExample(Neu_Ask_Leave leave, Connection conn);

	/**
	 * 分页查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Ask_Leave> findByPage(int page, int total, Connection conn);

}
