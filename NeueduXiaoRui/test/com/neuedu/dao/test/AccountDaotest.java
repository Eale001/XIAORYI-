package com.neuedu.dao.test;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.neuedu.XiaoRyi.Dao.Neu_AccountDao;
import com.neuedu.XiaoRyi.Util.DBUtil;
import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Account;

public class AccountDaotest {
	
	Neu_AccountDao neu_accountdao=null;
	Connection conn=null;
	Neu_Account account=null;
	
	@Before
	public void init() {
		neu_accountdao=(Neu_AccountDao) FactoryUtil.getInstanceObjectByName("Neu_AccountDao");
		conn=DBUtil.getOracleConnection();
		account=new Neu_Account();
		
	}
	@Test
	public void findExample() {
		account.setNei_empno((long)10);
		List<Neu_Account> list=neu_accountdao.findByExample(account, conn);
		for (Neu_Account neu_Account : list) {
			System.out.println(neu_Account.getM_id());
			System.out.println(neu_Account.getNei_empno());
			System.out.println(neu_Account.getNeu_pwd());
			System.out.println(neu_Account.getNeu_power_level());
			System.out.println("------");
		}
	}
	
	@Test
	public void findAll() {
		List<Neu_Account> list=neu_accountdao.findAll(conn);
		for (Neu_Account neu_Account : list) {
			System.out.println(neu_Account.getM_id());
			System.out.println(neu_Account.getNei_empno());
			System.out.println(neu_Account.getNeu_pwd());
			System.out.println(neu_Account.getNeu_power_level());
			System.out.println("------");
		}
	}
	
	@Test
	public void findById() {
		Long id=(long)21;
		Optional<Neu_Account> opt=neu_accountdao.findById(id, conn);
		System.out.println(opt.get().getM_id());
		System.out.println(opt.get().getNei_empno());
		System.out.println(opt.get().getNeu_pwd());
		System.out.println(opt.get().getNeu_power_level());
	}
	
	@Test
	public void update() {
		account.setM_id((long)21);
		account.setNei_empno((long)10);
		account.setNeu_power_level((long)2);
		neu_accountdao.update(account, conn);
	}
	
	@Test 
	public void delete() {
		Long id=(long) 20;
		neu_accountdao.delete(id, conn);
	}
	
	@Test
	public void add() {
		account.setNei_empno((long)38);
		account.setNeu_pwd("11111111");
		account.setNeu_power_level((long)1);
		neu_accountdao.add(account, conn);
	}
}
