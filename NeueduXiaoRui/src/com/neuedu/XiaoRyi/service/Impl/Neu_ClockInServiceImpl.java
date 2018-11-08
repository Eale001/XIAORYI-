package com.neuedu.XiaoRyi.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.XiaoRyi.Dao.Neu_ClockInMapper;
import com.neuedu.XiaoRyi.pojo.Neu_CLOCKIN;
import com.neuedu.XiaoRyi.service.Neu_ClockInService;

@Service("autoClockService")
public class Neu_ClockInServiceImpl implements Neu_ClockInService {
	
	//private Neu_ClockInDao neu_clockindao=(Neu_ClockInDao) FactoryUtil.getInstanceObjectByName("Neu_ClockInDao");
	
	@Autowired
	private Neu_ClockInMapper neu_clockindao;
	
	@Override
	public void add(Neu_CLOCKIN clockin) {
		neu_clockindao.add(clockin);
	}

	@Override
	public void update(Neu_CLOCKIN clockin) {
		
		neu_clockindao.update(clockin);
		
	}

	@Override
	public Optional<Neu_CLOCKIN> findById(Long id) {
		
		return Optional.of(neu_clockindao.findById(id));
	}

	@Override
	public List<Neu_CLOCKIN> findByExample(Neu_CLOCKIN clockin) {
		
		return neu_clockindao.findByExample(clockin);
		
	}

	@Override
	public List<Neu_CLOCKIN> findAll() {
		
		return neu_clockindao.findAll();
	}

//	@Override
//	public List<Neu_CLOCKIN> findBypage(int page,int total) {
//		
//		return neu_clockindao.findByPage(page, total);
//	}

}
