package com.neuedu.XiaoRyi.Dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.entity.Neu_Emp;

public interface Neu_EmpDao {
	/**
	 * 增加
	 * 
	 * @param user
	 * @param conn
	 */
	void add(Neu_Emp emp, Connection conn);

	/**
	 * 删除
	 * 
	 * @param neu_id
	 * @param conn
	 */
	void delete(Long emp_id, Connection conn);

	/**
	 * 修改
	 * 
	 * @param user
	 * @param conn
	 */
	void update(Neu_Emp emp, Connection conn);

	/**
	 * 根据Id查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	Optional<Neu_Emp> findById(Long emp_id, Connection conn);

	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Emp> findAll(Connection conn);

	/**
	 * 根据实例查询相似
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Emp> findByExample(Neu_Emp emp, Connection conn);

	/**
	 * 分页查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Emp> findByPage(int page, int total, Connection conn);

}
