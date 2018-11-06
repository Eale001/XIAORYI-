package com.neuedu.XiaoRyi.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.neuedu.XiaoRyi.Dao.Neu_EmpDao;
import com.neuedu.XiaoRyi.entity.Neu_Emp;

public class Neu_EmpDaoImpl implements Neu_EmpDao {

	@Override
	public void add(Neu_Emp emp, Connection conn) {
		Statement st=null;
		try {
			st=conn.createStatement();
			
			String sql="INSERT INTO NEU_EMP (NEU_ID,$keys) VALUES (SQ_NEU_EMP_ID.nextval,$values) ";
			
			String keys="";
			String values="";
			
			//拼接字符串

			if(null!=emp.getNeu_name()) {
				keys+=" NEU_NAME,";
				values+=" '"+emp.getNeu_name()+"',";
			}
			
			if(null!=emp.getNeu_email()) {
				keys+=" NEU_EMAIL,";
				values+=" '"+emp.getNeu_email()+"',";
			}
			
			if(null!=emp.getNeu_tel()) {
				keys+=" NEU_TEL,";
				values+=" '"+emp.getNeu_tel()+"',";
			}
			
			if(null!=emp.getNeu_addre()) {
				keys+=" NEU_ADDRE,";
				values+=" '"+emp.getNeu_addre()+"',";
			}
			
			if(null!=emp.getNeu_age()) {
				keys+=" NEU_AGE,";
				values+=" '"+emp.getNeu_age()+"',";
			}
			
			if(null!=emp.getNeu_sex()) {
				keys+=" NEU_GENDER,";
				values+=" '"+emp.getNeu_sex()+"',";
			}
			
			if(null!=emp.getNeu_empno()) {
				keys+=" NEU_EMPNO,";
				values+=" '"+emp.getNeu_empno()+"',";
			}
			
			if(null!=emp.getNeu_delete()) {
				keys+=" NEU_DELETE,";
				values+=" '"+emp.getNeu_delete()+"',";
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
	public void delete(Long emp_id, Connection conn) {
		PreparedStatement ps=null;
		try {
			String sql="DELETE NEU_EMP WHERE NEU_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setLong(1, emp_id);
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
	public void update(Neu_Emp emp, Connection conn) {
		Statement st=null;
		try {
			st=conn.createStatement();
			
			String sql="UPDATE NEU_EMP SET $list WHERE NEU_ID="+emp.getNeu_id();
			
			String list="";
			
			//拼接字符串
			
			if(null!=emp.getNeu_name()) {
				list+=" NEU_NAME='"+emp.getNeu_name()+"',";
			}
			
			if(null!=emp.getNeu_email()) {
				list+=" NEU_EMAIL='"+emp.getNeu_email()+"',";
			}
			
			if(null!=emp.getNeu_tel()) {
				list+=" NEU_TEL='"+emp.getNeu_tel()+"',";
			}
			
			if(null!=emp.getNeu_addre()) {
				list+=" NEU_ADDRE='"+emp.getNeu_addre()+"',";
			}
			
			if(null!=emp.getNeu_age()) {
				list+=" NEU_AGE='"+emp.getNeu_age()+"',";
			}
			
			if(null!=emp.getNeu_sex()) {
				list+=" NEU_GENDER='"+emp.getNeu_sex()+"',";
			}
			
			if(null!=emp.getNeu_empno()) {
				list+=" NEU_EMPNO='"+emp.getNeu_empno()+"',";
			}
			
			if(null!=emp.getNeu_delete()) {
				list+=" NEU_DELETE='"+emp.getNeu_delete()+"',";
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
	public Optional<Neu_Emp> findById(Long emp_id, Connection conn) {
		Optional<Neu_Emp> opt=Optional.empty();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT NEU_ID,NEU_NAME,NEU_EMAIL,NEU_TEL,NEU_ADDRE,NEU_AGE,NEU_GENDER,NEU_EMPNO,NEU_DELETE FROM NEU_EMP WHERE NEU_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, emp_id);
			rs=ps.executeQuery();
			if(rs.next()) {
				Neu_Emp emp=new Neu_Emp();
				
				Long id=rs.getLong("NEU_ID");
				emp.setNeu_id(id);
				
				String name=rs.getString("NEU_NAME");
				emp.setNeu_name(name);
				
				String email=rs.getString("NEU_EMAIL");
				emp.setNeu_email(email);
				
				Long tel=rs.getLong("NEU_TEL");
				emp.setNeu_tel(tel);
						
				String addre=rs.getString("NEU_ADDRE");
				emp.setNeu_addre(addre);
				
				Long age=rs.getLong("NEU_AGE");
				emp.setNeu_age(age);
				
				Long sex=rs.getLong("NEU_GENDER");
				emp.setNeu_sex(sex);
				
				Long empno=rs.getLong("NEU_EMPNO");
				emp.setNeu_empno(empno);
				
				Long neu_delete=rs.getLong("NEU_DELETE");
				emp.setNeu_delete(neu_delete);
				
				opt=Optional.of(emp);
				
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
	public List<Neu_Emp> findAll(Connection conn) {
		List<Neu_Emp> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT NEU_ID,NEU_NAME,NEU_EMAIL,NEU_TEL,NEU_ADDRE,NEU_AGE,NEU_GENDER,NEU_EMPNO,NEU_DELETE FROM NEU_EMP ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Neu_Emp emp=new Neu_Emp();
				
				Long id=rs.getLong("NEU_ID");
				emp.setNeu_id(id);
				
				String name=rs.getString("NEU_NAME");
				emp.setNeu_name(name);
				
				String email=rs.getString("NEU_EMAIL");
				emp.setNeu_email(email);
				
				Long tel=rs.getLong("NEU_TEL");
				emp.setNeu_tel(tel);
						
				String addre=rs.getString("NEU_ADDRE");
				emp.setNeu_addre(addre);
				
				Long age=rs.getLong("NEU_AGE");
				emp.setNeu_age(age);
				
				Long sex=rs.getLong("NEU_GENDER");
				emp.setNeu_sex(sex);
				
				Long empno=rs.getLong("NEU_EMPNO");
				emp.setNeu_empno(empno);
				
				Long neu_delete=rs.getLong("NEU_DELETE");
				emp.setNeu_delete(neu_delete);
				
				list.add(emp);				
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
	public List<Neu_Emp> findByExample(Neu_Emp _emp, Connection conn) {
		List<Neu_Emp> list=new ArrayList<>();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			String sql="SELECT NEU_ID,NEU_NAME,NEU_EMAIL,NEU_TEL,NEU_ADDRE,NEU_AGE,NEU_GENDER,NEU_EMPNO,NEU_DELETE FROM NEU_EMP WHERE 1=1 ";
			
			//拼接字符串
			
			if(null!=_emp.getNeu_name()) {
				sql+=" AND NEU_NAME='"+_emp.getNeu_name()+"'";
			}
			
			if(null!=_emp.getNeu_email()) {
				sql+=" AND NEU_EMAIL='"+_emp.getNeu_email()+"'";
			}
			
			if(null!=_emp.getNeu_tel()) {
				sql+=" AND NEU_TEL='"+_emp.getNeu_tel()+"'";
			}
			
			if(null!=_emp.getNeu_addre()) {
				sql+=" AND NEU_ADDRE='"+_emp.getNeu_addre()+"'";
			}
			
			if(null!=_emp.getNeu_age()) {
				sql+=" AND NEU_AGE='"+_emp.getNeu_age()+"'";
			}
			
			if(null!=_emp.getNeu_sex()) {
				sql+=" AND NEU_GENDER='"+_emp.getNeu_sex()+"'";
			}
			
			if(null!=_emp.getNeu_empno()) {
				sql+=" AND NEU_EMPNO='"+_emp.getNeu_empno()+"'";
			}
			
			if(null!=_emp.getNeu_delete()) {
				sql+=" AND NEU_DELETE='"+_emp.getNeu_delete()+"'";
			}
			
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Neu_Emp emp=new Neu_Emp();
				
				Long id=rs.getLong("NEU_ID");
				emp.setNeu_id(id);
				
				String name=rs.getString("NEU_NAME");
				emp.setNeu_name(name);
				
				String email=rs.getString("NEU_EMAIL");
				emp.setNeu_email(email);
				
				Long tel=rs.getLong("NEU_TEL");
				emp.setNeu_tel(tel);
						
				String addre=rs.getString("NEU_ADDRE");
				emp.setNeu_addre(addre);
				
				Long age=rs.getLong("NEU_AGE");
				emp.setNeu_age(age);
				
				Long sex=rs.getLong("NEU_GENDER");
				emp.setNeu_sex(sex);
				
				Long empno=rs.getLong("NEU_EMPNO");
				emp.setNeu_empno(empno);
				
				Long neu_delete=rs.getLong("NEU_DELETE");
				emp.setNeu_delete(neu_delete);
				
				list.add(emp);				
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
	public List<Neu_Emp> findByPage(int page, int total, Connection conn) {
		List<Neu_Emp> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT NEU_ID,NEU_NAME,NEU_EMAIL,NEU_TEL,NEU_ADDRE,NEU_AGE,NEU_GENDER,NEU_EMPNO,NEU_DELETE " + 
					"FROM (SELECT ROWNUM RN, NEU_ID,NEU_NAME,NEU_EMAIL,NEU_TEL,NEU_ADDRE,NEU_AGE,NEU_GENDER,NEU_EMPNO,NEU_DELETE FROM NEU_EMP WHERE ROWNUM<=? )" + 
					"WHERE RN>=?";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, page*total);
			ps.setLong(2, (page-1)*total);
			rs=ps.executeQuery();
			while(rs.next()) {
				Neu_Emp emp=new Neu_Emp();
				
				Long id=rs.getLong("NEU_ID");
				emp.setNeu_id(id);
				
				String name=rs.getString("NEU_NAME");
				emp.setNeu_name(name);
				
				String email=rs.getString("NEU_EMAIL");
				emp.setNeu_email(email);
				
				Long tel=rs.getLong("NEU_TEL");
				emp.setNeu_tel(tel);
						
				String addre=rs.getString("NEU_ADDRE");
				emp.setNeu_addre(addre);
				
				Long age=rs.getLong("NEU_AGE");
				emp.setNeu_age(age);
				
				Long sex=rs.getLong("NEU_GENDER");
				emp.setNeu_sex(sex);
				
				Long empno=rs.getLong("NEU_EMPNO");
				emp.setNeu_empno(empno);
				
				Long neu_delete=rs.getLong("NEU_DELETE");
				emp.setNeu_delete(neu_delete);
				
				list.add(emp);				
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
