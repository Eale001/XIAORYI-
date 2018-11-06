package com.neuedu.XiaoRyi.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.Dao.Neu_EmpDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Account;
import com.neuedu.XiaoRyi.entity.Neu_Emp;
import com.neuedu.XiaoRyi.service.Neu_EmpService;

public class Neu_EmpServiceImpl implements Neu_EmpService {
	
	private Neu_EmpDao neu_empdao=(Neu_EmpDao) FactoryUtil.getInstanceObjectByName("Neu_EmpDao");
	
	@Override
	public Optional<Neu_Account> login(String name, String pwd) {
		
		return null;
	}

	@Override
	public void add(Neu_Emp emp) {
		Connection conn=DBUtil.getOracleConnection();
		
		try {
			conn.setAutoCommit(false);
			neu_empdao.add(emp, conn);
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void update(Neu_Emp emp) {
		Connection conn=DBUtil.getOracleConnection();
		
		try {
			conn.setAutoCommit(false);
			neu_empdao.update(emp, conn);
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	@Override
	public void deleted(Long id) {
		Connection conn=DBUtil.getOracleConnection();
		
		try {
			conn.setAutoCommit(false);
			neu_empdao.delete(id, conn);
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	@Override
	public Optional<Neu_Emp> findById(Long id) {
		Connection conn=DBUtil.getOracleConnection();
		
		return neu_empdao.findById(id, conn);
	}

	@Override
	public List<Neu_Emp> findByExample(Neu_Emp emp) {
		Connection conn=DBUtil.getOracleConnection();
		
		return neu_empdao.findByExample(emp, conn);
	}

	@Override
	public List<Neu_Emp> findAll() {
		Connection conn=DBUtil.getOracleConnection();
		
		return neu_empdao.findAll(conn);
	}

	@Override
	public List<Neu_Emp> findByPage(String page, String total) {
		Connection conn =DBUtil.getOracleConnection();
		Integer p=Integer.parseInt(page);
		Integer t=Integer.parseInt(total);
		return neu_empdao.findByPage(p, t, conn);
	}

}
