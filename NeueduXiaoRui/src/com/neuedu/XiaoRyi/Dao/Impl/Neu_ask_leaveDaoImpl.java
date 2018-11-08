package com.neuedu.XiaoRyi.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.Dao.Neu_ask_leaveDao;
import com.neuedu.XiaoRyi.entity.Neu_Ask_Leave;

public class Neu_ask_leaveDaoImpl implements Neu_ask_leaveDao {

	@Override
	public void add(Neu_Ask_Leave leave, Connection conn) {
		Statement st=null;
		try {
			st=conn.createStatement();
			
			String sql="INSERT INTO NEU_ASK_LEAVE ( ASK_LEAVE_ID,$keys) VALUES (SQ_NEU_ASK_LEAVE_ID.nextval,$values) ";
			
			String keys="";
			String values="";
			
			//拼接字符串
			
			DateFormat format=  new SimpleDateFormat("yyyy-MM-dd ");
			
			if(null!=leave.getAsk_leave_begin()) {
				keys+=" ASK_LEAVE_TIME_BEGIN,";
				
				String leave_begin = format.format(leave.getAsk_leave_begin());
				values+=" TO_TIMESTAMP('"+leave_begin+"','yyyy-MM-dd '),";
				
			}
			
			if(null!=leave.getAsk_leave_end()) {
				keys+=" ASK_LEAVE_TIME_END,";
				String leave_end = format.format(leave.getAsk_leave_end());
				values+=" TO_TIMESTAMP('"+leave_end+"','yyyy-MM-dd'),";
			}
			
			if(null!=leave.getAsk_leave_type()) {
				keys+=" ASK_LEAVE_TYPE,";
				values+=" '"+leave.getAsk_leave_type()+"',";
			}
			
			if(null!=leave.getAsk_leave_reason()) {
				keys+=" ASK_LEAVE_REASON,";
				values+=" '"+leave.getAsk_leave_reason()+"',";
			}
			
			if(null!=leave.getAsk_leave_accept()) {
				keys+=" ASK_LEAVE_ACCEPT,";
				values+=" '"+leave.getAsk_leave_accept()+"',";
			}
			
			if(null!=leave.getM_id()) {
				keys+=" M_ID,";
				values+=" '"+leave.getM_id()+"',";
			}
			
			if(null!=leave.getEmpno()) {
				keys+=" EMPNO,";
				values+=" '"+leave.getEmpno()+"',";
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
	public void delete(Long leave_id, Connection conn) {
		PreparedStatement ps=null;
		try {
			String sql="DELETE NEU_ASK_LEAVE WHERE  ASK_LEAVE_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setLong(1, leave_id);
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
	public void update(Neu_Ask_Leave leave, Connection conn) {
		Statement st=null;
		try {
			st=conn.createStatement();
			
			String sql="UPDATE NEU_ASK_LEAVE SET $list WHERE ASK_LEAVE_ID="+leave.getAsk_leave_id();
			
			String list="";
			
			//拼接字符串
			DateFormat format=  new SimpleDateFormat("yyyy-MM-dd ");

			if(null!=leave.getAsk_leave_begin()) {
				
				String leave_begin = format.format(leave.getAsk_leave_begin());
				list+=" ASK_LEAVE_TIME_BEGIN= TO_TIMESTAMP('"+leave_begin+"','yyyy-MM-dd'),";
			}
			
			if(null!=leave.getAsk_leave_end()) {
				String leave_end = format.format(leave.getAsk_leave_end());
				list+=" ASK_LEAVE_TIME_END= TO_TIMESTAMP('"+leave_end+"','yyyy-MM-dd'),";
				
			}
			
			if(null!=leave.getAsk_leave_type()) {
				list+=" ASK_LEAVE_TYPE='"+leave.getAsk_leave_type()+"',";
			}
			
			if(null!=leave.getAsk_leave_reason()) {
				list+=" ASK_LEAVE_REASON='"+leave.getAsk_leave_reason()+"',";
			}
			
			if(null!=leave.getAsk_leave_accept()) {
				list+=" ASK_LEAVE_ACCEPT='"+leave.getAsk_leave_accept()+"',";
			}
			
			if(null!=leave.getM_id()) {
				list+=" M_ID='"+leave.getM_id()+"',";
			}
			
			if(null!=leave.getEmpno()) {
				list+=" EMPNO='"+leave.getEmpno()+"',";
			}
			
			
			list=list.substring(0, list.length()-1);
			sql=sql.replace("$list", list);
			
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
	public Optional<Neu_Ask_Leave> findById(Long leave_id, Connection conn) {
		Optional<Neu_Ask_Leave> opt=Optional.empty();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT ASK_LEAVE_ID,ASK_LEAVE_TIME_BEGIN,ASK_LEAVE_TIME_END,ASK_LEAVE_TYPE,ASK_LEAVE_REASON,ASK_LEAVE_ACCEPT,M_ID,EMPNO FROM NEU_ASK_LEAVE WHERE ASK_LEAVE_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, leave_id);
			rs=ps.executeQuery();
			if(rs.next()) {
				Neu_Ask_Leave leave=new Neu_Ask_Leave();
				
				Long id=rs.getLong("ASK_LEAVE_ID");
				leave.setAsk_leave_id(id);
				
				Timestamp leave_begin=rs.getTimestamp("ASK_LEAVE_TIME_BEGIN");
				if(null!=leave_begin) leave.setAsk_leave_begin(leave_begin.getTime());
						
				Timestamp leave_end=rs.getTimestamp("ASK_LEAVE_TIME_END");
				if(null!=leave_end) leave.setAsk_leave_end(leave_end.getTime());
				
				String leave_type=rs.getString("ASK_LEAVE_TYPE");
				leave.setAsk_leave_type(leave_type);
						
				String leave_reason=rs.getString("ASK_LEAVE_REASON");
				leave.setAsk_leave_reason(leave_reason);
				
				Long neu_accept=rs.getLong("ASK_LEAVE_ACCEPT");
				leave.setAsk_leave_accept(neu_accept);
				
				Long m_id=rs.getLong("M_ID");
				leave.setM_id(m_id);
				
				Long empno=rs.getLong("EMPNO");
				leave.setEmpno(empno);
				
				
				opt=Optional.of(leave);
				
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
	public List<Neu_Ask_Leave> findAll(Connection conn) {
		List<Neu_Ask_Leave> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT ASK_LEAVE_ID,ASK_LEAVE_TIME_BEGIN,ASK_LEAVE_TIME_END,ASK_LEAVE_TYPE,ASK_LEAVE_REASON,ASK_LEAVE_ACCEPT,M_ID,EMPNO FROM NEU_ASK_LEAVE ";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Neu_Ask_Leave leave=new Neu_Ask_Leave();
				
				Long id=rs.getLong("ASK_LEAVE_ID");
				leave.setAsk_leave_id(id);
				
				Timestamp leave_begin=rs.getTimestamp("ASK_LEAVE_TIME_BEGIN");
				if(null!=leave_begin) leave.setAsk_leave_begin(leave_begin.getTime());
						
				Timestamp leave_end=rs.getTimestamp("ASK_LEAVE_TIME_END");
				if(null!=leave_end) leave.setAsk_leave_end(leave_end.getTime());
				
				String leave_type=rs.getString("ASK_LEAVE_TYPE");
				leave.setAsk_leave_type(leave_type);
						
				String leave_reason=rs.getString("ASK_LEAVE_REASON");
				leave.setAsk_leave_reason(leave_reason);
				
				Long neu_accept=rs.getLong("ASK_LEAVE_ACCEPT");
				leave.setAsk_leave_accept(neu_accept);
				
				Long m_id=rs.getLong("M_ID");
				leave.setM_id(m_id);
				
				Long empno=rs.getLong("EMPNO");
				leave.setEmpno(empno);
				
				list.add(leave);
				
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
	public List<Neu_Ask_Leave> findByExample(Neu_Ask_Leave _leave, Connection conn) {
		List<Neu_Ask_Leave> list=new ArrayList<>();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			String sql="SELECT ASK_LEAVE_ID,ASK_LEAVE_TIME_BEGIN,ASK_LEAVE_TIME_END,ASK_LEAVE_TYPE,ASK_LEAVE_REASON,ASK_LEAVE_ACCEPT,M_ID,EMPNO FROM NEU_ASK_LEAVE WHERE 1=1  ";
			
			DateFormat format=  new SimpleDateFormat("yyyy-MM-dd ");
			
			if(null!=_leave.getAsk_leave_id()) {
				sql+=" AND ASK_LEAVE_ID='"+_leave.getAsk_leave_id()+"'";
			}
			
			if(null!=_leave.getAsk_leave_begin()) {
				
				String leave_begin = format.format(_leave.getAsk_leave_begin());
				sql+=" AND ASK_LEAVE_TIME_BEGIN= TO_TIMESTAMP('"+leave_begin+"','yyyy-MM-dd')";
			}
			
			if(null!=_leave.getAsk_leave_end()) {
				String leave_end = format.format(_leave.getAsk_leave_end());
				sql+=" AND ASK_LEAVE_TIME_END= TO_TIMESTAMP('"+leave_end+"','yyyy-MM-dd')";
			}
			
			if(null!=_leave.getAsk_leave_type()) {
				sql+=" AND ASK_LEAVE_TYPE='"+_leave.getAsk_leave_type()+"'";
			}
			
			if(null!=_leave.getAsk_leave_reason()) {
				sql+=" AND ASK_LEAVE_REASON='"+_leave.getAsk_leave_reason()+"'";
			}
			
			if(null!=_leave.getAsk_leave_accept()) {
				sql+=" AND ASK_LEAVE_ACCEPT='"+_leave.getAsk_leave_accept()+"'";
			}
			
			if(null!=_leave.getM_id()) {
				sql+=" AND M_ID='"+_leave.getM_id()+"'";
			}
			
			if(null!=_leave.getEmpno()) {
				sql+=" AND EMPNO='"+_leave.getEmpno()+"'";
			}
			
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Neu_Ask_Leave leave=new Neu_Ask_Leave();
				
				Long id=rs.getLong("ASK_LEAVE_ID");
				leave.setAsk_leave_id(id);
				
				Timestamp leave_begin=rs.getTimestamp("ASK_LEAVE_TIME_BEGIN");
				if(null!=leave_begin) leave.setAsk_leave_begin(leave_begin.getTime());
						
				Timestamp leave_end=rs.getTimestamp("ASK_LEAVE_TIME_END");
				if(null!=leave_end) leave.setAsk_leave_end(leave_end.getTime());
				
				String leave_type=rs.getString("ASK_LEAVE_TYPE");
				leave.setAsk_leave_type(leave_type);
						
				String leave_reason=rs.getString("ASK_LEAVE_REASON");
				leave.setAsk_leave_reason(leave_reason);
				
				Long neu_accept=rs.getLong("ASK_LEAVE_ACCEPT");
				leave.setAsk_leave_accept(neu_accept);
				
				Long m_id=rs.getLong("M_ID");
				leave.setM_id(m_id);
				
				Long empno=rs.getLong("EMPNO");
				leave.setEmpno(empno);
				
				list.add(leave);
				
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
	public List<Neu_Ask_Leave> findByPage(int page, int total, Connection conn) {
		List<Neu_Ask_Leave> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT RN,ASK_LEAVE_ID,ASK_LEAVE_TIME_BEGIN,ASK_LEAVE_TIME_END,ASK_LEAVE_TYPE,ASK_LEAVE_REASON,ASK_LEAVE_ACCEPT,M_ID,EMPNO " + 
					"FROM (SELECT ROWNUM RN,ASK_LEAVE_ID,ASK_LEAVE_TIME_BEGIN,ASK_LEAVE_TIME_END,ASK_LEAVE_TYPE,ASK_LEAVE_REASON,ASK_LEAVE_ACCEPT,M_ID,EMPNO FROM NEU_ASK_LEAVE WHERE ROWNUM<=?) " + 
					"WHERE RN>=?";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, page*total);
			ps.setLong(2, (page-1)*total);
			rs=ps.executeQuery();
			while(rs.next()) {
				Neu_Ask_Leave leave=new Neu_Ask_Leave();
				
				Long id=rs.getLong("ASK_LEAVE_ID");
				leave.setAsk_leave_id(id);
				
				Timestamp leave_begin=rs.getTimestamp("ASK_LEAVE_TIME_BEGIN");
				if(null!=leave_begin) leave.setAsk_leave_begin(leave_begin.getTime());
						
				Timestamp leave_end=rs.getTimestamp("ASK_LEAVE_TIME_END");
				if(null!=leave_end) leave.setAsk_leave_end(leave_end.getTime());
				
				String leave_type=rs.getString("ASK_LEAVE_TYPE");
				leave.setAsk_leave_type(leave_type);
						
				String leave_reason=rs.getString("ASK_LEAVE_REASON");
				leave.setAsk_leave_reason(leave_reason);
				
				Long neu_accept=rs.getLong("ASK_LEAVE_ACCEPT");
				leave.setAsk_leave_accept(neu_accept);
				
				Long m_id=rs.getLong("M_ID");
				leave.setM_id(m_id);
				
				Long empno=rs.getLong("EMPNO");
				leave.setEmpno(empno);
				
				list.add(leave);
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
