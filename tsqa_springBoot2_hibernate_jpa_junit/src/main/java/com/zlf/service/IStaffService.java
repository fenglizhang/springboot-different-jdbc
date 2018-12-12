package com.zlf.service;

import java.util.List;

import com.zlf.bo.StaffBo;

public interface IStaffService {
	//根据id查询
	public StaffBo getStaffBoById(String id);
	//查询所有
	public List<StaffBo> queryAllStaffList();
	//新增staff
	public StaffBo addStaffBo(StaffBo sta);
	//更新staff
	public void updataStaffBo(StaffBo st);
	//删除staff
	public void deleteStaffBo(StaffBo st);
	
}
