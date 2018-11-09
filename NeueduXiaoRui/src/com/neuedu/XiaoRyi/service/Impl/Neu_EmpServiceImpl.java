package com.neuedu.XiaoRyi.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.XiaoRyi.Mapper.Neu_EmpMapper;
import com.neuedu.XiaoRyi.pojo.Neu_Account;
import com.neuedu.XiaoRyi.pojo.Neu_Emp;
import com.neuedu.XiaoRyi.service.Neu_EmpService;

@Service("autoempService")
public class Neu_EmpServiceImpl implements Neu_EmpService {
	
	//private Neu_EmpDao neu_empdao=(Neu_EmpDao) FactoryUtil.getInstanceObjectByName("Neu_EmpDao");
	
	@Autowired
	private Neu_EmpMapper neu_empdao;
	
	@Override
	public Optional<Neu_Account> login(String name, String pwd) {
		
		return null;
	}

	@Override
	public void add(Neu_Emp emp) {
		neu_empdao.add(emp);
	}

	@Override
	public void update(Neu_Emp emp) {
		neu_empdao.update(emp);
	}

	@Override
	public void deleted(Long id) {
		
		neu_empdao.delete(id);
		
	}

	@Override
	public Optional<Neu_Emp> findById(Long id) {
		
		return Optional.of(neu_empdao.findById(id));
	}

	@Override
	public List<Neu_Emp> findByExample(Neu_Emp emp) {
		
		return neu_empdao.findByExample(emp);
	}

	@Override
	public List<Neu_Emp> findAll() {
		
		return neu_empdao.findAll();
	}

	@Override
	public List<Neu_Emp> findByPage(String page, String total) {
		Integer p=Integer.parseInt(page);
		Integer t=Integer.parseInt(total);
		return neu_empdao.findByPage(p, t);
	}

}
