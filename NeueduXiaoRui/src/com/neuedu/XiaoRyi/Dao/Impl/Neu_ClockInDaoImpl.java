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

import com.neuedu.XiaoRyi.Dao.Neu_ClockInDao;
import com.neuedu.XiaoRyi.entity.Neu_CLOCKIN;

public class Neu_ClockInDaoImpl implements Neu_ClockInDao {

	@Override
	public void add(Neu_CLOCKIN clockin, Connection conn) {
		Statement st=null;
		try {
			st=conn.createStatement();
			
			String sql="INSERT INTO NEU_CLOCKIN (NEU_CLOCKIN_ID,$keys) VALUES (SQ_NEU_CLOCKIN_ID.nextval,$values) ";
			
			String keys="";
			String values="";
			
			//拼接字符串
			
			DateFormat format=  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
			if(null!=clockin.getNeu_clockin_startin()) {
				keys+=" NEU_CLOCKIN_STARTIN,";
				String clockin_startin = format.format(clockin.getNeu_clockin_startin());
				values+=" TO_TIMESTAMP('"+clockin_startin+"','yyyy-MM-dd hh24:mi:ss'),";
			}
			
			if(null!=clockin.getNeu_clockin_startout()) {
				keys+=" NEU_CLOCKIN_STARTOUT,";
				String clockin_startout = format.format(clockin.getNeu_clockin_startout());
				values+=" TO_TIMESTAMP('"+clockin_startout+"','yyyy-MM-dd hh24:mi:ss'),";
				
			}
			
			if(null!=clockin.getNeu_empno()) {
				keys+=" NEU_EMPNO,";
				values+=" '"+clockin.getNeu_empno()+"',";
			}
			
			if(null!=clockin.getNeu_retroactivein()) {
				keys+=" NEU_RETROACTIVEIN,";
				String retroactivein = format.format(clockin.getNeu_retroactivein());
				values+=" TO_TIMESTAMP('"+retroactivein+"','yyyy-MM-dd hh24:mi:ss'),";
			}
			
			if(null!=clockin.getNeu_retroactiveout()) {
				keys+=" NEU_RETROACTIVEOUT,";
				String  retroactiveout= format.format(clockin.getNeu_retroactiveout());
				values+=" TO_TIMESTAMP('"+retroactiveout+"','yyyy-MM-dd hh24:mi:ss'),";
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
	public void delete(Long clock_id, Connection conn) {
		PreparedStatement ps=null;
		try {
			String sql="DELETE NEU_CLOCKIN WHERE  NEU_CLOCKIN_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setLong(1, clock_id);
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
	public void update(Neu_CLOCKIN clockin, Connection conn) {
		Statement st=null;
		try {
			st=conn.createStatement();
			
			String sql="UPDATE NEU_CLOCKIN SET $list WHERE NEU_EMPNO="+clockin.getNeu_empno();
			
			String list="";
			
			//拼接字符串
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if(null!=clockin.getNeu_clockin_startin()) {
				String  clockin_startin= format.format(clockin.getNeu_clockin_startin());
				
				list+=" NEU_CLOCKIN_STARTIN= TO_TIMESTAMP('"+clockin_startin+"','yyyy-MM-dd hh24:mi:ss'),";
				
				
				//list+=" NEU_CLOCKIN_STARTIN='"+clockin.getNeu_clockin_startin()+"',";
			}
			
			if(null!=clockin.getNeu_clockin_startout()) {
				String  clockin_startout= format.format(clockin.getNeu_clockin_startout());
				
				list+=" NEU_CLOCKIN_STARTOUT= TO_TIMESTAMP('"+clockin_startout+"','yyyy-MM-dd hh24:mi:ss'),";
				
			}
			
//			if(null!=clockin.getNeu_empno()) {
//				list+=" NEU_EMPNO='"+clockin.getNeu_empno()+"',";
//			}
			
			if(null!=clockin.getNeu_retroactivein()) {
				String  retroactivein= format.format(clockin.getNeu_retroactivein());
				
				list+=" NEU_RETROACTIVEIN= TO_TIMESTAMP('"+retroactivein+"','yyyy-MM-dd hh24:mi:ss'),";
				
			}
			
			if(null!=clockin.getNeu_retroactiveout()) {
				String  retroactiveout= format.format(clockin.getNeu_retroactiveout());
				
				list+=" NEU_RETROACTIVEOUT= TO_TIMESTAMP('"+retroactiveout+"','yyyy-MM-dd hh24:mi:ss'),";
				
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
	public Optional<Neu_CLOCKIN> findById(Long clock_id, Connection conn) {
		Optional<Neu_CLOCKIN> opt=Optional.empty();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT NEU_CLOCKIN_ID,NEU_CLOCKIN_STARTIN,NEU_CLOCKIN_STARTOUT,NEU_EMPNO,NEU_RETROACTIVEIN,NEU_RETROACTIVEOUT FROM NEU_CLOCKIN WHERE NEU_CLOCKIN_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, clock_id);
			rs=ps.executeQuery();
			if(rs.next()) {
				Neu_CLOCKIN clockin=new Neu_CLOCKIN();
				
				Long id=rs.getLong("NEU_CLOCKIN_ID");
				clockin.setNeu_clockin_id(id);
				
				Timestamp clock_in=rs.getTimestamp("NEU_CLOCKIN_STARTIN");
				clockin.setNeu_clockin_startin(clock_in.getTime());
				
				Timestamp clock_out=rs.getTimestamp("NEU_CLOCKIN_STARTOUT");
				clockin.setNeu_clockin_startout(clock_out.getTime());
				
				
				
				Long empno=rs.getLong("NEU_EMPNO");
				clockin.setNeu_empno(empno);
						
				Timestamp retroactivein=rs.getTimestamp("NEU_RETROACTIVEIN");
				if(null!=retroactivein) clockin.setNeu_retroactivein(retroactivein.getTime());
				
				Timestamp retroactiveout=rs.getTimestamp("NEU_RETROACTIVEOUT");
				if(null!=retroactiveout) clockin.setNeu_retroactiveout(retroactiveout.getTime());
				
				
				opt=Optional.of(clockin);
				
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
	public List<Neu_CLOCKIN> findAll(Connection conn) {
		List<Neu_CLOCKIN> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT NEU_CLOCKIN_ID,NEU_CLOCKIN_STARTIN,NEU_CLOCKIN_STARTOUT,NEU_EMPNO,NEU_RETROACTIVEIN,NEU_RETROACTIVEOUT FROM NEU_CLOCKIN ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Neu_CLOCKIN clockin=new Neu_CLOCKIN();
				
				Long id=rs.getLong("NEU_CLOCKIN_ID");
				clockin.setNeu_clockin_id(id);
				
				Timestamp clock_in=rs.getTimestamp("NEU_CLOCKIN_STARTIN");
				if(null!=clock_in) clockin.setNeu_clockin_startin(clock_in.getTime());
				
				
				Timestamp clock_out=rs.getTimestamp("NEU_CLOCKIN_STARTOUT");
				if(null!=clock_out) clockin.setNeu_clockin_startout(clock_out.getTime());
				
			
				
				Long empno=rs.getLong("NEU_EMPNO");
				clockin.setNeu_empno(empno);
				
				Timestamp retroactivein=rs.getTimestamp("NEU_RETROACTIVEIN");
				if(null!=retroactivein) clockin.setNeu_retroactivein(retroactivein.getTime());
				
				Timestamp retroactiveout=rs.getTimestamp("NEU_RETROACTIVEOUT");
				if(null!=retroactiveout) clockin.setNeu_retroactiveout(retroactiveout.getTime());
				
				list.add(clockin);
				
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
	public List<Neu_CLOCKIN> findByExample(Neu_CLOCKIN _clockin, Connection conn) {
		List<Neu_CLOCKIN> list=new ArrayList<>();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			String sql="SELECT NEU_CLOCKIN_ID,NEU_CLOCKIN_STARTIN,NEU_CLOCKIN_STARTOUT,NEU_EMPNO,NEU_RETROACTIVEIN,NEU_RETROACTIVEOUT FROM NEU_CLOCKIN WHERE 1=1 ";
			
			//拼接字符串
			
//			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if(null!=_clockin.getNeu_clockin_id()) {
				
//				String  retroactiveout= format.format(_clockin.getNeu_clockin_id());
//				sql+=" AND NEU_CLOCKIN_ID= TO_TIMESTAMP('"+retroactiveout+"','yyyy-MM-dd hh24:mi:ss') ";
				
				sql+=" AND NEU_CLOCKIN_ID='"+_clockin.getNeu_clockin_id()+"'";
			}
			
			if(null!=_clockin.getNeu_clockin_startin()) {
				sql+=" AND NEU_CLOCKIN_STARTIN='"+_clockin.getNeu_clockin_startin()+"'";
			}
			
			if(null!=_clockin.getNeu_clockin_startout()) {
				sql+=" AND NEU_CLOCKIN_STARTOUT='"+_clockin.getNeu_clockin_startout()+"'";
			}
			
			if(null!=_clockin.getNeu_empno()) {
				sql+=" AND NEU_EMPNO='"+_clockin.getNeu_empno()+"'";
			}
			
			if(null!=_clockin.getNeu_retroactivein()) {
				sql+=" AND NEU_RETROACTIVEIN='"+_clockin.getNeu_retroactivein()+"'";
			}
			
			if(null!=_clockin.getNeu_retroactiveout()) {
				sql+=" AND NEU_RETROACTIVEOUT='"+_clockin.getNeu_retroactiveout()+"'";
			}
			
			
			System.out.println(sql);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Neu_CLOCKIN clockin=new Neu_CLOCKIN();
				
				Long id=rs.getLong("NEU_CLOCKIN_ID");
				clockin.setNeu_clockin_id(id);
				
				Timestamp clock_in=rs.getTimestamp("NEU_CLOCKIN_STARTIN");
				if(null!=clock_in) clockin.setNeu_clockin_startin(clock_in.getTime());
				
				
				Timestamp clock_out=rs.getTimestamp("NEU_CLOCKIN_STARTOUT");
				if(null!=clock_out) clockin.setNeu_clockin_startout(clock_out.getTime());
				
			
				
				Long empno=rs.getLong("NEU_EMPNO");
				clockin.setNeu_empno(empno);
				
				Timestamp retroactivein=rs.getTimestamp("NEU_RETROACTIVEIN");
				if(null!=retroactivein) clockin.setNeu_retroactivein(retroactivein.getTime());
				
				Timestamp retroactiveout=rs.getTimestamp("NEU_RETROACTIVEOUT");
				if(null!=retroactiveout) clockin.setNeu_retroactiveout(retroactiveout.getTime());
				
				
				list.add(clockin);
				
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
	public List<Neu_CLOCKIN> findByPage(int page, int total, Connection conn) {
		List<Neu_CLOCKIN> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT RN,NEU_CLOCKIN_ID,NEU_CLOCKIN_STARTIN,NEU_CLOCKIN_STARTOUT,NEU_EMPNO,NEU_RETROACTIVEIN,NEU_RETROACTIVEOUT " + 
					"FROM (SELECT ROWNUM RN,NEU_CLOCKIN_ID,NEU_CLOCKIN_STARTIN,NEU_CLOCKIN_STARTOUT,NEU_EMPNO,NEU_RETROACTIVEIN,NEU_RETROACTIVEOUT FROM NEU_CLOCKIN WHERE ROWNUM<=?) " + 
					"WHERE RN>=?";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, page*total);
			ps.setLong(2, page*(total-1));
			rs=ps.executeQuery();
			while(rs.next()) {
				Neu_CLOCKIN clockin=new Neu_CLOCKIN();
				
				Long id=rs.getLong("NEU_CLOCKIN_ID");
				clockin.setNeu_clockin_id(id);
				
				Timestamp clock_in=rs.getTimestamp("NEU_CLOCKIN_STARTIN");
				if(null!=clock_in) clockin.setNeu_clockin_startin(clock_in.getTime());
				
				
				Timestamp clock_out=rs.getTimestamp("NEU_CLOCKIN_STARTOUT");
				if(null!=clock_out) clockin.setNeu_clockin_startout(clock_out.getTime());
				
			
				
				Long empno=rs.getLong("NEU_EMPNO");
				clockin.setNeu_empno(empno);
				
				Timestamp retroactivein=rs.getTimestamp("NEU_RETROACTIVEIN");
				if(null!=retroactivein) clockin.setNeu_retroactivein(retroactivein.getTime());
				
				Timestamp retroactiveout=rs.getTimestamp("NEU_RETROACTIVEOUT");
				if(null!=retroactiveout) clockin.setNeu_retroactiveout(retroactiveout.getTime());
				
				
				list.add(clockin);
				
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
