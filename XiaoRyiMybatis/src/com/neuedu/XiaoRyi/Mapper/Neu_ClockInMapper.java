package com.neuedu.XiaoRyi.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.XiaoRyi.pojo.Neu_CLOCKIN;


/**
 * dao层 操作
 * 
 * @author Administrator
 *
 */
public interface Neu_ClockInMapper {

	/**
	 * 增加
	 * 
	 * @param user
	 * @param conn
	 */
	void add(Neu_CLOCKIN clockin);

	/**
	 * 删除
	 * 
	 * @param neu_id
	 * @param conn
	 */
	void delete(Long clock_id);

	/**
	 * 修改
	 * 
	 * @param user
	 * @param conn
	 */
	void update(Neu_CLOCKIN clockin);

	/**
	 * 根据Id查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	Neu_CLOCKIN findById(Long clock_id);

	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_CLOCKIN> findAll();

	/**
	 * 根据实例查询相似
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_CLOCKIN> findByExample(Neu_CLOCKIN clockin);

	/**
	 * 分页查询
	 * 
	 * @param user
	 * @param conn
	 * @return
	 */
	List<Neu_CLOCKIN> findByPage(@Param("page")int page,@Param("total") int total);

}
