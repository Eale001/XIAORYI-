package com.neuedu.XiaoRyi.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.XiaoRyi.Dao.Neu_ask_leaveDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

public class Neu_ask_leaveServiceImpl implements Neu_ask_leaveService {
	
	private Neu_ask_leaveDao neu_ask_leavedao=(Neu_ask_leaveDao) FactoryUtil.getInstanceObjectByName("Neu_ask_leaveDao");
	
	@Override
	public void add(Neu_Ask_Leave leave) {
		Connection conn=DBUtil.getOracleConnection();
		try {
			conn.setAutoCommit(false);
			neu_ask_leavedao.add(leave, conn);
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
	public boolean deleted(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Neu_Ask_Leave leave) {
		Connection conn=DBUtil.getOracleConnection();
		try {
			conn.setAutoCommit(false);
			neu_ask_leavedao.update(leave, conn);
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
	public List<Neu_Ask_Leave> findByExample(Neu_Ask_Leave leave) {
		Connection conn=DBUtil.getOracleConnection();
		
		return neu_ask_leavedao.findByExample(leave, conn);
	}

	@Override
	public List<Neu_Ask_Leave> findAll() {
		Connection conn=DBUtil.getOracleConnection();
		
		return neu_ask_leavedao.findAll(conn);
	}

	@Override
	public List<Neu_Ask_Leave> findByPage(int page, int total) {
		// TODO Auto-generated method stub
		return null;
	}

}
