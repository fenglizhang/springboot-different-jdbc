package com.zlf.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlf.bo.StaffBo;
import com.zlf.repository.StaffRepository;
import com.zlf.service.IStaffService;

@Service
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public List<StaffBo> queryAllStaffList() {
		Iterable<StaffBo> iterable = staffRepository.findAll();
		List<StaffBo> list = new ArrayList<StaffBo>();
		Iterator<StaffBo> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			StaffBo next = iterator.next();
			list.add(next);
		}
		return list;
	}

	@Override
	public StaffBo getStaffBoById(String id) {
		StaffBo staffBo = staffRepository.findOne(id);
		return staffBo;
	}

	@Override
	public StaffBo addStaffBo(StaffBo sta) {
		// TODO Auto-generated method stub
		System.out.println("-------进入新增的方法了----------"+sta.toString());
		return staffRepository.save(sta);
	}

	@Override
	public void updataStaffBo(StaffBo st) {
		// TODO Auto-generated method stub
		staffRepository.save(st);

	}

	@Override
	public void deleteStaffBo(StaffBo st) {
		// TODO Auto-generated method stub
		staffRepository.delete(st);
	}

}
