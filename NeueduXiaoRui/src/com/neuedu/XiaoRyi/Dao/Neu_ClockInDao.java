package com.neuedu.XiaoRyi.Dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.entity.Neu_CLOCKIN;

/**
 * dao层 操作
 * 
 * @author Administrator
 *
 */
public interface Neu_ClockInDao {

	/**
	 * 增加
	 * 
	 * @param user
	 * @param conn
	 */
	void add(Neu_CLOCKIN clockin, Connection conn);

	/**
	 * 删除
	 * 
	 * @param neu_id
	 * @param conn
	 */
	void delete(Long clock_id, Connection conn);

	/**
	 * 修改
	 * 
	 * @param user
	 * @param conn
	 */
	void update(Neu_CLOCKIN clockin, Connection conn);

	/**
	 * 根据Id查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	Optional<Neu_CLOCKIN> findById(Long clock_id, Connection conn);

	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_CLOCKIN> findAll(Connection conn);

	/**
	 * 根据实例查询相似
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_CLOCKIN> findByExample(Neu_CLOCKIN clockin, Connection conn);

	/**
	 * 分页查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_CLOCKIN> findByPage(int page, int total, Connection conn);

}
