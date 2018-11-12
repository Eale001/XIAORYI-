package com.neuedu.XiaoRyi.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.XiaoRyi.Mapper.Neu_ask_leaveMapper;
import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

@Service("autoleaveService")
public class Neu_ask_leaveServiceImpl implements Neu_ask_leaveService {
	
	//private Neu_ask_leaveDao neu_ask_leavedao=(Neu_ask_leaveDao) FactoryUtil.getInstanceObjectByName("Neu_ask_leaveDao");
	
	@Autowired
	private Neu_ask_leaveMapper neu_ask_leavedao;
	
	
	@Override
	public void add(Neu_Ask_Leave leave) {
		neu_ask_leavedao.add(leave);
	}

	@Override
	public boolean deleted(Long id) {
		
		neu_ask_leavedao.delete(id);
		return true;
	}

	@Override
	public void update(Neu_Ask_Leave leave) {
		neu_ask_leavedao.update(leave);
	}

	@Override
	public List<Neu_Ask_Leave> findByExample(Neu_Ask_Leave leave) {
		
		return neu_ask_leavedao.findByExample(leave);
	}

	@Override
	public List<Neu_Ask_Leave> findAll() {
		return neu_ask_leavedao.findAll();
	}


	@Override
	public List<Neu_Ask_Leave> findByPageEmp(Page page, Neu_Ask_Leave leave) {
		return neu_ask_leavedao.findByPageEmp(page, leave);
	}

	@Override
	public List<Neu_Ask_Leave> findByPageAccount(int page, int total) {
		
		return neu_ask_leavedao.findByPageAccout(page, total);
	}

}
