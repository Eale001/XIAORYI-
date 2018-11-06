package com.neuedu.XiaoRyi.service;

import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.entity.Neu_Account;

/**
 * service-事务管理
 * @author Administrator
 *
 */
public interface Neu_AccountService {
	
	/**
	 * 用户登录
	 * 登录成功返回user，否则返回空集合
	 * @param name（用姓名登录）
	 * @param pwd
	 * @return
	 */
	Optional<Neu_Account> login(String account,String pwd);
	
	/**
	 * 管理员注册
	 * @param user
	 */
	void register(Neu_Account acount);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void update(Neu_Account account);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	
	/**
	 * 查找用户
	 * @param id
	 * @return
	 */
	Optional<Neu_Account> findById(long id);
	
	/**
	 * 根据实例查找用户
	 * @param user
	 * @return
	 */
	List<Neu_Account> findByExample(Neu_Account acount);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<Neu_Account> findAll();
	
	/**
	 * 分页查询
	 * @return
	 */
	List<Neu_Account> findPage(String page,String total);
}
