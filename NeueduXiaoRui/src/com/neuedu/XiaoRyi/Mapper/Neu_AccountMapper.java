package com.neuedu.XiaoRyi.Mapper;

import java.util.List;


import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Account;


/**
 * Dao层  对数据库的操作
 * @author Administrator
 *
 */
public interface Neu_AccountMapper {
	
	/**
	 * 增加
	 * @param user
	 * @param conn
	 */
	void add(Neu_Account account);
	
	/**
	 * 删除
	 * @param neu_id
	 * @param conn
	 */
	void delete(Long m_id);
	
	/**
	 * 修改
	 * @param user
	 * @param conn
	 */
	void update(Neu_Account account);
	
	/**
	 * 根据Id查询
	 * @param user
	 * @param conn
	 * @return
	 */
	Neu_Account findById(Long m_id);
	
	/**
	 * 查询所有
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Account> findAll();
	
	/**
	 * 根据实例查询相似
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Account> findByExample(Neu_Account account);
	
	/**
	 * 分页查询
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Account> findByPage(Page page);
	
}
