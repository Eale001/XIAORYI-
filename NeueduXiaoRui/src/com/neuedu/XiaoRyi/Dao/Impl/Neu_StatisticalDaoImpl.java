package com.neuedu.XiaoRyi.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.neuedu.XiaoRyi.Dao.Neu_StatisticalDao;
import com.neuedu.XiaoRyi.entity.StatisticWork;

public class Neu_StatisticalDaoImpl implements Neu_StatisticalDao {

	@Override
	public Optional<StatisticWork> findrealitywork(Long empno,String startin,String startout,Connection conn) {
		Optional<StatisticWork> opt=Optional.empty();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="SELECT COUNT(*) TOTAL FROM NEU_CLOCKIN WHERE  NEU_EMPNO=? " + 
					" AND NEU_CLOCKIN_STARTIN> TO_TIMESTAMP(?,'yyyy-MM-dd hh24:mi:ss') " + 
					" AND NEU_CLOCKIN_STARTIN< TO_TIMESTAMP(?,'yyyy-MM-dd hh24:mi:ss') ";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, empno);
			ps.setString(2,startin);
			ps.setString(3, startout);
			rs=ps.executeQuery();
			if(rs.next()) {
				StatisticWork stwork=new StatisticWork();
				Integer total=rs.getInt("TOTAL");
				stwork.setRealitywork(total);
				
				opt=Optional.of(stwork);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return opt;
	}

	@Override
	public Optional<StatisticWork> findlatework(Long empno,String startin,String startout,Connection conn) {
		
		return null;
	}

	@Override
	public Optional<StatisticWork> findearlywork(Long empno,String startin,String startout,Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<StatisticWork> findabsencework(Long empno,String startin,String startout,Connection conn) {
		Optional<StatisticWork> opt=Optional.empty();
	
		Integer needwork=com.neuedu.XiaoRyi.Util.TimeMinus.day(startin,startout);
		Optional<StatisticWork> opt1=findrealitywork(empno, startin, startout, conn);
		Integer absebce=needwork-opt1.get().getRealitywork();
			
		StatisticWork stwork=new StatisticWork();
		stwork.setAbsencework(absebce);
			
		opt=Optional.of(stwork);
		
		return opt;
	}

	@Override
	public Optional<StatisticWork> findaskleavework(Long empno,String startin,String startout,Connection conn) {
		return null;
	}

}
