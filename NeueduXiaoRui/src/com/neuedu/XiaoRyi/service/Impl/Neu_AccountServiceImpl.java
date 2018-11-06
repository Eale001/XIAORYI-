package com.neuedu.XiaoRyi.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.Dao.Neu_AccountDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Account;
import com.neuedu.XiaoRyi.service.Neu_AccountService;

public class Neu_AccountServiceImpl implements Neu_AccountService {
	
	Neu_AccountDao neu_accountdao=(Neu_AccountDao) FactoryUtil.getInstanceObjectByName("Neu_AccountDao");
	
	@Override
	public Optional<Neu_Account> login(String account, String pwd) {
		Connection conn =DBUtil.getOracleConnection();
		try {
			conn.setAutoCommit(false);
			Neu_Account manager=new Neu_Account();
			manager.setNei_empno(Long.parseLong(account));
			manager.setNeu_pwd(pwd);
			
			List<Neu_Account> list= neu_accountdao.findByExample(manager, conn);
			if(list.size()>0) {
				conn.commit();
				return Optional.of(list.get(0));
			}else {
				conn.rollback();
				return Optional.empty();
			}
			
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void register(Neu_Account acount) {
		Connection conn =DBUtil.getOracleConnection();
		try {
			conn.setAutoCommit(false);
			neu_accountdao.add(acount, conn);
			conn.commit();
			
		}catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	@Override
	public void update(Neu_Account account) {
		Connection conn =DBUtil.getOracleConnection();
		try {
			conn.setAutoCommit(false);
			neu_accountdao.update(account, conn);
			conn.commit();
		}catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean delete(long id) {
		Connection conn =DBUtil.getOracleConnection();
		try {
			conn.setAutoCommit(false);
			neu_accountdao.delete(id, conn);
			conn.commit();
			return true;
		}catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Optional<Neu_Account> findById(long id) {
		Connection conn =DBUtil.getOracleConnection();
		
		return neu_accountdao.findById(id, conn);
			
	}

	@Override
	public List<Neu_Account> findByExample(Neu_Account acount) {
		Connection conn =DBUtil.getOracleConnection();
		
		return neu_accountdao.findByExample(acount, conn);
		
	}

	@Override
	public List<Neu_Account> findAll() {
		Connection conn =DBUtil.getOracleConnection();
		
		return neu_accountdao.findAll(conn);
	}

	@Override
	public List<Neu_Account> findPage(String page, String total) {
		Connection conn =DBUtil.getOracleConnection();
		Integer p=Integer.parseInt(page);
		Integer t=Integer.parseInt(total);
		return neu_accountdao.findByPage(p, t, conn);
	}

}
