package com.neuedu.XiaoRyi.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.XiaoRyi.Dao.Neu_AccountMapper;
import com.neuedu.XiaoRyi.pojo.Neu_Account;
import com.neuedu.XiaoRyi.service.Neu_AccountService;

@Service("autoaccountService")
public class Neu_AccountServiceImpl implements Neu_AccountService {
	
	//Neu_AccountDao neu_accountdao=(Neu_AccountDao) FactoryUtil.getInstanceObjectByName("Neu_AccountDao");
	
	@Autowired
	private Neu_AccountMapper neu_accountdao;
	
	@Override
	public Optional<Neu_Account> login(String account, String pwd) {
		try {
			
			Neu_Account manager=new Neu_Account();
			manager.setNei_empno(Long.parseLong(account));
			manager.setNeu_pwd(pwd);
			
			List<Neu_Account> list= neu_accountdao.findByExample(manager);
			if(list.size()>0) {
				
				return Optional.of(list.get(0));
			}else {
				
				return Optional.empty();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void register(Neu_Account acount) {
		try {
			neu_accountdao.add(acount);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Neu_Account account) {
		try {
			neu_accountdao.update(account);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean delete(long id) {
		try {
			neu_accountdao.delete(id);
			return true;
		}catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Optional<Neu_Account> findById(long id) {
		
		Neu_Account account=neu_accountdao.findById(id);
		
		return Optional.of(account);
			
	}

	@Override
	public List<Neu_Account> findByExample(Neu_Account acount) {
		
		return neu_accountdao.findByExample(acount);
		
	}

	@Override
	public List<Neu_Account> findAll() {
		
		return neu_accountdao.findAll();
	}

	@Override
	public List<Neu_Account> findPage(String page, String total) {
		Integer p=Integer.parseInt(page);
		Integer t=Integer.parseInt(total);
		return neu_accountdao.findByPage(p, t);
	}

}
