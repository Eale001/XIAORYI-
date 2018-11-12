package com.neuedu.XiaoRyi.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Emp;


public interface Neu_EmpMapper {
	/**
	 * 增加
	 * 
	 * @param user
	 * @param conn
	 */
	void add(Neu_Emp emp);

	/**
	 * 删除
	 * 
	 * @param neu_id
	 * @param conn
	 */
	void delete(Long emp_id);

	/**
	 * 修改
	 * 
	 * @param user
	 * @param conn
	 */
	void update(Neu_Emp emp);

	/**
	 * 根据Id查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	Neu_Emp findById(Long emp_id);

	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Emp> findAll();

	/**
	 * 根据实例查询相似
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Emp> findByExample(Neu_Emp emp);

	/**
	 * 分页查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_Emp> findByPage(Page page);

}
