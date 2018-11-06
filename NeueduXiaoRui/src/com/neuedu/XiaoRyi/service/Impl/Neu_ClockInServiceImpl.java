package com.neuedu.XiaoRyi.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.Dao.Neu_ClockInDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_CLOCKIN;
import com.neuedu.XiaoRyi.service.Neu_ClockInService;

public class Neu_ClockInServiceImpl implements Neu_ClockInService {
	
	private Neu_ClockInDao neu_clockindao=(Neu_ClockInDao) FactoryUtil.getInstanceObjectByName("Neu_ClockInDao");
	
	@Override
	public void add(Neu_CLOCKIN clockin) {
		Connection conn=DBUtil.getOracleConnection();
		try {
			conn.setAutoCommit(false);
			
			neu_clockindao.add(clockin, conn);
			
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
	public void update(Neu_CLOCKIN clockin) {
		Connection conn=DBUtil.getOracleConnection();
		try {
			conn.setAutoCommit(false);
			
			neu_clockindao.update(clockin, conn);
			
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
	public Optional<Neu_CLOCKIN> findById(Long id) {
		Connection conn=DBUtil.getOracleConnection();
		
		return neu_clockindao.findById(id, conn);
	}

	@Override
	public List<Neu_CLOCKIN> findByExample(Neu_CLOCKIN clockin) {
		Connection conn=DBUtil.getOracleConnection();
		
		return neu_clockindao.findByExample(clockin, conn);
	}

	@Override
	public List<Neu_CLOCKIN> findAll() {
		Connection conn=DBUtil.getOracleConnection();
		
		return neu_clockindao.findAll(conn);
	}

}
