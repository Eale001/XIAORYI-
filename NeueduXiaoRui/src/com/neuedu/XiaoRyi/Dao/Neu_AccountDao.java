package com.neuedu.XiaoRyi.Dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.entity.Neu_Account;

/**
 * Dao层  对数据库的操作
 * @author Administrator
 *
 */
public interface Neu_AccountDao {
	
	/**
	 * 增加
	 * @param user
	 * @param conn
	 */
	void add(Neu_Account account,Connection conn);
	
	/**
	 * 删除
	 * @param neu_id
	 * @param conn
	 */
	void delete(Long m_id,Connection conn);
	
	/**
	 * 修改
	 * @param user
	 * @param conn
	 */
	void update(Neu_Account account,Connection conn);
	
	/**
	 * 根据Id查询
	 * @param user
	 * @param conn
	 * @return
	 */
	Optional<Neu_Account> findById(Long m_id,Connection conn);
	
	/**
	 * 查询所有
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Account> findAll(Connection conn);
	
	/**
	 * 根据实例查询相似
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Account> findByExample(Neu_Account account,Connection conn);
	
	/**
	 * 分页查询
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Account> findByPage(int page,int total,Connection conn);
	
}
