package com.neuedu.XiaoRyi.service;

import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Account;
import com.neuedu.XiaoRyi.pojo.Neu_Emp;


/**
 * 事务层 -- 事务管理
 * @author Administrator
 *
 */
public interface Neu_EmpService {
	
	/**
	 * 用户登录
	 * @param name
	 * @param pwd
	 * @return
	 */
	Optional<Neu_Account> login(String name,String pwd);
	
	/**
	 * 添加一个员工
	 * @param emp
	 */
	void add(Neu_Emp emp);
	
	/**
	 * 修改一个员
	 * @param emp
	 */
	void update(Neu_Emp emp);
	
	/**
	 * 删除一个员工
	 * @param id
	 */
	void deleted(Long id);
	
	/**
	 * 根据ID查询员工
	 * @param id
	 * @return
	 */
	Optional<Neu_Emp> findById(Long id);
	
	/**
	 * 根据实例查询员工(部门)
	 * @param emp
	 * @return
	 */
	List<Neu_Emp> findByExample(Neu_Emp emp);
	
	/**
	 * 查询所有员工
	 * @return
	 */
	List<Neu_Emp> findAll();
	
	/**
	 * 分页查询
	 * @return
	 */
	List<Neu_Emp> findByPage(Page page);
	
}
