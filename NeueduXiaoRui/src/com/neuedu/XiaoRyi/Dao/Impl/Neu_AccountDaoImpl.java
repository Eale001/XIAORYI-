package com.neuedu.XiaoRyi.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.Dao.Neu_AccountDao;
import com.neuedu.XiaoRyi.entity.Neu_Account;

public class Neu_AccountDaoImpl implements Neu_AccountDao {

	@Override
	public void add(Neu_Account account, Connection conn) {
		Statement st=null;
		try {
			st=conn.createStatement();
			
			String sql="INSERT INTO NEU_ACCOUNT (M_ID,$keys) VALUES (SQ_NEU_ACCOUNT_ID.nextval,$values) ";
			
			String keys="";
			String values="";
			
			//拼接字符串

			if(null!=account.getNei_empno()) {
				keys+=" NEU_EMPNO,";
				values+=" '"+account.getNei_empno()+"',";
			}
			
			if(null!=account.getNeu_pwd()) {
				keys+=" NEU_PWD,";
				values+=" '"+account.getNeu_pwd()+"',";
			}
			
			if(null!=account.getNeu_power_level()) {
				keys+=" NEU_POWER_LEVEL,";
				values+=" '"+account.getNeu_power_level()+"',";
			}
			
			
			keys=keys.substring(0, keys.length()-1);
			values=values.substring(0, values.length()-1);
			sql=sql.replace("$keys", keys).replace("$values", values);
			System.out.println(sql);
			int num=st.executeUpdate(sql);
			if(1!=num) {
				throw new RuntimeException("受影响行数不为1");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public void delete(Long m_id, Connection conn) {
		PreparedStatement ps=null;
		try {
			String sql="DELETE NEU_ACCOUNT WHERE M_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setLong(1, m_id);
			int num=ps.executeUpdate();
			
			if(1!=num) {
				throw new RuntimeException("受影响行数不为1");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public void update(Neu_Account account, Connection conn) {
		Statement st=null;
		try {
			st=conn.createStatement();
			
			String sql="UPDATE NEU_ACCOUNT SET $list WHERE M_ID="+account.getM_id();
			
			String list="";
			
			//拼接字符串
			if(null!=account.getNei_empno()) {
				list+=" NEU_EMPNO='"+account.getNei_empno()+"',";
			}
			
			if(null!=account.getNeu_pwd()) {
				list+=" NEU_PWD='"+account.getNeu_pwd()+"',";
			}
			
			if(null!=account.getNeu_power_level()) {
				list+=" NEU_POWER_LEVEL='"+account.getNeu_power_level()+"',";
			}
				
			list=list.substring(0, list.length()-1);
			sql=sql.replace("$list", list);
			
			int num=st.executeUpdate(sql);
			if(1!=num) {
				throw new RuntimeException("受影响行数不为1");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public Optional<Neu_Account> findById(Long m_id, Connection conn) {
		Optional<Neu_Account> opt=Optional.empty();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT M_ID,NEU_EMPNO,NEU_PWD,NEU_POWER_LEVEL FROM NEU_ACCOUNT WHERE M_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, m_id);
			rs=ps.executeQuery();
			if(rs.next()) {
				Neu_Account account=new Neu_Account();
				
				Long id=rs.getLong("M_ID");
				account.setM_id(id);
				
				Long empno=rs.getLong("NEU_EMPNO");
				account.setNei_empno(empno);
						
				String pwd=rs.getString("NEU_PWD");
				account.setNeu_pwd(pwd);
				
				Long neu_level=rs.getLong("NEU_POWER_LEVEL");
				account.setNeu_power_level(neu_level);
				
				opt=Optional.of(account);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return opt;
	}

	@Override
	public List<Neu_Account> findAll(Connection conn) {
		List<Neu_Account> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT M_ID,NEU_EMPNO,NEU_PWD,NEU_POWER_LEVEL FROM NEU_ACCOUNT";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Neu_Account account=new Neu_Account();
				
				Long id=rs.getLong("M_ID");
				account.setM_id(id);
				
				Long empno=rs.getLong("NEU_EMPNO");
				account.setNei_empno(empno);
						
				String pwd=rs.getString("NEU_PWD");
				account.setNeu_pwd(pwd);
				
				Long neu_level=rs.getLong("NEU_POWER_LEVEL");
				account.setNeu_power_level(neu_level);			
				
				list.add(account);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return list;
	}

	@Override
	public List<Neu_Account> findByExample(Neu_Account _account, Connection conn) {
		List<Neu_Account> list=new ArrayList<>();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			
			String sql="SELECT M_ID,NEU_EMPNO,NEU_PWD,NEU_POWER_LEVEL FROM NEU_ACCOUNT WHERE 1=1 ";
			
			//拼接字符串
			
			
			if(null!=_account.getM_id()) {
				sql+=" AND M_ID='"+_account.getM_id()+"'";
			}
			
			if(null!=_account.getNei_empno()) {
				sql+=" AND NEU_EMPNO='"+_account.getNei_empno()+"'";
			}
			
			if(null!=_account.getNeu_pwd()) {
				sql+=" AND NEU_PWD='"+_account.getNeu_pwd()+"'";
			}
			
			if(null!=_account.getNeu_power_level()) {
				sql+=" AND NEU_POWER_LEVEL='"+_account.getNeu_power_level()+"'";
			}
			
			System.out.println(sql);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Neu_Account account=new Neu_Account();
				
				Long id=rs.getLong("M_ID");
				account.setM_id(id);
				
				Long empno=rs.getLong("NEU_EMPNO");
				account.setNei_empno(empno);
						
				String pwd=rs.getString("NEU_PWD");
				account.setNeu_pwd(pwd);
				
				Long neu_level=rs.getLong("NEU_POWER_LEVEL");
				account.setNeu_power_level(neu_level);			
				
				list.add(account);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}

	@Override
	public List<Neu_Account> findByPage(int page,int total, Connection conn) {
		List<Neu_Account> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT RN,M_ID,NEU_EMPNO,NEU_PWD,NEU_POWER_LEVEL " + 
					"FROM (SELECT ROWNUM RN,M_ID,NEU_EMPNO,NEU_PWD,NEU_POWER_LEVEL FROM NEU_ACCOUNT WHERE ROWNUM<=?) " + 
					"WHERE RN>=?";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, page*total);
			ps.setLong(2, (page-1)*total);
			rs=ps.executeQuery();
			while(rs.next()) {
				Neu_Account account=new Neu_Account();
				
				Long id=rs.getLong("M_ID");
				account.setM_id(id);
				
				Long empno=rs.getLong("NEU_EMPNO");
				account.setNei_empno(empno);
						
				String pwd=rs.getString("NEU_PWD");
				account.setNeu_pwd(pwd);
				
				Long neu_level=rs.getLong("NEU_POWER_LEVEL");
				account.setNeu_power_level(neu_level);			
				
				list.add(account);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}

	
}
