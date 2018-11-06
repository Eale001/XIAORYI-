//package com.neuedu.XiaoRyi.service.Impl;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//import com.neuedu.XiaoRyi.Dao.Neu_AccountDao;
//import com.neuedu.XiaoRyi.Util.DBUtil;
//import com.neuedu.XiaoRyi.Util.FactoryUtil;
//import com.neuedu.XiaoRyi.entity.Neu_Emp;
//import com.neuedu.XiaoRyi.service.Neu_AccountService;
//
//
//
//public class Neu_UserServiceImpl implements Neu_AccountService {
//
//	private Neu_AccountDao neu_userdao=(Neu_AccountDao) FactoryUtil.getInstanceObjectByName("Neu_UserDao");
//	
//	@Override
//	public Optional<Neu_Emp> login(String name, String pwd) {
//		Connection conn= DBUtil.getOracleConnection();
//		try {
//			conn.setAutoCommit(false);
//			Neu_Emp neu_user=new Neu_Emp();
//			neu_user.setNeu_name(name);
//			neu_user.setNeu_pwd(pwd);
//			List<Neu_Emp> users= neu_userdao.findByExample(neu_user, conn);
//			if(users.size()>0) {
//				conn.commit();
//				return Optional.of(users.get(0));
//			}else {
//				conn.rollback();
//				return Optional.empty();
//			}
//			
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
//
//	@Override
//	public void register(String name, String pwd) {
//		Connection conn= DBUtil.getOracleConnection();
//		try {
//			conn.setAutoCommit(false);
//			
//			Neu_Emp neu_user=new Neu_Emp();
//			neu_user.setNeu_name(name);
//			neu_user.setNeu_pwd(pwd);
//			
//			neu_userdao.add(neu_user, conn);
//			conn.commit();
//			
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//
//	}
//
//	@Override
//	public void register(Neu_Emp user) {
//		Connection conn= DBUtil.getOracleConnection();
//		try {
//			conn.setAutoCommit(false);
//			neu_userdao.add(user, conn);
//			conn.commit();
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//
//	}
//
//	@Override
//	public void update(Neu_Emp user) {
//		Connection conn= DBUtil.getOracleConnection();
//		try {
//			conn.setAutoCommit(false);
//			neu_userdao.update(user, conn);
//			conn.commit();
//			
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//
//	}
//
//	@Override
//	public boolean delete(long id) {
//		Connection conn= DBUtil.getOracleConnection();
//		try {
//			conn.setAutoCommit(false);
//			neu_userdao.delete(id, conn);
//			
//			conn.commit();
//			return true;
//			
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			throw new RuntimeException();
//			
//		}
//	}
//
//	@Override
//	public Optional<Neu_Emp> findById(long id) {
//		Connection conn= DBUtil.getOracleConnection();
//		try {
//			conn.setAutoCommit(false);
//			
//			Optional<Neu_Emp> user= neu_userdao.findById(id, conn);
//			if(user.isPresent()) {
//				conn.commit();
//				return user;
//			}else {
//				conn.rollback();
//				return Optional.empty();
//			}
//			
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
//
//	@Override
//	public List<Neu_Emp> findByExample(Neu_Emp user) {
//		Connection conn= DBUtil.getOracleConnection();
//		try {
//			conn.setAutoCommit(false);
//			
//			List<Neu_Emp> list= neu_userdao.findByExample(user, conn);
//			if(list.size()>0) {
//				conn.commit();
//				return list;
//			}else {
//				conn.rollback();
//				return null;
//			}
//			
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
//
//	@Override
//	public List<Neu_Emp> findAll() {
//		Connection conn= DBUtil.getOracleConnection();
//		try {
//			conn.setAutoCommit(false);
//			
//			List<Neu_Emp> list= neu_userdao.findAll(conn);
//			if(list.size()>0) {
//				conn.commit();
//				return list;
//			}else {
//				conn.rollback();
//				return null;
//			}
//			
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
//
//	@Override
//	public List<Neu_Emp> findPage(int page,int total) {
//		Connection conn= DBUtil.getOracleConnection();
//		try {
//			conn.setAutoCommit(false);
//			
//			List<Neu_Emp> list= neu_userdao.findByPage(page,total,conn);
//			if(list.size()>0) {
//				conn.commit();
//				return list;
//			}else {
//				conn.rollback();
//				return null;
//			}
//			
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
//
//}
